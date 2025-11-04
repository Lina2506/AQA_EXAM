package ui;

import com.codeborne.selenide.Selenide;
import org.base.config.BaseTests;
import org.base.models.Product;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static org.base.Pages.*;

public class ExtendedTests extends BaseTests {
    @Test
    public void extendedTest() {
//_________________NavigationMenuTest__________________________
        homePage().clickContactButtonInNavigationMenu();
        Selenide.sleep(2000);
        contactWindow().clickCloseButtonInContactWindow();
        homePage().clickAboutUsButtonInNavigationMenu();
        Selenide.sleep(2000);
        aboutUsWindow().clickCloseButtonInAboutUsWindow();
//_________________SwitchBetweenCategories________________________
        List<String> expectedCategories = List.of("Phones", "Laptops", "Monitors");
        List<String> actualCategories = homePage().getCategoryNames();
        Assert.assertEquals(actualCategories, expectedCategories);
//_________________AddToCartFewProductsAndVerifyDetailsTest____________________
        List<Product> productList = homePage().getProductList();
        homePage().clickOnProductByName("Samsung galaxy s6");
        Product detailedProduct = detailProductPage().getDetailProduct();

        Assert.assertTrue(productList.contains(detailedProduct), "List " + productList + " doesn't contain " + detailedProduct);

        productPage().clickAddToCartButton();
        homePage().clickHomeButtonInNavigationMenu();

        homePage().clickOnProductByName("Nexus 6");

        Assert.assertTrue(productList.contains(detailedProduct), "List " + productList + " doesn't contain " + detailedProduct);

        productPage().clickAddToCartButton();

        homePage().clickCartButtonInNavigationMenu();
//______________________CheckTotalSumTest______________________

//______________________DeleteOneProductTest____________________


    }
}
