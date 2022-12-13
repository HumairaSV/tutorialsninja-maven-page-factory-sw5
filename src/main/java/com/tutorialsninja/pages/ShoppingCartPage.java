package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ShoppingCartPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement shoppingCartPage;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement hPProductNameInShoppingCart;

    @CacheLookup
    @FindBy(xpath = "//small[contains(text(),'Delivery Date: 2023-11-30')]")
    WebElement deliveryDate;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[3]")
    WebElement model;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement totalAmount;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement shoppingCartLink;

    @CacheLookup
    @FindBy(xpath = "//input[contains(@name, 'quantity')]")
    WebElement quantityField;

    @CacheLookup
    @FindBy(xpath = "//button[contains(@data-original-title, 'Update')]")
    WebElement updateButton;

    @CacheLookup
    @FindBy(xpath = "//div[@id='checkout-cart']/div[1]")
    WebElement cartUpdatedMessage;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement macBookProductNameInShoppingCart;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Checkout')]")
    WebElement checkOutButton;


    public String getPageNameShoppingCart(){
        Reporter.log("Verify shopping cart page name" + shoppingCartPage.toString());
        return getTextFromElement(shoppingCartPage);
    }

    public void clickOnShoppingCartLinkInSuccessMessage(){
        Reporter.log("Click on the shopping cart link in the success message" + shoppingCartLink.toString());
        clickOnElement(shoppingCartLink);
    }

    public String confirmHpProductName(){
        Reporter.log("Verify Hp product name" + hPProductNameInShoppingCart.toString());
        return getTextFromElement(hPProductNameInShoppingCart);
    }

    public String getTheDeliveryDate(){
        Reporter.log("Verify the delivery date" + deliveryDate.toString());
        return getTextFromElement(deliveryDate);
    }

    public String getTextForTheModelOfSelectedProduct(){
        Reporter.log("Verify the Model of the selected product" + model.toString());
        return getTextFromElement(model);
    }

    public String getTheTotalAmount(){
        Reporter.log("Verify the total amount in the cart" + totalAmount.toString());
        return getTextFromElement(totalAmount);
    }

    public String confirmMacBkProductName(){
        Reporter.log("Verify the MacBook product name" + macBookProductNameInShoppingCart.toString());
        return getTextFromElement(macBookProductNameInShoppingCart);
    }

    public void updateQuantityToTwo(String qty){
        Reporter.log("Change the quantity of product to two in the cart" + model.toString());
        quantityField.clear();
        sendTextToElement(quantityField, qty);
    }

    public void clickToUpdateQty(){
        Reporter.log("Click to update the Quantity" + updateButton.toString());
        clickOnElement(updateButton);
    }

    public String confirmQtyUpdatedMessage(){
        Reporter.log("Verify the quantity has been updated message" + cartUpdatedMessage.toString());
        return getTextFromElement(cartUpdatedMessage);
    }

    public void clickOnCheckoutButton(){
        Reporter.log("Click on checkout button" + checkOutButton.toString());
        clickOnElement(checkOutButton);
    }

}



