package org.base.pages;

import org.base.config.PageTools;

import static com.codeborne.selenide.Condition.*;
import static org.base.helpers.CustomConditions.*;

public class LogInPage extends PageTools {
    private final String usernameLoginInput="#loginusername";
    private final String passwordLoginInput="#loginpassword";
    private final String loginButton="//button[text()='Log in']";

    public void typeLoginUsername(String username) {
        should("css", inputCondition, usernameLoginInput);
        type("css", username, usernameLoginInput);
    }
    public void typeLoginPassword(String password) {
        should("css", inputCondition, passwordLoginInput);
        type("css", password, passwordLoginInput);
    }
    public void clickLoginButton() {
        should("xpath", clickable, loginButton);
        click("xpath", loginButton);
    }
}
