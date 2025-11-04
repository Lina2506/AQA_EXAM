package org.base.pages;

import com.codeborne.selenide.Selenide;
import org.base.config.PageTools;
import org.base.helpers.AlertDialogs;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.clickable;

public class ProductPage extends PageTools {
    private final String addToCartButton="//a[text()='Add to cart']";

    public void clickAddToCartButton() {
        should("xpath", clickable, addToCartButton);
        click("xpath", addToCartButton);

        String alertDialog = Selenide.confirm();

    }
}
