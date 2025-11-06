package ui;

import com.codeborne.selenide.Selenide;
import org.base.config.BaseTests;
import org.base.models.Product;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.base.Pages.*;
import static org.base.helpers.Constants.*;

public class CriticalTests extends BaseTests {
    @Test(description = "Verify user is able to buy item test")
    public void testBuyItem() {
//____________________SignUp__________________________________
        homePage().clickSignUpButtonInNavigationMenu();
        signUpPage().typeUsername(USERNAME);
        signUpPage().typePassword(PASSWORD);
        signUpPage().clickSignUpButton();

        homePage().clickLogInButtonInNavigationMenu();
//_____________________LogIn___________________________________
        logInPage().typeLoginUsername(USERNAME);
        logInPage().typeLoginPassword(PASSWORD);
        logInPage().clickLoginButton();
//_____________________ProductSelectionTest________________________
        String productNameFromHomePage=homePage().getProducts().get(2).text();
        homePage().clickOnProductByName(productNameFromHomePage);
        Product selectedProduct= detailProductPage().getDetailProduct();
        Assert.assertEquals(selectedProduct.getName(),productNameFromHomePage);
//_____________________AddToCart________________________________
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

        Selenide.sleep(5000);

        orderNotification().verifyCompleteHeaderVisiable("Thank you for your purchase!");
        orderNotification().clickConfirmButton();

//_______________________LogOut_____________________________________
        homePage().clickLogOutButtonInNavigationMenu();
    }
}
