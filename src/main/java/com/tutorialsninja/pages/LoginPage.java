package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Returning Customer')]")
    WebElement returningCustomer;

    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailAddressField;

    @CacheLookup
    @FindBy(id = "input-password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//form[contains(@action,'login')]//input[@type='submit']")
    WebElement loginButton;


    public String verifyLoginPageText() {
        Reporter.log("Verify the Login Page name" + returningCustomer.toString());
        return getTextFromElement(returningCustomer);
    }

    public void enterEmailAddress(String text) {
        Reporter.log("Enter the email address in the email address field" + emailAddressField.toString());
        sendTextToElement(emailAddressField, text);
    }

    public void enterPassword(String text) {
        Reporter.log("Enter the password in the password field" + passwordField.toString());
        sendTextToElement(passwordField, text);
    }

    public void clickOnLoginButton() {
        Reporter.log("Click on the Login button" + loginButton.toString());
        clickOnElement(loginButton);
    }
}




