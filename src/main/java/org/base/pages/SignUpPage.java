package org.base.pages;

import org.base.config.PageTools;
import org.base.helpers.AlertDialogs;

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

        String alertText = AlertDialogs.getAlertText();

        if (alertText.equals("Sing up successful.")){
            AlertDialogs.acceptAlert();
            System.out.println("Registration successful.");
        } else if (alertText.equals("This user already exist.")){
            AlertDialogs.acceptAlert();
            System.out.println("User already exist.");
        }else{
            throw new AssertionError(alertText);
        }
        clickCloseWindowButton();
    }
    public void clickCloseWindowButton() {
        should("xpath", clickable, closeWindowButton);
        click("xpath", closeWindowButton);
    }
}