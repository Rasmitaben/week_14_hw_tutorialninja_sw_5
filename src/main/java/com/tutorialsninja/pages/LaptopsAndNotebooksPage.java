package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksPage extends Utility {
    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopsAndNotebooksTab;
    @CacheLookup
    @FindBy(linkText = "Show AllLaptops & Notebooks")
    WebElement showAllLaptopsAndNotebooks;
    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortBy;
    @CacheLookup
    @FindBy(xpath = "//p[@class ='price']")
    WebElement productPriceHighToLow;
    @CacheLookup
    @FindBy(linkText = "MacBook")
    WebElement macBook ;
    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='MacBook']")
    WebElement  textMacBook;
    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCart ;
    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement macBookAddedText;
    @CacheLookup
    @FindBy(linkText = "shopping cart")
    WebElement shoppingCart;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Shopping Cart')]")
    WebElement textShoppingCart;
    @CacheLookup
    @FindBy(xpath = "(//a[contains(text(),'MacBook')])[2]")
    WebElement  productNameMacBook ;
    @CacheLookup
    @FindBy(css = "input[value='1']")
    WebElement qty2;
    @CacheLookup
    @FindBy(xpath = "//i[@class='fa fa-refresh']")
    WebElement updateTab ;
    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement modifiedCart  ;
    @CacheLookup
    @FindBy(xpath = "//tbody//tr//td[6]")
    WebElement  total;
    @CacheLookup
    @FindBy(xpath = "//a[@class='btn btn-primary']")
    WebElement checkoutButton ;
    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Checkout']")
    WebElement textCheckout;
    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='New Customer']")
    WebElement newCustomer ;
    @CacheLookup
    @FindBy(xpath = "//input[@value='guest']")
    WebElement  guestCheckout ;
    @CacheLookup
    @FindBy(xpath = "//input[@id='button-account']")
    WebElement  continueTab   ;
    @CacheLookup
    @FindBy(id = "input-payment-firstname")
    WebElement firstName ;
    @CacheLookup
    @FindBy(id = "input-payment-lastname")
    WebElement lastName ;
    @CacheLookup
    @FindBy(id = "input-payment-email")
    WebElement email;
    @CacheLookup
    @FindBy(id = "input-payment-telephone")
    WebElement telephone ;
    @CacheLookup
    @FindBy(id = "input-payment-address-1")
    WebElement address;
    @CacheLookup
    @FindBy(id = "input-payment-city")
    WebElement city ;
    @CacheLookup
    @FindBy(id = "input-payment-postcode")
    WebElement  postCode;
    @CacheLookup
    @FindBy(xpath = "//select[@id='input-payment-country']")
    WebElement country  ;
    @CacheLookup
    @FindBy(xpath = "//select[@id='input-payment-zone']")
    WebElement region ;
    @CacheLookup
    @FindBy(xpath= "//input[@id='button-guest']")
    WebElement continueButton;
    @CacheLookup
    @FindBy(xpath= "//textarea[@name='comment']")
    WebElement  comments;
    @CacheLookup
    @FindBy(xpath = "//input[@name='agree']")
    WebElement  termsAndCondition;
    @CacheLookup
    @FindBy(xpath = "//input[@id='button-payment-method']")
    WebElement continue1;
    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement warningMessage;

    public void mouseHoverOnLaptopAndNotebooksTabAndClick() {
        Reporter.log("Mouse hover on laptop and notebooks tab and click");
        CustomListeners.test.log(Status.PASS, "Mouse hover on laptop and notebooks tab and click");
        mouseHoverToElementAndClick(laptopsAndNotebooksTab);
    }
    public void clickOnShowAllLaptopsAndNotebooks(){
        Reporter.log("click on show all laptops and notebooks");
        CustomListeners.test.log(Status.PASS, "click on show all laptops and notebooks");
        clickOnElement(showAllLaptopsAndNotebooks);
    }
    public void selectSortByHighToLow(String text) {
        Reporter.log("select sort by high to low");
        CustomListeners.test.log(Status.PASS, "select sort by high to low");
        selectByVisibleTextFromDropDown(sortBy,text);
    }
    public List<Double> beforeSortingPriceHighToLow() {
        Reporter.log("Verify the Product price will arrange in High to Low order");
        CustomListeners.test.log(Status.PASS, "Verify the Product price will arrange in High to Low order");
        List<WebElement> products = driver.findElements(By.xpath("//p[@class ='price']"));
        List<Double> originalProductPrice = new ArrayList<>();
        for (WebElement e : products) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        //sort by reverse order
        Collections.sort(originalProductPrice, Collections.reverseOrder());
        System.out.println(originalProductPrice);
        return originalProductPrice;
    }
    public List<Double> afterSortingPriceHighToLow() {
        //After filter Price (High > Low) get all the products price and stored into array list
        List<WebElement> products = driver.findElements(By.xpath("//p[@class ='price']"));
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(afterSortByPrice);
        return afterSortByPrice;

    }
    public void clickOnMacBook(){
        Reporter.log("click on Macbook");
        CustomListeners.test.log(Status.PASS, "click on Macbook");
        clickOnElement(macBook);
    }
    public String verifyTextMacBook() {
        Reporter.log("verify text Macbook");
        CustomListeners.test.log(Status.PASS, "verify text Macbook");
        return getTextFromElement(textMacBook);
    }
    public void clickOnAddToCart(){
        Reporter.log("click on add to cart");
        CustomListeners.test.log(Status.PASS, "click on add to cart");
        clickOnElement(addToCart);
    }
    public String getAddedMacBookText(){
        Reporter.log("get added Macbook text");
        CustomListeners.test.log(Status.PASS, "get added Macbook text");
        return getTextFromElement(macBookAddedText);
    }
    public void clickOnShoppingCart() {
        Reporter.log("click on shopping cart");
        CustomListeners.test.log(Status.PASS, "click on shopping cart");
        clickOnElement(shoppingCart);
    }
    public String verifyTextShoppingCart(){
        Reporter.log("Verify text shopping cart ");
        CustomListeners.test.log(Status.PASS, "Verify text shopping cart");
        return getTextFromElement(textShoppingCart);
    }
    public String verifyProductNameMacBook(){
        Reporter.log("Verify product name Macbook");
        CustomListeners.test.log(Status.PASS, "Verify product name Macbook");
        return getTextFromElement(productNameMacBook);
    }
    public void changeQuantity() {
        Reporter.log("change quantity");
        CustomListeners.test.log(Status.PASS, "change quantity");
        clearValueFromTextBox(By.cssSelector("input[value='1']"));
        sendTextToElement(qty2, "2");

    }
    public void clickOnUpdateTab(){
        Reporter.log("click on update tab");
        CustomListeners.test.log(Status.PASS, "click on update tab");
        clickOnElement(updateTab);
    }
    public String verifyModifiedYourShoppingCart(){
        Reporter.log("Verify modified your shopping cart");
        CustomListeners.test.log(Status.PASS, "Verify modified your shopping cart");
        return getTextFromElement(modifiedCart);
    }
    public String verifyTotal() {
        Reporter.log("Verify total");
        CustomListeners.test.log(Status.PASS, "Verify total");
        return getTextFromElement(total);
    }
    public void clickOnCheckoutButton() {
        Reporter.log("click on checkout button");
        CustomListeners.test.log(Status.PASS, "click on checkout button");
        clickOnElement(checkoutButton);
    }
    public String verifyTheTextCheckout() {
        Reporter.log("Verify the text checkout");
        CustomListeners.test.log(Status.PASS, "Verify the text checkout");
        return getTextFromElement(textCheckout);
    }
    public String verifyTheTextNewCustomer() {
        Reporter.log("Verify the text Newcustomer");
        CustomListeners.test.log(Status.PASS, "Verify the text Newcustomer");
        return getTextFromElement(newCustomer);
    }
    public void clickOnGuestCheckOutRadioButton(){
        Reporter.log("click on guest checkout radiobutton");
        CustomListeners.test.log(Status.PASS, "click on guest checkout radiobutton");
        clickOnElement(guestCheckout);
    }
    public void clickOnContinueTab(){
        Reporter.log("click on continue tab");
        CustomListeners.test.log(Status.PASS, "click on continue tab");
        clickOnElement(continueTab);
    }
    public void enterFirstName(String fName) {
        Reporter.log("Enter fName" + fName + "to firstName " + firstName.toString());
        CustomListeners.test.log(Status.PASS, "Enter firstname" + fName);
        sendTextToElement(firstName,fName);
    }
    public void enterLastName(String lName) {
        Reporter.log("Enter lName "+ lName + "to lastName  " + lastName.toString());
        CustomListeners.test.log(Status.PASS, "Enter lastname "+ lName);
        sendTextToElement(lastName,lName);
    }
    public void enterEmailId(String emailId) {
        Reporter.log("Enter emailId " + emailId + "to email " + email.toString());
        CustomListeners.test.log(Status.PASS, "Enter emailId " + emailId );
        sendTextToElement(email,emailId);
    }
    public void enterTelephone(String number) {
        Reporter.log("Enter number " + number + "to telephone" + telephone.toString());
        CustomListeners.test.log(Status.PASS, "Enter number " + number);
        sendTextToElement(telephone,number);
    }
    public void enterAddress(String add) {
        Reporter.log("Enter add " + add + "to address " + address.toString());
        CustomListeners.test.log(Status.PASS, "Enter add " + add );
        sendTextToElement(address,add);
    }
    public void enterCity(String cityName) {
        Reporter.log("Enter cityName " +cityName + "to city " + city.toString());
        CustomListeners.test.log(Status.PASS, "Enter cityName" +cityName);
        sendTextToElement(city,cityName);
    }
    public void enterPostCode(String postalCode) {
        Reporter.log("Enter postalCode" + postalCode+ "to postcode" +postCode.toString());
        CustomListeners.test.log(Status.PASS, "Enter postalCode" + postalCode);
        sendTextToElement(postCode,postalCode);
    }
    public void selectCountryFromDropDown(String countryName) {
        Reporter.log("select country from dropdown");
        CustomListeners.test.log(Status.PASS, "select country from dropdown");
        selectByVisibleTextFromDropDown(country,countryName);
    }
    public void selectRegionFromDropDown(String regionName) {
        Reporter.log("select region from dropdown");
        CustomListeners.test.log(Status.PASS, "select region from dropdown");
        selectByVisibleTextFromDropDown(region,regionName);
    }
    public void clickOnContinueButton(){
        Reporter.log("click on continue button");
        CustomListeners.test.log(Status.PASS, "click on continue button");
        clickOnElement(continueButton);
    }
    public void addCommentsAboutYourOrder() {
        Reporter.log("Add Comments About your order into text area");
        CustomListeners.test.log(Status.PASS, "Add Comments About your order into text area");
        sendTextToElement(comments,"I have added two products");
    }
    public void clickOnTermsAndConditionsCheckBox() {
        Reporter.log("click on Terms & Conditions check box");
        CustomListeners.test.log(Status.PASS, "click on Terms & Conditions check box");
        clickOnElement(termsAndCondition);
    }
    public void clickOnContinue() {
        Reporter.log("click On Continue button");
        CustomListeners.test.log(Status.PASS, "click On Continue button");
        clickOnElement(continue1);
    }
    public String verifyMessagePaymentMethodRequired() {
        Reporter.log("verify Message Payment Method Required");
        CustomListeners.test.log(Status.PASS, "verify Message Payment Method Required");
        return getTextFromElement(warningMessage);
    }






}
