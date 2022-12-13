package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.AccountPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LoginPage;
import com.tutorialsninja.pages.RegisterPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AccountLoginPageTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;
    AccountPage accountPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
        accountPage = new AccountPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException{
        homePage.clickOnMyAccountLink();
        homePage.selectMyAccountOptions("Login");
        Assert.assertEquals(loginPage.verifyLoginPageText(), "Returning Customer", "Not navigated to Login Page" );
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException{
        SoftAssert softAssert = new SoftAssert();
        //first registering new account to check login functionality
        homePage.clickOnMyAccountLink();
        homePage.selectMyAccountOptions("Register");
        registerPage.enterFirstName("test12hv");
        registerPage.enterLastName("Sareshw");
        registerPage.enterEmailAddress("tester9hv@gmail.com");
        registerPage.enterTelephoneNo("0789458585");
        registerPage.enterPassword("Password987");
        registerPage.enterConfirmPassword("Password987");
        registerPage.selectRadioButtonToSubscribe("Yes");
        registerPage.clickOnPrivacyPolicyCheckbox();
        registerPage.clickOnContinueToRegister();
        accountPage.clickOnContinueToNavigateToAccount();
        Thread.sleep(5000);
        homePage.clickOnMyAccountLink();
        Thread.sleep(5000);
        homePage.selectMyAccountOptions("Logout");
        Thread.sleep(5000);
        accountPage.clickOnContinueToNavigateToHomepage();
        //testing the login functionality
        Thread.sleep(5000);
        homePage.clickOnMyAccountLink();
        Thread.sleep(5000);
        homePage.selectMyAccountOptions("Login");
        loginPage.enterEmailAddress("tester9hv@gmail.com");
        loginPage.enterPassword("Password987");
        loginPage.clickOnLoginButton();
        softAssert.assertEquals(accountPage.verifyMyAccountPageName(), "My Account", "Not navigated to My account page");
        homePage.clickOnMyAccountLink();
        homePage.selectMyAccountOptions("Logout");
        softAssert.assertEquals(accountPage.verifyAccountLogoutText(), "Account Logout", "Not logged out of the account");
        accountPage.clickOnContinueToNavigateToHomepage();
        softAssert.assertAll();
    }

}
