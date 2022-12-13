package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.*;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TopMenuTest extends BaseTest {

    HomePage homePage;
    DesktopPage desktopPage;
    LaptopsAndNotebooksPage laptopsAndNotebooksPage;
    ComponentsPage componentsPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        componentsPage = new ComponentsPage();
        desktopPage = new DesktopPage();
        laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        homePage.mouseHoverOnDesktopsTabAndClick();
        homePage.selectShowAllDesktopsFromDropDown();
        Assert.assertEquals(desktopPage.getPageName(), "Desktops", "Not navigated to the Desktops page");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        homePage.mouseHoverOnLaptopsAndNotebooksTabAndClick();
        homePage.selectShowAllLaptopsAndNotebooksFromDropDown();
        Assert.assertEquals(laptopsAndNotebooksPage.getPageName(), "Laptops & Notebooks", "Not navigated to Laptops & Notebooks page");

    }

    @Test(groups = "regression")
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        homePage.mouseHoverOnComponentsTabAndClick();
        homePage.selectShowAllComponentsFromDropDown();
        Assert.assertEquals(componentsPage.getPageName(), "Components", "Not navigated to the Components Page");
    }
}
