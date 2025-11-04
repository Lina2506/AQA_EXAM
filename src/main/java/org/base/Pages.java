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
   private static ContactWindow contactWindow;
   private static AboutUsWindow aboutUsWindow;
   private static DetailProductPage detailProductPage;


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
    public static ContactWindow contactWindow() {
       if(contactWindow == null) {
           contactWindow = new ContactWindow();
       }
       return contactWindow;
    }
    public static AboutUsWindow aboutUsWindow() {
       if(aboutUsWindow == null) {
           aboutUsWindow = new AboutUsWindow();
       }
       return aboutUsWindow;
    }
    public static DetailProductPage detailProductPage() {
       if(detailProductPage == null) {
           detailProductPage = new DetailProductPage();
       }
       return detailProductPage;
    }
    }
