package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*")
    WebElement topMenu ;
    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement desktopLink ;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Desktops')]")
    WebElement desktopsText  ;
    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement  laptopsAndNotebooksLink;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement  laptopAndNotebooksText;
    @CacheLookup
    @FindBy(linkText = "Components")
    WebElement componentsLink ;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Components')]")
    WebElement componentsText ;

    public void selectMenu(String menu) {
        Reporter.log("topMenu");
        CustomListeners.test.log(Status.PASS, "topMenu");
        List<WebElement> topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = driver.findElements((By) topMenu);
        }
    }
    public void mouseHoverOnDesktopLinkAndClick() {
        Reporter.log("mouse hover on desktop link and click");
        CustomListeners.test.log(Status.PASS, "mouse hover on desktop link and click");
        mouseHoverToElementAndClick(desktopLink);
    }

    public String getDesktopsText() {
        Reporter.log("get desktop text");
        CustomListeners.test.log(Status.PASS, "get desktop text");
        return getTextFromElement(desktopsText);
    }

    public void mouseHoverOnLaptopAndNotebooksLinkAndClick() {
        Reporter.log("mouse hover on laptop and notebooks link and click");
        CustomListeners.test.log(Status.PASS, "mouse hover on laptop and notebooks link and click");
        mouseHoverToElementAndClick(laptopsAndNotebooksLink);
    }

    public String getLaptopsAndNotebooksText() {
        Reporter.log("get laptops and notebooks text");
        CustomListeners.test.log(Status.PASS, "get laptops and notebooks text");
        return getTextFromElement(laptopAndNotebooksText);
    }

    public void mouseHoverOnComponentsLinkAndClick() {
        Reporter.log("mouse hover on components link and click");
        CustomListeners.test.log(Status.PASS, "mouse hover on components link and click");
        mouseHoverToElementAndClick(componentsLink);
    }

    public String getComponentsText() {
        Reporter.log("get components text");
        CustomListeners.test.log(Status.PASS, "get components text");
        return getTextFromElement(componentsText);
    }




}
