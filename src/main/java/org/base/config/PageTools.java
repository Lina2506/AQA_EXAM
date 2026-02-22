package org.base.config;

import com.codeborne.selenide.*;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class PageTools {
    public String locatorFormatter(String locator, Object... args) {
        return String.format(locator, args);
    }
    public void should(String locatorType, WebElementCondition condition, String locator, Object... args) {
        should(locatorType, condition, Duration.ofSeconds(10), locator, args);
    }
    public void should(String locatorType, WebElementCondition condition, Duration timeout, String locator, Object... args) {
        switch (locatorType) {
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
        switch (locatorType) {
            case "xpath":
                $(byXpath(locatorFormatter(locator, args))).setValue(text);
                break;
            case "css":
                $(byCssSelector(locatorFormatter(locator, args))).setValue(text);
                break;
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }
    }
    public void click(String locatorType, String locator, Object... args) {
        switch (locatorType) {
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
    public void shouldCollection(String locatorType, WebElementsCondition condition, String locator, Object... args) {
        switch (locatorType) {
            case "xpath":
                $$(byXpath(locatorFormatter(locator, args))).shouldBe(condition);
                break;
            case "css":
                $$(byCssSelector(locatorFormatter(locator, args))).shouldBe(condition);
                break;
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }
    }
    public ElementsCollection getElements(String locatorType, String locator, Object... args) {
        switch (locatorType) {
            case "xpath":
                return $$(byXpath(locatorFormatter(locator, args)));
            case "css":
                return $$(byCssSelector(locatorFormatter(locator, args)));
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }
    }

    public String getText(String locatorType, String locator, Object... args) {
        switch (locatorType) {
            case "xpath":
                return $(byXpath(locatorFormatter(locator, args))).getText();
            case "css":
                return $(byCssSelector(locatorFormatter(locator, args))).getText();
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }
    }

    public SelenideElement getElement(String locatorType, String locator, Object... args) {
        switch (locatorType) {
            case "xpath":
                return $(byXpath(locatorFormatter(locator, args)));
            case "css":
                return $(byCssSelector(locatorFormatter(locator, args)));
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }
    }

    public List<String> getElementsText(String locatorType, String locator, Object... args) {
        switch (locatorType) {
            case "xpath":
                return $$(byXpath(locatorFormatter(locator, args))).texts();
            case "css":
                return $$(byCssSelector(locatorFormatter(locator, args))).texts();
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }
    }
}