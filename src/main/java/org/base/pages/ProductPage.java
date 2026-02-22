package org.base.pages;

import org.base.config.PageTools;

import static com.codeborne.selenide.Condition.clickable;

public class ProductPage extends PageTools {
    private static final String ADD_TO_CART_BUTTON = "//a[text()='Add to cart']";

    public void clickAddToCartButton() {
        should("xpath", clickable, ADD_TO_CART_BUTTON);
        click("xpath", ADD_TO_CART_BUTTON);
    }
}
