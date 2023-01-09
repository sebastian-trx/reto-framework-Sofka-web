package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderDetailsPage {
    @CacheLookup
    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div[2]/table/tbody/tr/td[1]/ul/li[2]")
    WebElement fullName;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div[2]/table/tbody/tr/td[1]/ul/li[3]")
    WebElement email;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div[2]/table/tbody/tr/td[1]/ul/li[4]")
    WebElement phone;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div[2]/table/tbody/tr/td[1]/ul/li[6]")
    WebElement address;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div[2]/table/tbody/tr/td[1]/ul/li[8]")
    WebElement country;

    public WebElement getFullName() {
        return fullName;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getPhone() {
        return phone;
    }

    public WebElement getAddress() {
        return address;
    }

    public WebElement getCountry() {
        return country;
    }

    public OrderDetailsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
}
