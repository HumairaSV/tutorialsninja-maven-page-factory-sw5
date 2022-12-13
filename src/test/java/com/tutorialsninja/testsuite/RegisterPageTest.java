package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.*;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RegisterPageTest extends BaseTest {

    HomePage homePage;
    RegisterPage registerPage;
    AccountPage accountPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        registerPage = new RegisterPage();
        accountPage = new AccountPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully()throws InterruptedException{
        homePage.clickOnMyAccountLink();
        homePage.selectMyAccountOptions("Register");
        Assert.assertEquals(registerPage.verifyTextRegisterAccount(), "Register Account", "Not navigated to Register Page" );
    }
    @Test(groups = {"smoke", "regression"})
    public void verifyThatUserRegisterAccountSuccessfully()throws InterruptedException{
        SoftAssert softAssert = new SoftAssert();
        homePage.clickOnMyAccountLink();
        homePage.selectMyAccountOptions("Register");
        registerPage.enterFirstName("Testinghv"+getRandomString(2));
        registerPage.enterLastName("Automode"+getRandomString(2));
        registerPage.enterEmailAddress("Testinghv"+getRandomString(2)+"@gmail.com");
        registerPage.enterTelephoneNo("07552141254");
        registerPage.enterPassword("Password987");
        registerPage.enterConfirmPassword("Password987");
        registerPage.selectRadioButtonToSubscribe("Yes");
        registerPage.clickOnPrivacyPolicyCheckbox();
        registerPage.clickOnContinueToRegister();
        softAssert.assertEquals(accountPage.verifyAccountCreatedText(), "Your Account Has Been Created!", "Account created text not displayed");
        accountPage.clickOnContinueToNavigateToAccount();
        homePage.clickOnMyAccountLink();
        homePage.selectMyAccountOptions("Logout");
        softAssert.assertEquals(accountPage.verifyAccountLogoutText(), "Account Logout", "Not logged out of the account");
        accountPage.clickOnContinueToNavigateToHomepage();
        softAssert.assertAll();
    }
}
