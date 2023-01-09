package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.page.CartPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class CartPageController {

    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void aceptTerms(){
        try {
            CartPage cartPage = new CartPage(webAction.getDriver());
            webAction.moveTo(cartPage.getAceptTerms(),1,true);
            webAction.click(cartPage.getAceptTerms(),1, true);
            webAction.moveTo(cartPage.getCheckoutButton(),1,true);
            webAction.click(cartPage.getCheckoutButton(),1, true);
        }catch (WebActionsException e){
            Report.reportFailure("error al intentar aceptar los terminos");
        }
    }
}
