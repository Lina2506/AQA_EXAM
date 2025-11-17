package org.base.pages;

import org.base.config.PageTools;

import static com.codeborne.selenide.Condition.*;

public class AboutUsWindow extends PageTools {
    private String closeButtonInAboutUsWindow="//div[@id='videoModal']//button[text()='Close']";

    public void clickCloseButtonInAboutUsWindow() {
        should("xpath",clickable,closeButtonInAboutUsWindow);
        click("xpath", closeButtonInAboutUsWindow);
    }
}
