package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.model.Customer;
import co.com.client.webproject.test.page.ContactUsPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import java.util.ArrayList;
import java.util.List;

public class ContactUsPageController {
    private WebAction webAction;
    private Customer customer;

    ArrayList<String> warnMessages = new ArrayList<>();


    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setWebAction(WebAction webAction){
        this.webAction = webAction;
    }

    public void fillContactFields(){
        try {
            ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());
            webAction.sendText(contactUsPage.getNameField(), customer.getFirstName(),2,true);
            webAction.sendText(contactUsPage.getEmailField(), customer.getEmail(),2,true);
            webAction.sendText(contactUsPage.getEnquiryField(), customer.getMessage(),2,true);
            webAction.click(contactUsPage.getSubmitButton(), 1,true);
        }catch (WebActionsException e){
            Report.reportFailure("error al llenar los campos de contactUs",e);
        }
    }

    public String getSuccessfulMessage(){
        String successfulMessage = "";
        try {
            ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());
            successfulMessage = webAction.getText(contactUsPage.getSuccessfulMessage(),1, true);
        }catch (WebActionsException e){
            Report.reportFailure("error al obtener el mensaje de confirmacion de contactUs",e);
        }
        return successfulMessage;
    }

    public void fillSomeContactFields(){
        try {
            ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());
            webAction.sendText(contactUsPage.getNameField(), customer.getFirstName(),2,true);
            webAction.click(contactUsPage.getSubmitButton(), 1,true);
        }catch (WebActionsException e){
            Report.reportFailure("error al llenar algunos campos de contactUs",e);
        }
    }

    public List<String> getWarnMessages(){
        try {
            ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());
            warnMessages.add(webAction.getText(contactUsPage.getWarnEmailMessage(),1, true));
            warnMessages.add(webAction.getText(contactUsPage.getWarnEnquiryMessage(),1, true));
        }catch (WebActionsException e){
            Report.reportFailure("error al llenar los campos de contactUs",e);
        }
        return warnMessages;
    }
}
