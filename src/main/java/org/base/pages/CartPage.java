package org.base.pages;

import com.codeborne.selenide.*;
import org.base.config.PageTools;

import static com.codeborne.selenide.Condition.clickable;

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
        totalElement.shouldBe(Condition.visible);
        totalElement.shouldNotBe(Condition.exactText(""));
        return Integer.parseInt(getText("xpath",totalPrice));
    }
    public void deleteProductByName(String productName) {
        ElementsCollection names = getProductNames();
        ElementsCollection delete = getElements("xpath", deleteButtons);

        for (int i = 0; i < names.size(); i++) {
             if (names.get(i).text().contains(productName)) {
                 delete.get(i).click();
                 break;
             }
        }
    }
    public void clickPlaceOrderButton() {
        should("xpath", clickable, placeOrderButton);
        click("xpath", placeOrderButton);
    }
}
