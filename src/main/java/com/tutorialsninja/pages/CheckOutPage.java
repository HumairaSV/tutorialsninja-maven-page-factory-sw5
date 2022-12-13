package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CheckOutPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Checkout')]")
    WebElement checkOutButtonPageName;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'New Customer')]")
    WebElement newCustomerText;

    @CacheLookup
    @FindBy(xpath = "//input[@value= 'guest']")
    WebElement guestCheckoutRadioButton;

    @CacheLookup
    @FindBy(id = "button-account")
    WebElement continueButton;

    @CacheLookup
    @FindBy(css = "#input-payment-firstname")
    WebElement firstName;

    @CacheLookup
    @FindBy(css = "#input-payment-lastname")
    WebElement lastName;

    @CacheLookup
    @FindBy(css = "#input-payment-email")
    WebElement email;

    @CacheLookup
    @FindBy(css = "#input-payment-telephone" )
    WebElement phoneNo;

    @CacheLookup
    @FindBy(css = "#input-payment-address-1")
    WebElement addressLn1;

    @CacheLookup
    @FindBy(css = "#input-payment-city")
    WebElement cityField;

    @CacheLookup
    @FindBy(css = "#input-payment-postcode")
    WebElement postCodeField;

    @CacheLookup
    @FindBy(xpath = "//select[@id='input-payment-country']")
    WebElement countryField;

    @CacheLookup
    @FindBy(xpath = "//select[@id='input-payment-zone']")
    WebElement regionField;

    @CacheLookup
    @FindBy(css = "#button-guest")
    WebElement continueGuestButton;

    @CacheLookup
    @FindBy(xpath = "//textarea[@name = 'comment']")
    WebElement textAreaCommentBox;

    @CacheLookup
    @FindBy(xpath = "//input[@type= 'checkbox']")
    WebElement tAndCsCheckBox;

    @CacheLookup
    @FindBy(css = "#button-payment-method")
    WebElement continueButtonToPay;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement paymentWarningMessage;


    public String getPageNameCheckout(){
        Reporter.log("Verify Checkout page name" + checkOutButtonPageName.toString());
        return getTextFromElement(checkOutButtonPageName);
    }

    public String verifyNewCustomerText(){
        Reporter.log("Verify New Customer Text" + newCustomerText.toString());
        return getTextFromElement(newCustomerText);
    }

    public void clickOnGuestCheckoutRadioButton(){
        Reporter.log("Click on Guest Checkout Radio button" + guestCheckoutRadioButton.toString());
        clickOnElement(guestCheckoutRadioButton);
    }

    public void clickOnNewCustomerContinueButton(){
        Reporter.log("Click on New customer continue button" + continueButton.toString());
        clickOnElement(continueButton);
    }

    public void enterFirstName(String text){
        Reporter.log("Enter first name in the first name field" + firstName.toString());
        sendTextToElement(firstName, text);
    }

    public void enterLastName(String text){
        Reporter.log("Enter last name in the last name field" + lastName.toString());
        sendTextToElement(lastName, text);
    }

    public void enterEmail(String emailId){
        Reporter.log("Enter first email in the email address field" + email.toString());
        sendTextToElement(email,emailId);
    }

    public void enterPhoneNo(String phNo){
        Reporter.log("Enter phone no in the phone no field" + phoneNo.toString());
        sendTextToElement(phoneNo,phNo);
    }

    public void enterAddressLn1(String address1){
        Reporter.log("Enter first line of address in the address line 1 field" + addressLn1.toString());
        sendTextToElement(addressLn1, address1);
    }

    public void enterCity(String cityName){
        Reporter.log("Enter city in the city name field" + cityField.toString());
        sendTextToElement(cityField, cityName);
    }

    public void enterPostCode(String postcodeText){
        Reporter.log("Enter post code in the post code field" + postCodeField.toString());
        sendTextToElement(postCodeField, postcodeText);
    }

    public void selectCountryFromDropDown(String countryName){
        Reporter.log("Select country from the country field drop down menu" + countryField.toString());
        selectByVisibleTextFromDropDown(countryField, countryName);
    }

    public void selectRegionFromDropDown(String regionName){
        Reporter.log("Select region from the region field drop down menu" + regionField.toString());
        selectByVisibleTextFromDropDown(regionField, regionName);
    }

    public void clickOnContinueGuestButton(){
        Reporter.log("Click on continue as guest button" + continueGuestButton.toString());
        clickOnElement(continueGuestButton);
    }

    public void addCommentsAboutYourOrder(String orderText){
        Reporter.log("Enter comments in About your order box" + textAreaCommentBox.toString());
        sendTextToElement(textAreaCommentBox, orderText);
    }

    public void clickOnTermsAndConditionsCheckBox(){
        Reporter.log("Click on Terms and conditions checkbox" + tAndCsCheckBox.toString());
        clickOnElement(tAndCsCheckBox);
    }

    public void clickOnContinueButtonToProceedToPayment(){
        Reporter.log("Click on continue button to proceed to payment" + continueButtonToPay.toString());
        clickOnElement(continueButtonToPay);
    }

    public String getPaymentWarningMessage(){
        Reporter.log("Verify payment warning message" + paymentWarningMessage.toString());
        return getTextFromElement(paymentWarningMessage);
    }

}
