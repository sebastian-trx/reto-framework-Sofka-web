package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.page.OrderDetailsPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailsPageController {
    private WebAction webAction;

    ArrayList<String> dataOrderDetails = new ArrayList<>();

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public List<String> getDataOrderDetails(){
        try {
            OrderDetailsPage orderDetailsPage = new OrderDetailsPage(webAction.getDriver());
            dataOrderDetails.add(webAction.getText(orderDetailsPage.getFullName(), 1,true));
            dataOrderDetails.add(webAction.getText(orderDetailsPage.getEmail(), 1,true));
            dataOrderDetails.add(webAction.getText(orderDetailsPage.getAddress(), 1,true));
            dataOrderDetails.add(webAction.getText(orderDetailsPage.getCountry(), 1,true));
            dataOrderDetails.add(webAction.getText(orderDetailsPage.getPhone(), 1,true));
        }catch (WebActionsException e){
            Report.reportFailure("error al intentar obtener los datos de la orden");
        }
        return dataOrderDetails;
    }
}
