package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.*;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Collections;

public class LaptopsAndNotebooksPageTest extends BaseTest {

    HomePage homePage;
    LaptopsAndNotebooksPage laptopsAndNotebooksPage;
    ShoppingCartPage shoppingCartPage;
    CheckOutPage checkOutPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {

        homePage = new HomePage();
        laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
        shoppingCartPage = new ShoppingCartPage();
        checkOutPage = new CheckOutPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyProductsPriceDisplayHighToLowSuccessfully(){
        homePage.mouseHoverOnLaptopsAndNotebooksTabAndClick();
        homePage.selectShowAllLaptopsAndNotebooksFromDropDown();
        Collections.sort(laptopsAndNotebooksPage.getProductNamesListedUnderLaptopsAndNotebooks(), Collections.reverseOrder());
        Assert.assertEquals(laptopsAndNotebooksPage.getProductNamesByPrice("Price (High > Low)"), laptopsAndNotebooksPage.getProductNamesListedUnderLaptopsAndNotebooks(),"Product not sorted by price High to Low");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatUserPlaceOrderSuccessfully()throws InterruptedException{
        SoftAssert softAssert = new SoftAssert();
        homePage.changeCurrency("£ Pound Sterling");
        homePage.mouseHoverOnLaptopsAndNotebooksTabAndClick();
        homePage.selectShowAllLaptopsAndNotebooksFromDropDown();
        laptopsAndNotebooksPage.selectSortByPrice("Price (High > Low)");
        laptopsAndNotebooksPage.clickOnProductMacBook();
        softAssert.assertEquals(laptopsAndNotebooksPage.getProductName(), "MacBook", "MacBook Product not display");
        laptopsAndNotebooksPage.clickOnAddToCartButton();
        softAssert.assertTrue(laptopsAndNotebooksPage.getTextToConfirmProductAddedToCart().contains("Success: You have added MacBook to your shopping cart!"), "Product not added to cart");
        shoppingCartPage.clickOnShoppingCartLinkInSuccessMessage();
        softAssert.assertTrue(shoppingCartPage.getPageNameShoppingCart().contains("Shopping Cart"), "Not navigated to Shopping Cart Page" );
        softAssert.assertEquals(shoppingCartPage.confirmMacBkProductName(), "MacBook", "Product name does not match");
        shoppingCartPage.updateQuantityToTwo("2");
        shoppingCartPage.clickToUpdateQty();
        softAssert.assertTrue(shoppingCartPage.confirmQtyUpdatedMessage().contains("Success: You have modified your shopping cart!"), "Cart not modified");
        softAssert.assertEquals(shoppingCartPage.getTheTotalAmount(), "£737.45", "Total does not match");
        shoppingCartPage.clickOnCheckoutButton();
        softAssert.assertEquals(checkOutPage.getPageNameCheckout(), "Checkout", "Not navigated to checkout");
        Thread.sleep(2000);
        softAssert.assertEquals(checkOutPage.verifyNewCustomerText(), "New Customer", "New Customer text not seen");
        checkOutPage.clickOnGuestCheckoutRadioButton();
        Thread.sleep(2000);
        checkOutPage.clickOnNewCustomerContinueButton();
        checkOutPage.enterFirstName("Testerhv"+ getRandomString(2));
        checkOutPage.enterLastName("Automater"+ getRandomString(2));
        checkOutPage.enterEmail("Testerhv"+getRandomString(2)+ "@gmail.com");
        checkOutPage.enterPhoneNo("07889966541");
        checkOutPage.enterAddressLn1("House 204");
        checkOutPage.enterCity("Manchester");
        checkOutPage.enterPostCode("M12 9AL");
        checkOutPage.selectCountryFromDropDown("United Kingdom");
        checkOutPage.selectRegionFromDropDown("Greater Manchester");
        checkOutPage.clickOnContinueGuestButton();
        checkOutPage.addCommentsAboutYourOrder("Thank You");
        checkOutPage.clickOnTermsAndConditionsCheckBox();
        checkOutPage.clickOnContinueButtonToProceedToPayment();
        softAssert.assertEquals(checkOutPage.getPaymentWarningMessage(), "Warning: Payment method required!\n" + "×", "Warning message not displayed");
        softAssert.assertAll();
    }
}
