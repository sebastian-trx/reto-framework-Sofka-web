package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {

    @CacheLookup
    @FindBy(id = "BillingNewAddress_CountryId")
    WebElement country;

    @CacheLookup
    @FindBy(id = "BillingNewAddress_City")
    WebElement city;

    @CacheLookup
    @FindBy(id = "BillingNewAddress_Address1")
    WebElement address1;

    @CacheLookup
    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    WebElement zipCode;

    @CacheLookup
    @FindBy(id = "BillingNewAddress_PhoneNumber")
    WebElement phoneNumber;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"billing-buttons-container\"]/input")
    WebElement continueButton1;
    @CacheLookup
    @FindBy(xpath = "//*[@id=\"shipping-buttons-container\"]/input")
    WebElement continueButton2;
    @CacheLookup
    @FindBy(xpath = "//*[@id=\"shipping-method-buttons-container\"]/input")
    WebElement continueButton3;
    @CacheLookup
    @FindBy(xpath = "//*[@id=\"payment-method-buttons-container\"]/input")
    WebElement continueButton4;
    @CacheLookup
    @FindBy(xpath = "//*[@id=\"payment-info-buttons-container\"]/input")
    WebElement continueButton5;
    @CacheLookup
    @FindBy(xpath = "//*[@id=\"confirm-order-buttons-container\"]/input")
    WebElement continueButton6;

    @FindBy(xpath = "//*[@id=\"billing-new-address-form\"]/div/div/div/div[5]/span[2]")
    WebElement countryWarnMessage;

    @FindBy(xpath = "//*[@id=\"billing-new-address-form\"]/div/div/div/div[7]/span[2]")
    WebElement cityWarnMessage;

    @FindBy(xpath = "//*[@id=\"billing-new-address-form\"]/div/div/div/div[8]/span[2]")
    WebElement addressWarnMessage;

    @FindBy(xpath = "//*[@id=\"billing-new-address-form\"]/div/div/div/div[10]/span[2]")
    WebElement zipCodeWarnMessage;

    @FindBy(xpath = "//*[@id=\"billing-new-address-form\"]/div/div/div/div[11]/span[2]")
    WebElement phoneWarnMessage;


    public WebElement getCountry() {
        return country;
    }

    public WebElement getCity() {
        return city;
    }

    public WebElement getAddress1() {
        return address1;
    }

    public WebElement getZipCode() {
        return zipCode;
    }

    public WebElement getPhoneNumber() {
        return phoneNumber;
    }

    public WebElement getContinueButton1() {
        return continueButton1;
    }

    public WebElement getContinueButton2() {
        return continueButton2;
    }

    public WebElement getContinueButton3() {
        return continueButton3;
    }

    public WebElement getContinueButton4() {
        return continueButton4;
    }

    public WebElement getContinueButton5() {
        return continueButton5;
    }

    public WebElement getContinueButton6() {
        return continueButton6;
    }

    public WebElement getCountryWarnMessage() {
        return countryWarnMessage;
    }

    public WebElement getCityWarnMessage() {
        return cityWarnMessage;
    }

    public WebElement getAddressWarnMessage() {
        return addressWarnMessage;
    }

    public WebElement getZipCodeWarnMessage() {
        return zipCodeWarnMessage;
    }

    public WebElement getPhoneWarnMessage() {
        return phoneWarnMessage;
    }

    public CheckOutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


}
