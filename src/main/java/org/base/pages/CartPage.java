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
        shouldCollection("xpath", CollectionCondition.sizeGreaterThan(0), productNames);
        return getElements("xpath", productNames);
    }

    public int getTotalPrice() {

        shouldCollection("xpath", CollectionCondition.sizeGreaterThan(0), productNames);
        SelenideElement totalElement=getElement("xpath", totalPrice);
        totalElement.shouldBe(visible, Duration.ofSeconds(15));

        totalElement.shouldNotBe(exactText(""), Duration.ofSeconds(10));

        String totalText=totalElement.getText().trim();
        String cleanText=totalText.replaceAll("[^0-9]","");
        return Integer.parseInt(cleanText);
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
