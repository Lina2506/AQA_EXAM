package ui;

import com.codeborne.selenide.CollectionCondition;
import org.base.config.BaseTests;
import org.base.helpers.AlertDialogs;
import org.base.models.Product;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.base.Pages.*;
import static org.base.helpers.Constants.*;
import static org.base.helpers.TestDataForUITests.*;
import static com.codeborne.selenide.Condition.visible;



public class CriticalTests extends BaseTests {
    @Test(groups = "critical", priority = 1, description = "Verify user is able to sign up")
    public void testSignUp() {
        homePage().clickSignUpButtonInNavigationMenu();
        signUpPage().typeUsername(generateUserName());
        signUpPage().typePassword(DEFAULT_PASSWORD);
        signUpPage().clickSignUpButton();

        AlertDialogs.waitForAlert();
        String alertTextSignUp = AlertDialogs.getAlertText().toLowerCase();
        AlertDialogs.acceptAlert();


        Assert.assertTrue(alertTextSignUp.contains("sign up successful")||alertTextSignUp.contains("this user already exist"),"Unexpected sign up alert: "+alertTextSignUp);
        signUpPage().clickCloseWindowButton();
    }

    @Test (groups = "critical", priority = 2, description = "Verify user is able to login")
            public void testLogIn() {
        homePage().clickLogInButtonInNavigationMenu();

        logInPage().typeLoginUsername(LOGIN_USERNAME);
        logInPage().typeLoginPassword(LOGIN_PASSWORD);
        logInPage().clickLoginButton();
        homePage().getLogInButton().shouldBe(visible, Duration.ofSeconds(10));
    }

    @Test(groups = "critical", priority = 3, description = "Verify user is able to select product")
        public void testProductSelection() {
        loginAsDefaultUser();

    String productNameFromHomePage = homePage().getProducts().get(DEFAULT_PRODUCT_INDEX).text();
    homePage().clickOnProductByName(productNameFromHomePage);
    Product selectedProduct = detailProductPage().getDetailProduct();
    Assert.assertEquals(selectedProduct.getName(), productNameFromHomePage, "Selected product name is matched");
}
    @Test(groups = "critical", priority = 4, description = "Verify user is able to add product to cart")
        public void testAddProductToCart() {
       loginAsDefaultUser();

        String productNameFromHomePage = homePage().getProducts().get(DEFAULT_PRODUCT_INDEX).text();
        homePage().clickOnProductByName(productNameFromHomePage);

    productPage().clickAddToCartButton();

    String alertTextAddToCart = AlertDialogs.getAlertText();
    Assert.assertTrue(alertTextAddToCart.contains("Product added"), "Expected 'Product added' but got" + alertTextAddToCart);
    AlertDialogs.acceptAlert();
    homePage().clickCartButtonInNavigationMenu();
        cartPage().getProductNames().shouldHave(CollectionCondition.itemWithText(productNameFromHomePage));

    }
    @Test(groups = "critical", priority = 5, description = "Verify user is able to complete purchase")
        public void testCompletePurchase() {

        loginAsDefaultUser();

        String productNameFromHomePage = homePage().getProducts().get(DEFAULT_PRODUCT_INDEX).text();
        homePage().clickOnProductByName(productNameFromHomePage);

        productPage().clickAddToCartButton();
        AlertDialogs.acceptAlert();
        homePage().clickCartButtonInNavigationMenu();
        cartPage().clickPlaceOrderButton();
    orderPage().typeOrderNameInput(ORDER_NAME);
    orderPage().typeOrderCountryInput(ORDER_COUNTRY);
    orderPage().typeOrderCityInput(ORDER_CITY);
    orderPage().typeOrderCreditCardInput(ORDER_CREDITCARD);
    orderPage().typeOrderMonthInput(ORDER_MONTH);
    orderPage().typeOrderYearInput(ORDER_YEAR);
    orderPage().clickPurchaseButton();

    String expectedMessage = "Thank you for your purchase!";
    String actualMessage = orderNotification().getCompleteHeaderText();

    Assert.assertEquals(actualMessage, expectedMessage, "Message do not match");

    orderNotification().clickConfirmButton();

//_______________________LogOut_____________________________________
        homePage().clickLogOutButtonInNavigationMenu();
        homePage().getLogInButton().shouldBe(visible, Duration.ofSeconds(10));
    }
    private void loginAsDefaultUser() {
        homePage().clickLogInButtonInNavigationMenu();
        logInPage().typeLoginUsername(LOGIN_USERNAME);
        logInPage().typeLoginPassword(LOGIN_PASSWORD);
        logInPage().clickLoginButton();
        homePage().getLogInButton().shouldBe(visible, Duration.ofSeconds(10));
    }
}
