package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"termsofservice\"]")
    WebElement aceptTerms;

    @CacheLookup
    @FindBy(id = "checkout")
    WebElement checkoutButton;

    public WebElement getAceptTerms() {
        return aceptTerms;
    }

    public WebElement getCheckoutButton() {
        return checkoutButton;
    }

    public CartPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
}
