package org.base.helpers;

import com.codeborne.selenide.Selenide;
import org.testng.Assert;

public class AlertDialogs {
    public static String getAlertText() {
        return Selenide.switchTo().alert().getText();
    }
    public static void acceptAlert() {
        Selenide.switchTo().alert().accept();
    }
    public static void verifyAlertText(String text) {
        String actualText = getAlertText();
        Assert.assertEquals(actualText, text);
        acceptAlert();
    }
    public static void closeAlert() {
        String text = getAlertText();
        acceptAlert();
    }
}
