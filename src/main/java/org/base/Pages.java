package org.base;

import org.base.pages.*;

public class Pages {
    private static HomePage homePage;
   private static SignUpPage signUpPage;
   private static LogInPage logInPage;
   private static ProductPage productPage;
   private static CartPage cartPage;
   private static OrderPage orderPage;
   private static OrderNotification orderNotification;


   public static HomePage homePage() {
       if(homePage == null) {
           homePage = new HomePage();
       }
       return homePage;
   }
    public static SignUpPage signUpPage() {
        if(signUpPage == null) {
            signUpPage = new SignUpPage();
        }
        return signUpPage;
    }
    public static LogInPage logInPage() {
       if(logInPage == null) {
           logInPage = new LogInPage();
       }
       return logInPage;
    }
    public static ProductPage productPage() {
       if(productPage == null) {
           productPage = new ProductPage();
       }
       return productPage;
    }
    public static CartPage cartPage() {
       if(cartPage == null) {
           cartPage = new CartPage();
       }
       return cartPage;
    }
    public static OrderPage orderPage() {
       if(orderPage == null) {
           orderPage = new OrderPage();
       }
       return orderPage;
    }
    public static OrderNotification orderNotification() {
       if(orderNotification == null) {
           orderNotification = new OrderNotification();
       }
       return orderNotification;
    }
    }
