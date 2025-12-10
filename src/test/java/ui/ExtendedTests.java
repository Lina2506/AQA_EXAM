package ui;

import com.codeborne.selenide.Selenide;
import org.base.config.BaseTests;
import org.base.helpers.AlertDialogs;
import org.base.models.Product;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.base.Pages.*;

public class ExtendedTests extends BaseTests {
    @Test(description = "Verify that the user can navigate through the website and successfully perform cart operations")
    public void extendedTest() {
//_________________NavigationMenu__________________________
        homePage().clickContactButtonInNavigationMenu();
        Selenide.sleep(2000);

        Assert.assertEquals(contactWindow().getContactWindowTitle(),"New message");
        contactWindow().clickCloseButtonInContactWindow();

        homePage().clickAboutUsButtonInNavigationMenu();
        Selenide.sleep(2000);
        aboutUsWindow().clickCloseButtonInAboutUsWindow();
//_________________CategoryValidation________________________
        List<String> expectedCategories = List.of("Phones", "Laptops", "Monitors");
        Assert.assertEquals(homePage().getCategoryNames(), expectedCategories);
//_________________AddTwoProductsToCart____________________
        List<Product>allProducts = homePage().getProductList();

        homePage().clickOnProductByName("Samsung galaxy s6");
        Product firstProduct = detailProductPage().getDetailProduct();
        Assert.assertTrue(allProducts.contains(firstProduct), "List"+ allProducts + " doesn't contain " + firstProduct);
        productPage().clickAddToCartButton();
        Assert.assertEquals(AlertDialogs.getAlertText(),"Product added");

        homePage().clickHomeButtonInNavigationMenu();

        homePage().clickOnProductByName("Nexus 6");
        Product secondProduct = detailProductPage().getDetailProduct();
        Assert.assertTrue(allProducts.contains(secondProduct), "List"+ allProducts + " doesn't contain " + secondProduct);
        productPage().clickAddToCartButton();
        Assert.assertEquals(AlertDialogs.getAlertText(),"Product added");

        homePage().clickCartButtonInNavigationMenu();
//______________________CheckTotalSum______________________
        int expectedSum=firstProduct.getPrice()+secondProduct.getPrice();
        int actualSum= cartPage().getTotalPrice();
        Assert.assertEquals(actualSum, expectedSum, "Total sum in cart is incorrect");
//______________________DeleteOneProduct____________________
        cartPage().deleteProductByName(firstProduct.getName());
        Selenide.sleep(2000);
        int remainingTotal=cartPage().getTotalPrice();
        Assert.assertEquals(remainingTotal, secondProduct.getPrice(), "Total sum in cart is incorrect");
//___________________ReturnHomePage____________________________
        homePage().clickHomeButtonInNavigationMenu();
    }
}
