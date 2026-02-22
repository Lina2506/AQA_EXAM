package org.base.pages;

import com.codeborne.selenide.*;
import org.base.config.PageTools;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;

public class CartPage extends PageTools {
    private static final String PRODUCT_NAMES = "//tbody[@id='tbodyid']//tr/td[2]";
    private static final String DELETE_BUTTONS = "//tbody[@id='tbodyid']//tr/td[4]/a";
    private static final String TOTAL_PRICE = "//h3[@id='totalp']";
    private static final String PLACE_ORDER_BUTTON = "//button[text()='Place Order']";

    public ElementsCollection getProductNames() {
        return getElements("xpath", PRODUCT_NAMES);
    }

    public int getTotalPrice() {
        SelenideElement totalElement=getElement("xpath", TOTAL_PRICE);
        totalElement.shouldBe(visible, Duration.ofSeconds(15));
        return Integer.parseInt(totalElement.getText().trim().replaceAll("[^0-9]",""));
    }
    public void deleteProductByName(String productName) {
        int previousTotal=getTotalPrice();

        ElementsCollection names = getProductNames();
        ElementsCollection delete = getElements("xpath", DELETE_BUTTONS);

        for (int i = 0; i < names.size(); i++) {
             if (names.get(i).text().contains(productName)) {
                 delete.get(i).shouldBe(visible, Duration.ofSeconds(5));
                 delete.get(i).click();
                 names.get(i).should(disappear, Duration.ofSeconds(5));

                 getElement("xpath", TOTAL_PRICE).shouldNotHave(exactText(String.valueOf(previousTotal)),Duration.ofSeconds(5));
                 return;
             }
        }
        throw new AssertionError("Product not found: " + productName);
    }
    public void clickPlaceOrderButton() {
        should("xpath", clickable, Duration.ofSeconds(10), PLACE_ORDER_BUTTON);
        click("xpath", PLACE_ORDER_BUTTON);
    }
}
