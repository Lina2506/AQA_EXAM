package org.base.pages;

import org.base.config.PageTools;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.*;

public class ContactWindow extends PageTools {
    private String modalTitle="#exampleModalLabel";
    private String closeButtonInContactWindow="//div[@id='exampleModal']//button[text()='Close']";

    public void verifyContactWindowTitle(String title) {
        should("css", visible, modalTitle);
        Assert.assertEquals(getText("css", modalTitle), title);
    }
    public void clickCloseButtonInContactWindow() {
        should("xpath", clickable, closeButtonInContactWindow);
        click("xpath", closeButtonInContactWindow);
    }

}
