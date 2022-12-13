package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.testng.Reporter;

import javax.swing.plaf.nimbus.State;
import java.util.List;

public class HomePage extends Utility {

    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement desktops;

    @CacheLookup
    @FindAll(@FindBy(how = How.LINK_TEXT, using = "Show All Desktops"))
    List<WebElement> showAllDesktops;

    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopsAndNotebooks;

    @CacheLookup
    @FindAll(@FindBy(how = How.LINK_TEXT, using = "Show All Laptops & Notebooks"))
    List<WebElement> showAllLaptopsAndNotebooks;

    @CacheLookup
    @FindBy(linkText = "Components")
    WebElement components;

    @CacheLookup
    @FindAll(@FindBy(how = How.XPATH, using = "//div[@id='top-links']//li[contains(@class,'open')]/ul/li"))
    List<WebElement> accountList;

    @CacheLookup
    @FindAll(@FindBy(how = How.LINK_TEXT, using = "Show All Components"))
    List<WebElement> showAllComponents;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Currency')]")
    WebElement currency;

    @CacheLookup
    @FindAll(@FindBy(how = How.XPATH, using = "//ul[@class = 'dropdown-menu']/li"))
    List<WebElement> currencyList;


    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccount;


    public void mouseHoverOnDesktopsTabAndClick() {
        Reporter.log("Hover the mouse on Desktops tab and click" + desktops.toString());
        mouseHoverToElementAndClick(desktops);
    }

    public void selectShowAllDesktopsFromDropDown() {
        Reporter.log("Select show all desktops from drop down" + showAllDesktops.toString());
        selectMenu(showAllDesktops, "Show All Desktops");
    }

    public void mouseHoverOnLaptopsAndNotebooksTabAndClick() {
        Reporter.log("Hover the mouse on Laptops & Notebooks tab and click" + laptopsAndNotebooks.toString());
        mouseHoverToElementAndClick(laptopsAndNotebooks);
    }

    public void selectShowAllLaptopsAndNotebooksFromDropDown() {
        Reporter.log("Select show all Laptops & Notebooks from drop down" + showAllLaptopsAndNotebooks.toString());
        selectMenu(showAllLaptopsAndNotebooks, "Show All Laptops & Notebooks");
    }

    public void mouseHoverOnComponentsTabAndClick() {
        Reporter.log("Hover the mouse on Components tab and click" + components.toString());
        mouseHoverToElementAndClick(components);
    }

    public void selectShowAllComponentsFromDropDown() {
        Reporter.log("Select show all Components from drop down" + showAllComponents.toString());
        selectMenu(showAllComponents, "Show All Components");
    }

    public void changeCurrency(String currencyChoice) {
        Reporter.log("Click on currency tab" + currency.toString());
        Reporter.log("Change the currency" + currencyList.toString());
        clickOnElement(currency);
        try {
            selectMenu(currencyList, currencyChoice);
        } catch (StaleElementReferenceException e) {
            List<WebElement> currencyList;
        }
    }


    public void selectMyAccountOptions(String option) {
        try {
            selectMenu(accountList, option);
        } catch (StaleElementReferenceException e) {
            //selectMenu( By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"), option);
            List<WebElement>accountList;
        }
    }

    public void clickOnMyAccountLink() {
        Reporter.log("Click on My Account link" + myAccount.toString());
                try{
            clickOnElement(myAccount);
        }catch (StaleElementReferenceException e){
            clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        }
    }


}
