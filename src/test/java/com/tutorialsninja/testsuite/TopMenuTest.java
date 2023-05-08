package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)

public class TopMenuTest extends BaseTest {
    HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        //1.1 Mouse hover on “Desktops” Tab and click
        homePage.mouseHoverOnDesktopLinkAndClick();
        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        homePage.selectMenu("Show AllDesktops");
        //1.3 Verify the text ‘Desktops’
        String expectedText = "Desktops";
        String actualText = homePage.getDesktopsText();
        Assert.assertEquals(actualText, expectedText, "Not navigate to Desktop page");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        homePage.mouseHoverOnLaptopAndNotebooksLinkAndClick();
        //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        homePage.selectMenu("Show AllLaptops & Notebooks");
        //2.3 Verify the text ‘Laptops & Notebooks’
        String expectedText = "Laptops & Notebooks";
        String actualText = homePage.getLaptopsAndNotebooksText();
        Assert.assertEquals(actualText, expectedText, "Not navigate to Laptops & Notebooks page");
    }

    @Test(groups = {"regression", "regression"})
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        //3.1 Mouse hover on “Components” Tab and click
        homePage.mouseHoverOnComponentsLinkAndClick();
        //3.2 call selectMenu method and pass the menu = “Show All Components”
        homePage.selectMenu("Show AllComponents");
        //3.3 Verify the text ‘Components’
        String expectedText = "Components";
        String actualText = homePage.getComponentsText();
        Assert.assertEquals(actualText, expectedText, "Not navigate to components page");
    }

    }

