package co.com.client.webproject.test.stepdefinition;

import co.com.client.webproject.test.controllers.*;
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
import static co.com.client.webproject.test.helpers.Helper.generateCustomer;


public class ComprarProductosLogueadoStepDefinition extends GeneralSetup{

    private WebAction webAction;
    private Customer customer;
    private Customer customer2;
    private Integer flag = 0;

    @Before
    public void setUp(Scenario scenario) {
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
        customer = generateCustomer(SPANISH_CODE_LANGUAGE, COUNTRY_CODE, EMAIL_DOMAIN);
        customer2 = generateCustomer(SPANISH_CODE_LANGUAGE, COUNTRY_CODE, EMAIL_DOMAIN);
    }

    @Dado("que el cliente esta en la pagina de inicio")
    public void queElClienteEstaEnLaPaginaDeInicio() {
        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setFeature(testInfo.getFeatureName());
        startBrowserWebController.abrirTiendaOnline();
    }

    @Cuando("se registra y queda logeado")
    public void  seRegistraYQuedaLogeado() {
        LandingPageController landingPageController = new LandingPageController();
        landingPageController.setWebAction(webAction);
        landingPageController.goToRegisterPage();

        RegisterPageController registerPageController = new RegisterPageController();

        flag++;
        if (flag <=1) registerPageController.setCustomer(customer);
        else registerPageController.setCustomer(customer2);

        registerPageController.setWebAction(webAction);
        registerPageController.fillRegisterFields();

    }

    @Y("realiza una compra")
    public void realizaUnaCompra() {
        LandingPageController landingPageController = new LandingPageController();
        landingPageController.setWebAction(webAction);
        landingPageController.goToBooks();

        BooksPageController booksPageController = new BooksPageController();
        booksPageController.setWebAction(webAction);
        booksPageController.addBooksToCart();

        CartPageController cartPageController = new CartPageController();
        cartPageController.setWebAction(webAction);
        cartPageController.aceptTerms();

        CheckOutPageController checkOutPageController = new CheckOutPageController();
        checkOutPageController.setCustomer(customer);
        checkOutPageController.setWebAction(webAction);
        checkOutPageController.fillCheckOutFields();

        CheckOutCompleteController checkOutCompleteController = new CheckOutCompleteController();
        checkOutCompleteController.setWebAction(webAction);
        checkOutCompleteController.goToOrderDetails();
    }

    @Entonces("el sistema responde con los datos correctos del usuario")
    public void elSistemaRespondeConLosDatosCorrectosDelUsuario() {
        OrderDetailsPageController orderDetailsPageController = new OrderDetailsPageController();
        orderDetailsPageController.setWebAction(webAction);

        ArrayList<String> dataOrderDetailsValidatable = new ArrayList<>();
        dataOrderDetailsValidatable.add(customer.getFirstName()+" "+customer.getLastName());
        dataOrderDetailsValidatable.add("Email: "+customer.getEmail());
        dataOrderDetailsValidatable.add(customer.getAddress());
        dataOrderDetailsValidatable.add(customer.getCountry());
        dataOrderDetailsValidatable.add("Phone: "+customer.getMobilePhone());

        Assert.Hard.thatListIsEqual(orderDetailsPageController.getDataOrderDetails(),dataOrderDetailsValidatable);
    }

    @Y("realiza la compra llenando algunos campos del formulario de detalles de pago")
    public void realizaLaCompraLlenandoAlgunosCamposDelFormularioDeDetallesDePago() {
        LandingPageController landingPageController = new LandingPageController();
        landingPageController.setWebAction(webAction);
        landingPageController.goToBooks();

        BooksPageController booksPageController = new BooksPageController();
        booksPageController.setWebAction(webAction);
        booksPageController.addBooksToCart();

        CartPageController cartPageController = new CartPageController();
        cartPageController.setWebAction(webAction);
        cartPageController.aceptTerms();

    }
    @Entonces("el sistema mostrara un mensaje en los campos obligatorios vacios")
    public void elSistemaMostraraUnMensajeEnLosCamposObligatoriosVacios() {
        CheckOutPageController checkOutPageController = new CheckOutPageController();
        checkOutPageController.setWebAction(webAction);
        ArrayList<String> warningMessagesFromEmptyFields = new ArrayList<>();
        warningMessagesFromEmptyFields.add("Country is required.");
        warningMessagesFromEmptyFields.add("City is required");
        warningMessagesFromEmptyFields.add("Street address is required");
        warningMessagesFromEmptyFields.add("Zip / postal code is required");
        warningMessagesFromEmptyFields.add("Phone is required");
        Assert.Hard.thatListIsEqual(checkOutPageController.emptyCheckOutFields(),warningMessagesFromEmptyFields);
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
