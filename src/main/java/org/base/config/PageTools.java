package org.base.config;

import com.codeborne.selenide.WebElementCondition;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class PageTools {
    public String locatorFormatter(String locator, Object... args ) {
        return String.format(locator, args);
    }
    public void should(String locatorType, WebElementCondition condition, String locator, Object... args) {
        switch (locatorType){
            case "xpath":
                $(byXpath(locatorFormatter(locator, args))).shouldBe(condition);
                break;
            case "css":
                $(byCssSelector(locatorFormatter(locator, args))).shouldBe(condition);
                break;
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }
    }
    public void type(String locatorType, String text, String locator, Object... args) {
        switch (locatorType){
            case "xpath":
                $(byXpath(locatorFormatter(locator, args))).append(text);
                break;
            case "css":
                $(byCssSelector(locatorFormatter(locator, args))).append(text);
                break;
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }
    }
    public void click(String locatorType, String locator, Object... args) {
        switch (locatorType){
            case "xpath":
                $(byXpath(locatorFormatter(locator, args))).click();
                break;
            case "css":
                $(byCssSelector(locatorFormatter(locator, args))).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }
    }
}
