package org.base.pages;

import org.base.config.PageTools;

import static com.codeborne.selenide.Condition.*;
import static org.base.helpers.CustomConditions.*;

public class SignUpPage extends PageTools {
    private final String usernameInput="//input[@id='sign-username']";
    private final String passwordInput="//input[@id='sign-password']";
    private final String signUpButton="//button[@id='sign-up-button']";

    public void typeUsername(String username) {
        should("xpath", inputCondition, usernameInput);
        type("xpath", username, usernameInput);
    }
    public void typePassword(String password) {
        should("xpath", inputCondition, passwordInput);
        type("xpath", password, passwordInput);
    }
    public void clickSignUpButton() {
        should("xpath", clickable, signUpButton);
        click("xpath", signUpButton);
    }
}
