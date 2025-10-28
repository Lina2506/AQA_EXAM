package ui;

import org.base.config.BaseTests;
import org.base.pages.HomePage;
import org.base.pages.LogInPage;
import org.base.pages.SignUpPage;
import org.testng.annotations.Test;

import static org.base.helpers.Constants.*;

public class CriticalTest extends BaseTests {
    HomePage homePage=new HomePage();
    SignUpPage signUpPage=new SignUpPage();
    LogInPage logInPage=new LogInPage();

    @Test(description = "Verify user is able to buy item test")
    public void testBuyItem() {
        homePage.clickSignUpButtonInNavigationMenu();
        signUpPage.typeUsername(USERNAME);
        signUpPage.typePassword(PASSWORD);
        signUpPage.clickSignUpButton();

        homePage.clickLogInButtonInNavigationMenu();

        logInPage.typeLoginUsername(USERNAME);
        logInPage.typeLoginPassword(PASSWORD);
        logInPage.clickLoginButton();

    }
}
