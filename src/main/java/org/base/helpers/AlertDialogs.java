package org.base.helpers;

import com.codeborne.selenide.Selenide;

public class AlertDialogs {
    public static String getAlertText() {
        return Selenide.switchTo().alert().getText();
    }
    public static void acceptAlert() {
        Selenide.switchTo().alert().accept();
    }
}
