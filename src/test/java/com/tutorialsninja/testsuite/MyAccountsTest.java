package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.MyAccountsPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)


public class MyAccountsTest extends BaseTest {
    MyAccountsPage accountsPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        accountsPage = new MyAccountsPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        accountsPage.selectMyOptions("Register");
        //1.3 Verify the text “Register Account”.
        String expectedText = "Register Account";
        String actualText = accountsPage.verifyTextRegisterAccount();
        Assert.assertEquals(actualText, expectedText, "Error found");
    }
    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter“Login”
        accountsPage.selectMyOptions("Login");
        //2.3 Verify the text “Returning Customer”.
        String expectedText = "Returning Customer";
        String actualText = accountsPage.verifyTextReturningCustomer();
        Assert.assertEquals(actualText, expectedText, "Error found");
    }
    @Test(groups = {"regression", "regression"})
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter“Register”
        accountsPage.selectMyOptions("Register");
        //3.3 Enter First Name
        accountsPage.enterFirstName("Magnus");
        //3.4 Enter Last Name
        accountsPage.enterLastName("Smith");
        //3.5 Enter Email
        accountsPage.enterEmailId();
        Thread.sleep(2000);
        //3.6 Enter Telephone
        accountsPage.enterTelephone("0782565511");
        //3.7 Enter Password
        accountsPage.enterPassword("smith123456");
        //3.8 Enter Password Confirm
        accountsPage.enterConfirmPassword("smith123456");
        //3.9 Select Subscribe Yes radio button
        accountsPage.clickOnYesRadioButton();
        //3.10 Click on Privacy Policy check box
        accountsPage.clickOnPrivacyPolicyCheckBox();
        //3.11 Click on Continue button
        accountsPage.clickOnContinueButton();
        //3.12 Verify the message “Your Account Has Been Created!”
        String expectedText = "Your Account Has Been Created!";
        String actualText = accountsPage.verifyMessageAccountCreated();
        Assert.assertEquals(actualText, expectedText, "Error message");
        //3.13 Click on Continue button
        accountsPage.clickOnContinueTab();
        //3.14 Click on My Account Link.
        accountsPage.clickOnMyAccountTab();
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter“Logout”
        accountsPage.selectMyOptions("Logout");
        //3.16 Verify the text “Account Logout”
        String expectedMessage = "Account Logout";
        String actualMessage = accountsPage.verifyTextAccountLogout();
        Assert.assertEquals(actualMessage, expectedMessage, "Error message");
        //3.17 Click on Continue button
        accountsPage.clickOnContinue();
    }
    @Test(groups = {"regression", "regression"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter“Login”
        accountsPage.selectMyOptions("Login");
        //4.3 Enter Email address
        accountsPage.enterEmail("magnussmith123@gmail.com");
       //4.4 Enter Password
        accountsPage.enterPasswordField("smith123456");
        //4.5 Click on Login button
        accountsPage.clickOnLoginButton();
        //4.6 Verify text “My Account”
        String expectedText = "My Account";
        String actualText = accountsPage.verifyTextMyAccount();
        Assert.assertEquals(actualText, expectedText, "Error message");
        //4.7 Click on My Account Link.
        accountsPage.clickOnMyAccount();
        //4.8 Call the method “selectMyAccountOptions” method and pass the parameter“Logout”
        accountsPage.selectMyOptions("Logout");
        //4.9 Verify the text “Account Logout”
        String expectedMessage = "Account Logout";
        String actualMessage = accountsPage.getTextAccountLogout();
        Assert.assertEquals(actualMessage, expectedMessage, "Error message");
        //4.10 Click on Continue button
        accountsPage.clickOnContinueLink();
    }
    }


