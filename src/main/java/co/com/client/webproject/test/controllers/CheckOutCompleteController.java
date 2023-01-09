package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.page.CheckOutCompletePage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class CheckOutCompleteController {

    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void goToOrderDetails(){
        try{
            CheckOutCompletePage checkOutCompletePage = new CheckOutCompletePage(webAction.getDriver());
            webAction.click(checkOutCompletePage.getOrderDetailsLink(), 2,true);
        }catch (WebActionsException e){
            Report.reportFailure("error al intentar ir a detalles de la orden",e);
        }
    }

}
