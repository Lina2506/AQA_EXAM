package ui;

import com.codeborne.selenide.CollectionCondition;
import org.base.config.BaseTests;
import org.base.helpers.AlertDialogs;
import org.base.models.Product;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import static org.base.Pages.*;

public class ExtendedTests extends BaseTests {

    private Product firstProduct;
    private Product secondProduct;

    @Test(groups = "extended", priority = 1, description = "Verify that contact window opens and displays correct title")
    public void testContactWindowOpen() {

        homePage().clickContactButtonInNavigationMenu();

        Assert.assertEquals(contactWindow().getContactWindowTitle(), "New message", "Contact window title is correct");
        contactWindow().clickCloseButtonInContactWindow();
    }
    @Test(groups = "extended", priority = 2, description = "Verify that 'About us' window can be opened and closed")
    public void testAboutUsWindow() {

            homePage().clickAboutUsButtonInNavigationMenu();
            aboutUsWindow().clickCloseButtonInAboutUsWindow();
        }
    @Test(groups = "extended", priority = 3, description = "Verify that all expected categories are displayed")
    public void testCategoryValidation() {

            List<String> expectedCategories = List.of("Phones", "Laptops", "Monitors");
            List<String> actualCategories = homePage().getCategoryNames();
            Assert.assertEquals(actualCategories.size(), 3, "Categories count should be 3");
            Assert.assertEquals(actualCategories, expectedCategories, "Categories matched");
        }
    @Test(groups = {"extended", "stateful"}, priority = 4, description = "Verify that user can add a few products to cart")
    public void testAddFewProductsToCart() {
        homePage().getProducts().shouldHave(CollectionCondition.size(9));
        List<Product> allProducts = homePage().getProductList();
        Assert.assertEquals(allProducts.size(), 9, "Expected 9 products on Home page");

        homePage().clickOnProductByName("Samsung galaxy s6");
        firstProduct = detailProductPage().getDetailProduct();
        Assert.assertTrue(allProducts.contains(firstProduct), "List" + allProducts + " doesn't contain " + firstProduct);
        productPage().clickAddToCartButton();
        Assert.assertEquals(AlertDialogs.getAlertText(), "Product added", "Alert text is correct");
        AlertDialogs.acceptAlert();

        homePage().clickHomeButtonInNavigationMenu();

        homePage().clickOnProductByName("Nexus 6");
        secondProduct = detailProductPage().getDetailProduct();
        Assert.assertTrue(allProducts.contains(secondProduct), "List" + allProducts + " doesn't contain " + secondProduct);
        productPage().clickAddToCartButton();

        Assert.assertEquals(AlertDialogs.getAlertText(), "Product added", "Alert text is correct");
        AlertDialogs.acceptAlert();

        homePage().clickCartButtonInNavigationMenu();

        cartPage().getProductNames().shouldBe(CollectionCondition.sizeGreaterThan(0), Duration.ofSeconds(10));
        List<String> cartProductNames=cartPage().getProductNames().texts();
        Assert.assertTrue(cartProductNames.contains(firstProduct.getName()), "Cart should contain " + firstProduct.getName());
        Assert.assertTrue(cartProductNames.contains(secondProduct.getName()), "Cart should contain " + secondProduct.getName());
    }
    @Test(groups = {"extended", "stateful"}, priority = 5, dependsOnMethods = {"testAddFewProductsToCart"}, description = "Verify that total sum in cart is calculated correctly")
            public void testTotalSumInCart() {
        homePage().clickCartButtonInNavigationMenu();
        int expectedSum = firstProduct.getPrice() + secondProduct.getPrice();
        int actualSum = cartPage().getTotalPrice();
        Assert.assertEquals(actualSum, expectedSum, "Total sum in cart is incorrect");
    }

    @Test(groups = {"extended", "stateful"}, priority = 6, dependsOnMethods = {"testTotalSumInCart"},description = "Verify that product can be deleted from cart and total sum recalculated")
            public void testDeleteProductFromCart() {
    homePage().clickCartButtonInNavigationMenu();
    cartPage().deleteProductByName(firstProduct.getName());

        int remainingTotal=cartPage().getTotalPrice();
        Assert.assertEquals(remainingTotal, secondProduct.getPrice(), "Total sum in cart is incorrect");
//___________________ReturnHomePage____________________________
        homePage().clickHomeButtonInNavigationMenu();
    }
}
