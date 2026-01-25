package ui;

import com.codeborne.selenide.Selenide;
import org.base.config.BaseTests;
import org.base.helpers.AlertDialogs;
import org.base.models.Product;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.base.Pages.*;
import static org.base.helpers.Constants.*;
import static org.base.helpers.TestDataForUITests.*;

public class CriticalTests extends BaseTests {
    @Test(groups = "critical", description = "Verify user is able to sign up")
    public void testSignUp() {
        homePage().clickSignUpButtonInNavigationMenu();
//        Selenide.sleep(1000);

        signUpPage().typeUsername(generateUserName());
        signUpPage().typePassword(DEFAULT_PASSWORD);
        signUpPage().clickSignUpButton();

        String alertTextSignUp = AlertDialogs.getAlertText();
        AlertDialogs.acceptAlert();
        Assert.assertTrue(alertTextSignUp.toLowerCase().contains("sign up successful"),
                "Expected 'sign up successful' but got " + alertTextSignUp);
        signUpPage().clickCloseWindowButton();
    }

    @Test (groups = "critical", description = "Verify user is able to login")
            public void testLogIn() {
        homePage().clickLogInButtonInNavigationMenu();

        logInPage().typeLoginUsername(LOGIN_USERNAME);
        logInPage().typeLoginPassword(LOGIN_PASSWORD);
        logInPage().clickLoginButton();
    }

    @Test(groups = "critical", dependsOnMethods = "testLogIn", description = "Verify user is able to select product")
        public void testProductSelection() {
    String productNameFromHomePage = homePage().getProducts().get(2).text();
    homePage().clickOnProductByName(productNameFromHomePage);
    Product selectedProduct = detailProductPage().getDetailProduct();
    Assert.assertEquals(selectedProduct.getName(), productNameFromHomePage, "Selected product name is matched");
}
    @Test(groups = "critical", dependsOnMethods = "testProductSelection", description = "Verify user is able to add product to cart")
        public void testAddProductToCart() {
    productPage().clickAddToCartButton();

    String alertTextAddToCart = AlertDialogs.getAlertText();
    Assert.assertTrue(alertTextAddToCart.contains("Product added"), "Expected 'Product added' but got" + alertTextAddToCart);
    AlertDialogs.acceptAlert();
    homePage().clickCartButtonInNavigationMenu();

}
    @Test(groups = "critical", dependsOnMethods = "testAddProductToCart", description = "Verify user is able to complete purchase")
        public void testCompletePurchase() {
        cartPage().clickPlaceOrderButton();
    orderPage().typeOrderNameInput(ORDER_NAME);
    orderPage().typeOrderCountryInput(ORDER_COUNTRY);
    orderPage().typeOrderCityInput(ORDER_CITY);
    orderPage().typeOrderCreditCardInput(ORDER_CREDITCARD);
    orderPage().typeOrderMonthInput(ORDER_MONTH);
    orderPage().typeOrderYearInput(ORDER_YEAR);
    orderPage().clickPurchaseButton();

//    Selenide.sleep(5000);

    String expectedMessage = "Thank you for your purchase!";
    String actualMessage = orderNotification().getCompleteHeaderText();

    Assert.assertEquals(actualMessage, expectedMessage, "Message do not match");

    orderNotification().clickConfirmButton();

//_______________________LogOut_____________________________________
        homePage().clickLogOutButtonInNavigationMenu();
        homePage().assertLoginButtonVisible();
    }
}
