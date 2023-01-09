package co.com.client.webproject.test.stepdefinition.contactus;

import co.com.client.webproject.test.controllers.ContactUsPageController;
import co.com.client.webproject.test.controllers.LandingPageController;
import co.com.client.webproject.test.controllers.openwebpages.StartBrowserWebController;
import co.com.client.webproject.test.data.objects.TestInfo;
import co.com.client.webproject.test.model.Customer;
import co.com.client.webproject.test.stepdefinition.setup.GeneralSetup;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Assert;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;

import java.util.ArrayList;

import static co.com.client.webproject.test.helpers.Dictionary.*;
import static co.com.client.webproject.test.helpers.Dictionary.EMAIL_DOMAIN;
import static co.com.client.webproject.test.helpers.Helper.generateCustomer;

public class ContactUsStepDefinition extends GeneralSetup {

    private WebAction webAction;
    private Customer customer;

    @Before
    public void setUp(Scenario scenario) {
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
        customer = generateCustomer(SPANISH_CODE_LANGUAGE, COUNTRY_CODE, EMAIL_DOMAIN);
    }

    @Dado("que el cliente esta en la pagina de inicio")
    public void queElClienteEstaEnLaPaginaDeInicio() {
        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setFeature(testInfo.getFeatureName());
        startBrowserWebController.abrirTiendaOnline();
    }

    @Cuando("se dirige al apartado de contactUs")
    public void seDirigeAlApartadoDeContactUs() {
        LandingPageController landingPageController = new LandingPageController();
        landingPageController.setWebAction(webAction);
        landingPageController.goToContactUs();
    }

    @Y("diligencia todos los campos")
    public void diligenciaTodosLosCampos() {
        ContactUsPageController contactUsPageController = new ContactUsPageController();
        contactUsPageController.setWebAction(webAction);
        contactUsPageController.setCustomer(customer);
        contactUsPageController.fillContactFields();
    }

    @Entonces("la pagina muestra un mensaje exitoso")
    public void laPaginaMuestraUnMensajeExitoso() {
        ContactUsPageController contactUsPageController = new ContactUsPageController();
        contactUsPageController.setWebAction(webAction);
        Assert.Hard.thatString(
                 contactUsPageController.getSuccessfulMessage())
                .isEqualTo("Your enquiry has been successfully sent to the store owner."
                );
    }
    @Y("diligencia algunos los campos")
    public void diligenciaAlgunosLosCampos() {
        ContactUsPageController contactUsPageController = new ContactUsPageController();
        contactUsPageController.setWebAction(webAction);
        contactUsPageController.setCustomer(customer);
        contactUsPageController.fillSomeContactFields();
    }
    @Entonces("la pagina muestra un mensajes de advertencia")
    public void laPaginaMuestraUnMensajesDeAdvertencia() {
        ContactUsPageController contactUsPageController = new ContactUsPageController();
        contactUsPageController.setWebAction(webAction);

        ArrayList<String> warnMessagesValidatable = new ArrayList<>();
        warnMessagesValidatable.add("Enter email");
        warnMessagesValidatable.add("Enter enquiry");
        Assert.Hard.thatListIsEqual(contactUsPageController.getWarnMessages(),warnMessagesValidatable);
    }

    @After
    public void tearDown() throws WebActionsException {
        webAction.pause(5, false);
        //Cerrar el driver
        if (webAction != null && webAction.getDriver() != null)
            webAction.closeBrowser();

        Report.reportInfo("***** HA FINALIZADO LA PRUEBA******"
                .concat(testInfo.getFeatureName())
                .concat("-")
                .concat(testInfo.getScenarioName()));
    }

}
