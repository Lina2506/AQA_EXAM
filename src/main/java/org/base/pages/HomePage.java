package org.base.pages;

import com.codeborne.selenide.*;
import org.base.config.PageTools;

import static com.codeborne.selenide.Condition.*;

public class HomePage extends PageTools {
    private String signUpButtonInNavigationMenu="//a[@id='signin2']";
    private String logInButtonInNavigationMenu="#login2";
    private String cartButtonInNavigationMenu="#cartur";
    private String logOutButtonInNavigationMenu="#logout2";
    private String productName="//h4[@class='card-title']/a";
    private String productPrice="//h4[@class='card-title']/following-sibling::h5";
    private String productDescription="//p[@id='article']";

    public void clickSignUpButtonInNavigationMenu() {
        should("xpath", clickable, signUpButtonInNavigationMenu);
        click("xpath", signUpButtonInNavigationMenu);
    }

    public void clickLogInButtonInNavigationMenu() {
        should("css", clickable, logInButtonInNavigationMenu);
        click("css", logInButtonInNavigationMenu);
    }
    public ElementsCollection getProducts(){
        shouldCollection("xpath", CollectionCondition.size(9), productName);
        return getElements("xpath", productName);
    }
    public void clickOnProductByName(String productName) {
        ElementsCollection products = getProducts();
        products.findBy(text(productName)).click();
    }
    public void clickCartButtonInNavigationMenu() {
        should("css", clickable, cartButtonInNavigationMenu);
        click("css", cartButtonInNavigationMenu);
    }
    public void clickLogOutButtonInNavigationMenu() {
        getElement("css", logOutButtonInNavigationMenu)
                .shouldBe(Condition.interactable)
                .click();
    }
}
