package org.base.config;

import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.testng.TextReport;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.ITestResult;
import org.testng.annotations.*;

import static org.base.helpers.Constants.*;

@Listeners(TextReport.class)
public class BaseTests {
    @BeforeTest
    public void config() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1024x768";
        Configuration.holdBrowserOpen = false;
        Configuration.headless = false;
        Configuration.timeout = 10000;
        Configuration.savePageSource = false;
        Configuration.screenshots = true;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false)
                .includeSelenideSteps(true)
        );
    }
    @BeforeMethod
    public void openMainPage(){
        Selenide.open(BASE_URL);
    }
    //реєстрація юзера
    @AfterMethod
    public void clearWebDriver(ITestResult result) {

        String[] groups=result.getMethod().getGroups();
        for(String group : groups){
            if ("stateful".equals(group)){
                return;
            }
        }

      Selenide.clearBrowserCookies();
      Selenide.clearBrowserLocalStorage();
      Selenide.refresh();
    }

    @AfterTest
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
