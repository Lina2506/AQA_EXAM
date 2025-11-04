package org.base.pages;

import org.base.config.PageTools;

import static com.codeborne.selenide.Condition.clickable;

public class ContactWindow extends PageTools {
    private String closeButtonInContactWindow="//div[@id='exampleModal']//button[text()='Close']";

    public void clickCloseButtonInContactWindow() {
        should("xpath", clickable, closeButtonInContactWindow);
        click("xpath", closeButtonInContactWindow);
    }

}
