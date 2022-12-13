package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.*;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Collections;

public class DesktopPageTest extends BaseTest {

    HomePage homePage;
    DesktopPage desktopPage;
    ShoppingCartPage shoppingCartPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        desktopPage = new DesktopPage();
        shoppingCartPage = new ShoppingCartPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyProductArrangeInAlphabeticalOrder() throws InterruptedException {
        homePage.mouseHoverOnDesktopsTabAndClick();
        homePage.selectShowAllDesktopsFromDropDown();
        desktopPage.getProductNamesListedUnderDesktops();
        Collections.reverse(desktopPage.getProductNamesListedUnderDesktops());
        //System.out.println(desktopPage.getProductNamesListedUnderDesktops());
        Thread.sleep(5000);
        Assert.assertEquals(desktopPage.getProductNamesListByNameZToA("Name (Z - A)"), desktopPage.getProductNamesListedUnderDesktops(), "Products not sorted by Z to A");

    }

    @Test(groups = {"smoke", "regression"})
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        homePage.changeCurrency("£ Pound Sterling");
        homePage.mouseHoverOnDesktopsTabAndClick();
        homePage.selectShowAllDesktopsFromDropDown();
        desktopPage.sortProductsByName("Name (Z - A)");
        desktopPage.selectHpProduct();
        softAssert.assertEquals(desktopPage.getTextFromHpProduct(), "HP LP3065", "HP LP3065 Product not display");
        Thread.sleep(5000);
        desktopPage.selectDeliveryDate("2023", "November", "30");
        desktopPage.addProductToCart();
        softAssert.assertEquals(desktopPage.getTextToConfirmProductAddedToCart(), "Success: You have added HP LP3065 to your shopping cart!\n" + "×", "Product not added to cart");
        shoppingCartPage.clickOnShoppingCartLinkInSuccessMessage();
        softAssert.assertTrue(shoppingCartPage.getPageNameShoppingCart().contains("Shopping Cart"), "Not navigated to Shopping Cart Page");
        softAssert.assertEquals(shoppingCartPage.confirmHpProductName(), "HP LP3065", "Product name does not match");
        softAssert.assertTrue(shoppingCartPage.getTheDeliveryDate().contains("2023-11-30"), "Delivery date does not match");
        softAssert.assertEquals(shoppingCartPage.getTextForTheModelOfSelectedProduct(), "Product 21", "Model does not match");
        softAssert.assertEquals(shoppingCartPage.getTheTotalAmount(), "£74.73", "Total does not match");
        softAssert.assertAll();
    }
}
