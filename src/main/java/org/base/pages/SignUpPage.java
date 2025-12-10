package org.base.pages;

import org.base.config.PageTools;

import static com.codeborne.selenide.Condition.*;
import static org.base.helpers.CustomConditions.*;

public class SignUpPage extends PageTools {
    private final String usernameInput="//input[@id='sign-username']";
    private final String passwordInput="//input[@id='sign-password']";
    private String signUpButton="//button[text()='Sign up']";
    private String closeWindowButton="(//button[@class='close']/span)[2]";


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
    public void clickCloseWindowButton() {
        should("xpath", clickable, closeWindowButton);
        click("xpath", closeWindowButton);
    }
}