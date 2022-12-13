package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class AccountPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]" )
    WebElement accountCreatedText;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueButtonAcctCreated;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
    WebElement accountLogoutText;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueToHomepage;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'My Account')]")
    WebElement myAccountPage;


    public String verifyAccountCreatedText() {
        Reporter.log("Verify Account is Created Text" + accountCreatedText.toString());
        return getTextFromElement(accountCreatedText);
    }

    public void clickOnContinueToNavigateToAccount() {
        Reporter.log("Click on continue to navigate to the account" + continueButtonAcctCreated.toString());
        clickOnElement(continueButtonAcctCreated);
    }

    public String verifyAccountLogoutText() {
        Reporter.log("Verify Account is Logged out Text" + accountLogoutText.toString());
        return getTextFromElement(accountLogoutText);

    }

    public void clickOnContinueToNavigateToHomepage() {
        Reporter.log("Click on continue to navigate to the homepage" + continueToHomepage.toString());
        clickOnElement(continueToHomepage);
    }

    public String verifyMyAccountPageName() {
        Reporter.log("Verify My Account page name" + myAccountPage.toString());
        return getTextFromElement(myAccountPage);
    }


}
