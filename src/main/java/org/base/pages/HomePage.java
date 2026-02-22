package org.base.pages;

import com.codeborne.selenide.*;
import org.base.config.PageTools;
import org.base.models.Product;

import java.time.Duration;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.*;

public class HomePage extends PageTools {

    private static final Logger log = LoggerFactory.getLogger(HomePage.class);

    private static final String HOME_BUTTON_IN_NAVIGATION_MENU = "//div[@id='navbarExample']//a[text()='Home ']";
    private static final String CONTACT_BUTTON_IN_NAVIGATION_MENU = "//div[@id='navbarExample']//a[text()='Contact']";
    private static final String ABOUT_US_BUTTON_IN_NAVIGATION_MENU = "//div[@id='navbarExample']//a[text()='About us']";
    private static final String SIGN_UP_BUTTON_IN_NAVIGATION_MENU = "//a[@id='signin2']";
    private static final String LOG_IN_BUTTON_IN_NAVIGATION_MENU = "#login2";
    private static final String CART_BUTTON_IN_NAVIGATION_MENU = "#cartur";
    private static final String LOG_OUT_BUTTON_IN_NAVIGATION_MENU = "#logout2";
    private static final String CATEGORIES_LOCATOR = "//div[@class='list-group']/a[position()>1]";
    private static final String PRODUCT_NAMES = "//h4[@class='card-title']/a";
    private static final String PRODUCT_PRICES = "//h4[@class='card-title']/following-sibling::h5";
    private static final String PRODUCT_DESCRIPTIONS = "//p[@id='article']";


    public void clickHomeButtonInNavigationMenu() {
        should("xpath", clickable, HOME_BUTTON_IN_NAVIGATION_MENU);
        click("xpath", HOME_BUTTON_IN_NAVIGATION_MENU);
    }
    public void clickContactButtonInNavigationMenu() {
        should("xpath", clickable, CONTACT_BUTTON_IN_NAVIGATION_MENU);
        click("xpath", CONTACT_BUTTON_IN_NAVIGATION_MENU);
    }
    public void clickAboutUsButtonInNavigationMenu() {
        should("xpath", clickable, ABOUT_US_BUTTON_IN_NAVIGATION_MENU);
        click("xpath", ABOUT_US_BUTTON_IN_NAVIGATION_MENU);
    }
    public void clickSignUpButtonInNavigationMenu() {
        should("xpath", clickable, SIGN_UP_BUTTON_IN_NAVIGATION_MENU);
        click("xpath", SIGN_UP_BUTTON_IN_NAVIGATION_MENU);
    }

    public void clickLogInButtonInNavigationMenu() {
        should("css", clickable, LOG_IN_BUTTON_IN_NAVIGATION_MENU);
        click("css", LOG_IN_BUTTON_IN_NAVIGATION_MENU);
    }
    public SelenideElement getLogInButton(){
        return getElement("css", LOG_IN_BUTTON_IN_NAVIGATION_MENU);
    }
    public ElementsCollection getProducts(){
        return getElements("xpath", PRODUCT_NAMES);
    }
    public void clickOnProductByName(String productName) {
        ElementsCollection products = getProducts();
        products.findBy(text(productName)).click();
    }
    public void clickCartButtonInNavigationMenu() {
        should("css", clickable, CART_BUTTON_IN_NAVIGATION_MENU);
        click("css", CART_BUTTON_IN_NAVIGATION_MENU);
    }
    public void clickLogOutButtonInNavigationMenu() {
        SelenideElement logOutButton = getElement("css", LOG_OUT_BUTTON_IN_NAVIGATION_MENU);
        logOutButton.shouldBe(visible, Duration.ofSeconds(10));

        try{
            logOutButton.shouldBe(interactable, Duration.ofSeconds(10));
            logOutButton.scrollTo();
            logOutButton.click();
        } catch (Exception e){
            log.warn("Standard click failed, using JavaScript click...");
            Selenide.executeJavaScript("arguments[0].click();", logOutButton);
        }
    }
    public ElementsCollection getCategories() {
        return getElements("xpath", CATEGORIES_LOCATOR);
    }

    public List<String> getCategoryNames() {
        return getCategories().texts();
    }

    public List<Product>getProductList(){
        List<Product> productList=new ArrayList<>();

        ElementsCollection names = getElements("xpath", PRODUCT_NAMES);
        ElementsCollection prices = getElements("xpath", PRODUCT_PRICES);
        ElementsCollection descriptions = getElements("xpath", PRODUCT_DESCRIPTIONS);

        for (int i = 0; i < names.size(); i++) {
            Product product = new Product();

            product.setName(names.get(i).text());
            product.setPrice(Integer.parseInt(prices.get(i).text().replace("$", "").trim()));
            product.setDescription(descriptions.get(i).text());

            productList.add(product);
        }
        return productList;
    }
}
