package org.base.pages;

import com.codeborne.selenide.*;
import org.base.config.PageTools;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;

public class CartPage extends PageTools {
    private String productNames="//tbody[@id='tbodyid']//tr/td[2]";
    private String productPrices="//tbody[@id='tbodyid']/tr/td[3]";
    private String deleteButtons="//tbody[@id='tbodyid']//tr/td[4]/a";
    private String totalPrice ="//h3[@id='totalp']";
    private String placeOrderButton="//button[text()='Place Order']";

    public ElementsCollection getProductNames() {
        return getElements("xpath", productNames);
    }

    public int getTotalPrice() {
        SelenideElement totalElement=getElement("xpath", totalPrice);
        totalElement.shouldBe(visible, Duration.ofSeconds(15));
        return Integer.parseInt(totalElement.getText().trim().replaceAll("[^0-9]",""));
    }
    public void deleteProductByName(String productName) {
        ElementsCollection names = getProductNames();
        ElementsCollection delete = getElements("xpath", deleteButtons);

        for (int i = 0; i < names.size(); i++) {
             if (names.get(i).text().contains(productName)) {
                 delete.get(i).shouldBe(visible, Duration.ofSeconds(5));
                 delete.get(i).click();

                 names.get(i).should(disappear, Duration.ofSeconds(5));
                 break;
             }
        }
    }
    public void clickPlaceOrderButton() {
        should("xpath", clickable, Duration.ofSeconds(10), placeOrderButton);
        click("xpath", placeOrderButton);
    }
}
