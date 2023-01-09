package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.model.Customer;
import co.com.client.webproject.test.page.RegisterPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class RegisterPageController {
    private WebAction webAction;
    private Customer customer;


    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setWebAction(WebAction webAction){
        this.webAction = webAction;
    }

    public void fillRegisterFields(){
        try {
            RegisterPage registerPage = new RegisterPage(webAction.getDriver());
            webAction.click(registerPage.getGenderMale(),1,true);
            webAction.sendText(registerPage.getFirstName(),customer.getFirstName(),1,true);
            webAction.sendText(registerPage.getLastName(),customer.getLastName(),1,true);
            webAction.sendText(registerPage.getEmail(), customer.getEmail(),1,true);
            webAction.sendText(registerPage.getPassword(),customer.getPassword(),1,true);
            webAction.sendText(registerPage.getConfirmPassword(), customer.getPassword(),1,true);
            webAction.click(registerPage.getRegisterButton(),1,true);
        }catch (WebActionsException e){
            Report.reportFailure("error al llenar los campos del formulario de registro",e);
        }
    }
}
