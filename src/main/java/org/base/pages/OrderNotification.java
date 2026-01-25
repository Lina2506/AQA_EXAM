package org.base.pages;

import org.base.config.PageTools;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;

public class OrderNotification extends PageTools {
    private final String completeHeader="//h2[text()='Thank you for your purchase!']";
    private final String confirmButton="//button[@class='confirm btn btn-lg btn-primary']";

    public String getCompleteHeaderText() {
        should("xpath", visible, Duration.ofSeconds(15), completeHeader);
        return getText("xpath", completeHeader);
    }
    public void clickConfirmButton() {
        should("xpath", clickable, confirmButton, Duration.ofSeconds(10));
        click("xpath", confirmButton);
    }
}
