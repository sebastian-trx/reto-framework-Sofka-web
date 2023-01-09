package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.page.LandingPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class LandingPageController {

    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void goToRegisterPage(){
        try {
            LandingPage landingPage = new LandingPage(webAction.getDriver());
            webAction.click(landingPage.getRegister(),2,true);
        }catch (WebActionsException e){
            Report.reportFailure("error al intentar ir a registro");
        }
    }

    public void goToBooks(){
        try {
            LandingPage landingPage = new LandingPage(webAction.getDriver());
            webAction.click(landingPage.getBooksLink(),1,true);
        }catch (WebActionsException e){
            Report.reportFailure("error al intentar ir al enlace de los libros");
        }
    }
}
