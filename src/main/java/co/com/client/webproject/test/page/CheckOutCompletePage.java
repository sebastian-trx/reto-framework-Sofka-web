package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutCompletePage {

    @CacheLookup
    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/ul/li[2]/a")
    WebElement orderDetailsLink;

    public WebElement getOrderDetailsLink() {
        return orderDetailsLink;
    }

    public CheckOutCompletePage (WebDriver driver){
        PageFactory.initElements(driver,this);
    }
}
