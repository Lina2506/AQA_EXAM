package org.base.pages;

import com.codeborne.selenide.conditions.Visible;
import org.base.config.PageTools;
import org.testng.Assert;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public class OrderNotification extends PageTools {
    private final String completeHeader="//h2[text()='Thank you for your purchase!']";
    private String confirmButton="//button[@class='confirm btn btn-lg btn-primary']";

    public void verifyCompleteHeaderVisiable(String message) {
        should("xpath", visible, completeHeader);
        String actualMessage = getText("xpath", completeHeader);

        Assert.assertEquals(actualMessage, message, "Message do not match");

    }
    public void clickConfirmButton() {
        should("xpath", visible, confirmButton);
        click("xpath", confirmButton);
    }
}
