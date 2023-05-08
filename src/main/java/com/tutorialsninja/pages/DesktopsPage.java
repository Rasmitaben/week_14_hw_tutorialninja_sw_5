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
import java.util.List;

public class DesktopsPage extends Utility {
    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement desktopLink;

    @CacheLookup
    @FindBy(linkText = "Show AllDesktops")
    WebElement showAllDesktops;
    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement positionZtoA;

    @CacheLookup
    @FindBy(xpath = "//h4/a")
    WebElement allProductsName;
    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement positionAtoZ;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'HP LP3065')]")
    WebElement HP3065;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'HP LP3065')]")
    WebElement textHPLP3065;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'input-group date']//button")
    WebElement calender;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")
    WebElement monthYear;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='next']")
    WebElement yearAndMonth;


    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']")
    WebElement day;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-quantity']")
    WebElement quantity;
    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCart;
    @CacheLookup
    @FindBy(css = "body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible")
    WebElement successMessage;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement shoppingCart;
    @CacheLookup
    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement shoppingCartText;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement productHPLp3065;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")
    WebElement deliveryDate;

    @CacheLookup
    @FindBy(xpath = "//td[normalize-space()='Product 21']")
    WebElement product21;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement totalPrice;

    public void mouseHoverOnDesktopLinkAndClick() {
        Reporter.log("mouseHover on desktoplink and click");
        CustomListeners.test.log(Status.PASS, "mouseHover on desktoplink and click");
        mouseHoverToElementAndClick(desktopLink);
    }

    public void clickOnShowAllDesktops() {
        Reporter.log("click on show Alldesktops");
        CustomListeners.test.log(Status.PASS, "click on show Alldesktops");
        clickOnElement(showAllDesktops);
    }

    public void selectPositionByZtoA() {
        Reporter.log("select position ByZtoA");
        CustomListeners.test.log(Status.PASS, "select position ByZtoA");
        selectByVisibleTextFromDropDown(positionZtoA, "Name (Z - A)");
    }

    public List<WebElement> returnZtoAElementsLocator() {
        Reporter.log("return ZtoA elements locator");
        CustomListeners.test.log(Status.PASS, "return ZtoA elements locator");
        List<WebElement> listOfElements = driver.findElements(By.id("input-sort"));
        return listOfElements;

    }

    public void selectPositionByAtoZ() {
        Reporter.log("select Position By AtoZ");
        CustomListeners.test.log(Status.PASS, "select Position By AtoZ");
        selectByVisibleTextFromDropDown(positionAtoZ, "Name (A - Z)");
    }

    public void clickOnProductHPLP3065() {
        Reporter.log("click on product HPLP3065");
        CustomListeners.test.log(Status.PASS, "click on product HPLP3065");
        clickOnElement(HP3065);
    }

    public String getTextHPLp3065() {
        Reporter.log("get Text HPLP3065");
        CustomListeners.test.log(Status.PASS, "get Text HPLp3065");
        return getTextFromElement(textHPLP3065);
    }

    public void selectDateFromCalender() {
        Reporter.log("select date from Calender");
        CustomListeners.test.log(Status.PASS, "select date from Calender");

        String year = "2023";
        String month = "November";
        String date = "30";
        clickOnElement(calender);
        while (true) {

            String monthAndYear = monthYear.getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(yearAndMonth);
            }
        }
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']"));
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }

    }

    public void enterQuantity() {
        Reporter.log(" enter Quantity" + quantity.toString());
        CustomListeners.test.log(Status.PASS, " enterQuantity");
        sendTextToElement(quantity, "");
    }

    public void clickOnAddToCart() {
        Reporter.log("click on add to cart");
        CustomListeners.test.log(Status.PASS, "click on add to cart");
        clickOnElement(addToCart);
    }

    public String getSuccessText() {
        Reporter.log("get success text");
        CustomListeners.test.log(Status.PASS, "get success text");
        return getTextFromElement(successMessage);
    }

    public void clickOnShoppingCart() {
        Reporter.log("click on shopping cart");
        CustomListeners.test.log(Status.PASS, "click on shopping cart");
        clickOnElement(shoppingCart);
    }

    public String getShoppingCartText() {
        Reporter.log("get shopping cart text");
        CustomListeners.test.log(Status.PASS, "get shopping cart text");
        return getTextFromElement(shoppingCartText);
    }

    public String getProductNameHPLPText() {
        Reporter.log("get product name HPLP3065Text");
        CustomListeners.test.log(Status.PASS, " get product name HPLP3065Text");
        return getTextFromElement(productHPLp3065);
    }

    public String verifyDeliveryDate() {
        Reporter.log("verify delivery date");
        CustomListeners.test.log(Status.PASS, " verify deliveryDate");
        return getTextFromElement(deliveryDate);
    }

    public String verifyModelProduct21() {
        Reporter.log("verify model product21");
        CustomListeners.test.log(Status.PASS, "verify model product21");
        return getTextFromElement(product21);
    }

    public String verifyTotal() {
        Reporter.log("Verify total");
        CustomListeners.test.log(Status.PASS, "verify total");
        return getTextFromElement(totalPrice);
    }


    public ArrayList<String> getProductsNameList() {

        return null;
    }
}