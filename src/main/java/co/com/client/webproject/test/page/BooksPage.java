package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BooksPage {

    @CacheLookup
    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div[2]/div[3]/div[2]/input")
    WebElement buttonBook1;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[3]/div/div[2]/div[3]/div[2]/input")
    WebElement buttonBook2;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[5]/div/div[2]/div[3]/div[2]/input")
    WebElement buttonBook3;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"topcartlink\"]/a/span[1]")
    WebElement shoppingCart;

    public WebElement getButtonBook1() {
        return buttonBook1;
    }

    public WebElement getButtonBook2() {
        return buttonBook2;
    }

    public WebElement getButtonBook3() {
        return buttonBook3;
    }

    public WebElement getShoppingCart() {
        return shoppingCart;
    }

    public BooksPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
