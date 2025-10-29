package org.base.pages;

import org.base.config.PageTools;

import static com.codeborne.selenide.Condition.clickable;

public class CartPage extends PageTools {
//title ="(//tbody[@id='tbodyid']/tr/td)[2]"
//price="(//tbody[@id='tbodyid']/tr/td)[3]"
//delete="//tbody[@id='tbodyid']/tr/td/a"
    private String totalPrice ="//h3[@id='totalp']";
    private String placeOrderButton="//button[text()='Place Order']";

    public void clickPlaceOrderButton() {
        should("xpath", clickable, placeOrderButton);
        click("xpath", placeOrderButton);
    }
}
