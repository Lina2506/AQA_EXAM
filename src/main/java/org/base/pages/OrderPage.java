package org.base.pages;

import org.base.config.PageTools;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static org.base.helpers.CustomConditions.*;

public class OrderPage extends PageTools {
    private final String nameForOrderInput = "//input[@id='name']";
    private final String countryForOrderInput = "//input[@id='country']";
    private final String cityForOrderInput = "//input[@id='city']";
    private final String creditcardForOrderInput = "//input[@id='card']";
    private final String monthForOrderInput = "//input[@id='month']";
    private final String yearForOrderInput = "//input[@id='year']";
    private String purchaseButton = "//button[text()='Purchase']";

    public void typeOrderNameInput(String orderName) {
        should("xpath", inputCondition, nameForOrderInput);
        type("xpath", orderName, nameForOrderInput);
    }

    public void typeOrderCountryInput(String orderCountry) {
        should("xpath", inputCondition, countryForOrderInput);
        type("xpath", orderCountry, countryForOrderInput);
    }

    public void typeOrderCityInput(String orderCity) {
        should("xpath", inputCondition, cityForOrderInput);
        type("xpath", orderCity, cityForOrderInput);
    }

    public void typeOrderCreditCardInput(String orderCreditCard) {
        should("xpath", inputCondition, creditcardForOrderInput);
        type("xpath", orderCreditCard, creditcardForOrderInput);
    }

    public void typeOrderMonthInput(String orderMonth) {
        should("xpath", inputCondition, monthForOrderInput);
        type("xpath", orderMonth, monthForOrderInput);
    }

    public void typeOrderYearInput(String orderYear) {
        should("xpath", inputCondition, yearForOrderInput);
        type("xpath", orderYear, yearForOrderInput);
    }

    public void clickPurchaseButton() {
        should("xpath", clickable, Duration.ofSeconds(10), purchaseButton);
        click("xpath", purchaseButton);
    }

}