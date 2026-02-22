package org.base.helpers;

import com.codeborne.selenide.Selenide;

import java.time.Duration;

public class AlertDialogs {
    public static String getAlertText() {
        return Selenide.switchTo().alert().getText();
    }
    public static void acceptAlert() {
        Selenide.switchTo().alert().accept();
    }
    public static void waitForAlert() {
        Selenide.Wait().withTimeout(Duration.ofSeconds(5)).until(webDriver ->{
          try {
              webDriver.switchTo().alert();
              return true;
          }catch (Exception e) {
              return false;
          }
        });
    }
}
