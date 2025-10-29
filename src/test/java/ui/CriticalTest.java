package ui;

import org.base.config.BaseTests;
import org.testng.annotations.Test;

import static org.base.Pages.*;
import static org.base.helpers.Constants.*;

public class CriticalTest extends BaseTests {
    @Test(description = "Verify user is able to buy item test")
    public void testBuyItem() {
//____________________SignUpTest__________________________________
        homePage().clickSignUpButtonInNavigationMenu();
        signUpPage().typeUsername(USERNAME);
        signUpPage().typePassword(PASSWORD);
        signUpPage().clickSignUpButton();

        homePage().clickLogInButtonInNavigationMenu();
//_____________________LogInTest___________________________________
        logInPage().typeLoginUsername(USERNAME);
        logInPage().typeLoginPassword(PASSWORD);
        logInPage().clickLoginButton();
//_____________________ProductSelectionTest________________________
        String productNameFromHomePage=homePage().getProducts().get(2).text();
        homePage().clickOnProductByName(productNameFromHomePage);
//_____________________AddToCartTest________________________________
        productPage().clickAddToCartButton();
        homePage().clickCartButtonInNavigationMenu();
        cartPage().clickPlaceOrderButton();
//_____________________CheckoutOrder________________________________
        orderPage().typeOrderNameInput(ORDER_NAME);
        orderPage().typeOrderCountryInput(ORDER_COUNTRY);
        orderPage().typeOrderCityInput(ORDER_CITY);
        orderPage().typeOrderCreditCardInput(ORDER_CREDITCARD);
        orderPage().typeOrderMonthInput(ORDER_MONTH);
        orderPage().typeOrderYearInput(ORDER_YEAR);
        orderPage().clickPurchaseButton();

        orderNotification().verifyCompleteHeaderVisiable("Thank you for your purchase!");
        orderNotification().clickConfirmButton();

        homePage().clickLogOutButtonInNavigationMenu();
    }
}
