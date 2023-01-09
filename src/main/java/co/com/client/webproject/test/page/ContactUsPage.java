package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
    @CacheLookup
    @FindBy(id = "FullName")
    WebElement nameField;

    @CacheLookup
    @FindBy(id = "Email")
    WebElement emailField;

    @CacheLookup
    @FindBy(id = "Enquiry")
    WebElement enquiryField;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div/div[3]/form/div[3]/input")
    WebElement submitButton;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div/div[3]/div")
    WebElement successfulMessage;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div/div[3]/form/div[2]/div[1]/div[2]/span/span")
    WebElement warnEmailMessage;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div/div[3]/form/div[2]/div[2]/span/span")
    WebElement warnEnquiryMessage;

    public WebElement getNameField() {
        return nameField;
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getEnquiryField() {
        return enquiryField;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getSuccessfulMessage() {
        return successfulMessage;
    }

    public WebElement getWarnEmailMessage() {
        return warnEmailMessage;
    }

    public WebElement getWarnEnquiryMessage() {
        return warnEnquiryMessage;
    }

    public ContactUsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
}
