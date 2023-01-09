package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    @CacheLookup
    @FindBy(xpath = "/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")
    WebElement register;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[4]/div[1]/div[2]/ul[1]/li[1]/a")
    WebElement booksLink;

    public WebElement getRegister(){
        return register;
    }

    public WebElement getBooksLink(){
        return booksLink;
    }

    public LandingPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
}
