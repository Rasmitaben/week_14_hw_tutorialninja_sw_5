package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;
import java.util.UUID;

public class MyAccountsPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//li/a")
    WebElement  options;
    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement desktopLink;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccount;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")
    WebElement registerAccount;
    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Returning Customer']")
    WebElement returningCustomer;
    @CacheLookup
    @FindBy(id = "input-firstname")
    WebElement firstName;
    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement lastName ;
    @CacheLookup
    @FindBy(id = "input-email")
    WebElement  email ;
    @CacheLookup
    @FindBy(xpath= "//input[@id='input-telephone']")
    WebElement telephone ;
    @CacheLookup
    @FindBy(id = "input-password")
    WebElement password;
    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement  confirmPassword ;
    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Yes']")
    WebElement yesRadioButton ;
    @CacheLookup
    @FindBy(xpath = "//input[@name='agree']")
    WebElement privacyPolicy;
    @CacheLookup
    @FindBy(xpath = "//input[@value='Continue']")
    WebElement continueButton;
    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement accountText ;
    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement continueTab ;
    @CacheLookup
    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='My Account']")
    WebElement myAccountTab;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
    WebElement accountLogoutText;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continue1;
    @CacheLookup
    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginButton;
    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement myAccountText  ;
    @CacheLookup
    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='My Account']")
    WebElement myAccountLink ;
    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Account Logout']")
    WebElement textAccountLogout ;
    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement continue2;

    public void selectMyOptions(String option) {
        Reporter.log("select my options");
        CustomListeners.test.log(Status.PASS, "select my options");

        clickOnElement(By.linkText("My Account"));
        List<WebElement> optionsList = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//li/a"));
        for (WebElement element : optionsList) {
            if (element.getText().equalsIgnoreCase(option)) {
                clickOnElement(element);
                break;
            }
        }
    }
    public void clickOnMyAccountLink() {
        Reporter.log("click on my Accountlink");
        CustomListeners.test.log(Status.PASS, "click on my Accountlink");
        clickOnElement(myAccount);
    }

    public String verifyTextRegisterAccount() {
        Reporter.log("Verify the text register account");
        CustomListeners.test.log(Status.PASS, "Verify text register account");
        return getTextFromElement(registerAccount);
    }

    public String verifyTextReturningCustomer() {
        Reporter.log("Verify the text returning customer");
        CustomListeners.test.log(Status.PASS, "Verify the text returning customer");
        return getTextFromElement(returningCustomer);
    }

    public void enterFirstName(String fName) {
        Reporter.log("Enter fName" + fName + "to firstName " + firstName.toString());
        CustomListeners.test.log(Status.PASS, "Enter fName" + fName);
        sendTextToElement(firstName, fName);
    }

    public void enterLastName(String lName) {
        Reporter.log("Enter lName "+ lName + "to lastName  " + lastName.toString());
        CustomListeners.test.log(Status.PASS, "Enter lName "+ lName);
        sendTextToElement(lastName, lName);
    }

    public void enterEmailId() {
        Reporter.log("Enter emailId");
        CustomListeners.test.log(Status.PASS, "Enter emailId");
        String randomEmail = randomEmail();
        sendTextToElement(email, randomEmail);
    }
    private static String randomEmail() {
        Reporter.log("Enter randomEmail");
        CustomListeners.test.log(Status.PASS, "Enter randomEmail");
        return "random-" + UUID.randomUUID().toString() + "@example.com";
    }
    public void enterTelephone(String telNum) {
        Reporter.log("Enter telNum" + telNum + "to telephone" + telephone.toString());
        CustomListeners.test.log(Status.PASS, "Enter telNum" + telNum);
        sendTextToElement(telephone, telNum);
    }

    public void enterPassword(String passWord) {
        Reporter.log("Enter passWord " + passWord + "to Password" + password.toString());
        CustomListeners.test.log(Status.PASS, "Enter passWord " + passWord);
        sendTextToElement(password, passWord);
    }

    public void enterConfirmPassword(String conPassword) {
        Reporter.log("Enter conPassword " + conPassword +"to confirmPassword" +confirmPassword.toString());
        CustomListeners.test.log(Status.PASS, "Enter emailId");
        sendTextToElement(confirmPassword, conPassword);
    }

    public void clickOnYesRadioButton() {
        Reporter.log("click on radiobutton");
        CustomListeners.test.log(Status.PASS, "click on radiobutton");
        clickOnElement(yesRadioButton);
    }

    public void clickOnPrivacyPolicyCheckBox() {
        Reporter.log("Click on privacy policy checkbox");
        CustomListeners.test.log(Status.PASS, "Click on privacy policy checkbox");
        clickOnElement(privacyPolicy);
    }

    public void clickOnContinueButton() {
        Reporter.log("Click on continue button");
        CustomListeners.test.log(Status.PASS, "Click on continue button");
        clickOnElement(continueButton);
    }

    public String verifyMessageAccountCreated() {
        Reporter.log("Verify message account created");
        CustomListeners.test.log(Status.PASS, "Verify message account created");
        return getTextFromElement(accountText);
    }

    public void clickOnContinueTab() {
        Reporter.log("Click on continue tab");
        CustomListeners.test.log(Status.PASS, "Click on continue tab");
        clickOnElement(continueTab);
    }

    public void clickOnMyAccountTab() {
        Reporter.log("Click on my account tab");
        CustomListeners.test.log(Status.PASS, "Click on my account tab");
        clickOnElement(myAccountTab);
    }

    public String verifyTextAccountLogout() {
        Reporter.log("Verify the text account logout");
        CustomListeners.test.log(Status.PASS, "Verify the text account logout");
        return getTextFromElement(accountLogoutText);
    }

    public void clickOnContinue() {
        Reporter.log("Click on continue");
        CustomListeners.test.log(Status.PASS, "Click on continue");
        clickOnElement(continue1);
    }

    public void enterEmail(String emailId) {
        Reporter.log("Enter emailId" + emailId + "to email" +email.toString());
        CustomListeners.test.log(Status.PASS, "Enter emailId" + emailId);
        sendTextToElement(email, emailId);
    }

    public void enterPasswordField(String passwordField) {
        Reporter.log("Enter  passwordField" +  passwordField + "to password" + password.toString());
        CustomListeners.test.log(Status.PASS, "Enter emailId");
        sendTextToElement(password, passwordField);
    }

    public void clickOnLoginButton() {
        Reporter.log(" Click on Login button");
        CustomListeners.test.log(Status.PASS, "Click on Login button");
        clickOnElement(loginButton);
    }

    public String verifyTextMyAccount() {
        Reporter.log("Verify the text my account");
        CustomListeners.test.log(Status.PASS, "Verify the text my account");
        return getTextFromElement(myAccountText);
    }

    public void clickOnMyAccount() {
        Reporter.log("Click on my Account");
        CustomListeners.test.log(Status.PASS, "Click on my Account");
        clickOnElement(myAccountLink);
    }

    public String getTextAccountLogout() {
        Reporter.log("Get the text account logout");
        CustomListeners.test.log(Status.PASS, "Get the text account logout");
        return getTextFromElement(textAccountLogout);
    }

    public void clickOnContinueLink() {
        Reporter.log("Click on continue link");
        CustomListeners.test.log(Status.PASS, "Click on continue link");
        clickOnElement(continue2);
    }






}
