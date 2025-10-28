package org.base.pages;

import org.base.config.PageTools;
import org.base.helpers.AlertDialogs;

import static com.codeborne.selenide.Condition.*;
import static org.base.helpers.CustomConditions.*;

public class SignUpPage extends PageTools {
    private final String usernameInput="//input[@id='sign-username']";
    private final String passwordInput="//input[@id='sign-password']";
    private final String signUpButton="//button[text()='Sign up']";
    private final String closeWindowButton="(//button[@class='close']/span)[2]";


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

        if (alertText.equals("Sign up successful.")){
            System.out.println("Sign up successful.");
        }else if(alertText.equals("This user already exist.")){
            System.out.println("This user already exist.");
        }

        AlertDialogs.acceptAlert();;
        clickCloseWindowButton();
    }
    public void clickCloseWindowButton() {
        should("xpath", clickable, closeWindowButton);
        click("xpath", closeWindowButton);
    }
}