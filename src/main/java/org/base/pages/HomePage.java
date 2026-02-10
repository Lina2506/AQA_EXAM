package org.base.pages;

import com.codeborne.selenide.*;
import org.base.config.PageTools;
import org.base.models.Product;

import java.time.Duration;
import java.util.*;

import static com.codeborne.selenide.Condition.*;

public class HomePage extends PageTools {
    private String homeButtonInNavigationMenu="//div[@id='navbarExample']//a[text()='Home ']";
    private String contactButtonInNavigationMenu="//div[@id='navbarExample']//a[text()='Contact']";
    private String aboutUsButtonInNavigationMenu="//div[@id='navbarExample']//a[text()='About us']";
    private String signUpButtonInNavigationMenu="//a[@id='signin2']";
    private String logInButtonInNavigationMenu="#login2";
    private String cartButtonInNavigationMenu="#cartur";
    private String logOutButtonInNavigationMenu="#logout2";
    private String categoriesLocator = "//div[@class='list-group']/a[position()>1]";
    private String productNames="//h4[@class='card-title']/a";
    private String productPrices="//h4[@class='card-title']/following-sibling::h5";
    private String productDescriptions="//p[@id='article']";


    public void clickHomeButtonInNavigationMenu() {
        should("xpath", clickable, homeButtonInNavigationMenu);
        click("xpath", homeButtonInNavigationMenu);
    }
    public void clickContactButtonInNavigationMenu() {
        should("xpath", clickable, contactButtonInNavigationMenu);
        click("xpath", contactButtonInNavigationMenu);
    }
    public void clickAboutUsButtonInNavigationMenu() {
        should("xpath", clickable, aboutUsButtonInNavigationMenu);
        click("xpath", aboutUsButtonInNavigationMenu);
    }
    public void clickSignUpButtonInNavigationMenu() {
        should("xpath", clickable, signUpButtonInNavigationMenu);
        click("xpath", signUpButtonInNavigationMenu);
    }

    public void clickLogInButtonInNavigationMenu() {
        should("css", clickable, logInButtonInNavigationMenu);
        click("css", logInButtonInNavigationMenu);
    }
    public void assertLoginButtonVisible() {
        should("css", visible, logInButtonInNavigationMenu);
    }
    public ElementsCollection getProducts(){
        shouldCollection("xpath", CollectionCondition.size(9), productNames);
        return getElements("xpath", productNames);
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
        SelenideElement logOutButton = getElement("css", logOutButtonInNavigationMenu);
        logOutButton.shouldBe(visible, Duration.ofSeconds(10));

        try{
            logOutButton.shouldBe(interactable, Duration.ofSeconds(10));
            logOutButton.scrollTo();
            logOutButton.click();
        } catch (Exception e){
            System.out.println("Standard click failed, using JavaScript click...");
            Selenide.executeJavaScript("arguments[0].click();", logOutButton);
        }
    }
    public ElementsCollection getCategories() {
        return getElements("xpath", categoriesLocator);
    }

    public List<String> getCategoryNames() {
        shouldCollection("xpath", CollectionCondition.sizeGreaterThan(0), categoriesLocator);
        return getCategories().texts();
    }

    public List<Product>getProductList(){
        List<Product> productList=new ArrayList<>();

        shouldCollection("xpath", CollectionCondition.size(9), productNames);
        shouldCollection("xpath", CollectionCondition.size(9), productPrices);
        shouldCollection("xpath", CollectionCondition.size(9), productDescriptions);

        ElementsCollection names = getElements("xpath", productNames);
        ElementsCollection prices = getElements("xpath", productPrices);
        ElementsCollection descriptions = getElements("xpath", productDescriptions);

        // Чекаємо поки всі елементи стануть видимими
        names.first().shouldBe(visible, Duration.ofSeconds(5));
        prices.first().shouldBe(visible, Duration.ofSeconds(5));
        descriptions.first().shouldBe(visible, Duration.ofSeconds(5));

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

