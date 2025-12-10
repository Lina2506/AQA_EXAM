package org.base.pages;

import org.base.config.PageTools;

import static com.codeborne.selenide.Condition.*;

public class ContactWindow extends PageTools {
    private String modalTitle="#exampleModalLabel";
    private String closeButtonInContactWindow="//div[@id='exampleModal']//button[text()='Close']";

    public String getContactWindowTitle() {
        should("css", visible, modalTitle);
        return getText("css", modalTitle);
    }
    public void clickCloseButtonInContactWindow() {
        should("xpath", clickable, closeButtonInContactWindow);
        click("xpath", closeButtonInContactWindow);
    }
}
