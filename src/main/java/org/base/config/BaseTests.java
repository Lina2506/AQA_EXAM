package org.base.config;

import com.codeborne.selenide.*;
import org.testng.annotations.*;

import static org.base.helpers.Constants.BASE_URL;

public class BaseTests {
    @BeforeTest
    public void config() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1024x768";
        Configuration.holdBrowserOpen = true;
        Configuration.headless = false;
        Configuration.timeout = 10000;
        Configuration.savePageSource = false;
        Configuration.screenshots = true;
    }
    @BeforeSuite
    public void createUserBeforeSuite() {

    }
    @AfterSuite
    public void deleteUserAfterSuite() {

    }
    @BeforeMethod
    public void openMainPage() {
        Selenide.open(BASE_URL);
    }
    @AfterMethod
    public void clearWebDriver() {
//        Selenide.clearBrowserCookies();
    }

    @AfterTest
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
