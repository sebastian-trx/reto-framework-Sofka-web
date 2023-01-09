package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.model.Customer;
import co.com.client.webproject.test.page.BooksPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class BooksPageController {

    private WebAction webAction;

    public void setWebAction(WebAction webAction){
        this.webAction = webAction;
    }

    public void addBooksToCart(){
        try {
            BooksPage booksPage = new BooksPage(webAction.getDriver());
            webAction.moveTo(booksPage.getButtonBook1(), 1,true);
            webAction.click(booksPage.getButtonBook1(), 1,true);
            webAction.click(booksPage.getButtonBook2(), 2,true);
            webAction.moveTo(booksPage.getButtonBook3(), 1,true);
            webAction.click(booksPage.getButtonBook3(), 2,true);
            webAction.moveTo(booksPage.getShoppingCart(), 1,true);
            webAction.click(booksPage.getShoppingCart(), 2,true);
        }catch (WebActionsException e){
            Report.reportFailure("error al agregar libros al carrito de compras");
        }

    }
}
