package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.model.Customer;
import co.com.client.webproject.test.page.CheckOutPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import java.util.ArrayList;
import java.util.List;

public class CheckOutPageController {
    private WebAction webAction;
    private Customer customer;

    ArrayList<String> warnFieldMessages = new ArrayList<>();

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setWebAction(WebAction webAction){
        this.webAction = webAction;
    }

    public void fillCheckOutFields(){
        try {
            CheckOutPage checkOutPage = new CheckOutPage(webAction.getDriver());
            webAction.selectByText(checkOutPage.getCountry(),customer.getCountry(),1,true);
            webAction.sendText(checkOutPage.getCity(),customer.getCity(),1,true);
            webAction.sendText(checkOutPage.getAddress1(),customer.getAddress(),1,true);
            webAction.sendText(checkOutPage.getZipCode(),customer.getPostalCode(),1,true);
            webAction.sendText(checkOutPage.getPhoneNumber(),customer.getMobilePhone(),1,true);
            webAction.moveTo(checkOutPage.getContinueButton1(),1,true);
            webAction.click(checkOutPage.getContinueButton1(),2,true);
            webAction.click(checkOutPage.getContinueButton2(),2,true);
            webAction.click(checkOutPage.getContinueButton3(),2,true);
            webAction.click(checkOutPage.getContinueButton4(),2,true);
            webAction.click(checkOutPage.getContinueButton5(),2,true);
            webAction.click(checkOutPage.getContinueButton6(),2,true);
        }catch (WebActionsException e){
            Report.reportFailure("error al llenar el formulario de finalizacion de compra",e);
        }
    }

    public List<String> emptyCheckOutFields(){
        try {
            CheckOutPage checkOutPage = new CheckOutPage(webAction.getDriver());
            webAction.moveTo(checkOutPage.getContinueButton1(),1,true);
            webAction.click(checkOutPage.getContinueButton1(),2,true);
            warnFieldMessages.add(webAction.getText(checkOutPage.getCountryWarnMessage(),1,true));
            warnFieldMessages.add(webAction.getText(checkOutPage.getCityWarnMessage(),1,true));
            warnFieldMessages.add(webAction.getText(checkOutPage.getAddressWarnMessage(),1,true));
            warnFieldMessages.add(webAction.getText(checkOutPage.getZipCodeWarnMessage(),1,true));
            warnFieldMessages.add(webAction.getText(checkOutPage.getPhoneWarnMessage(),1,true));
        }catch (WebActionsException e){
            Report.reportFailure("error al obtener los mensajes de los campos vacios del formulario",e);
        }
        return warnFieldMessages;
    }
}
