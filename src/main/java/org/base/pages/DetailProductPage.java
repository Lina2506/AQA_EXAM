package org.base.pages;

import com.codeborne.selenide.Condition;
import org.base.config.PageTools;
import org.base.models.Product;

public class DetailProductPage extends PageTools {
    private final String name="//h2[@class='name']";
    private final String price="//h3[@class='price-container']";
    private final String description="//div[@id='more-information']/p";

    public Product getDetailProduct() {
        Product product = new Product();

        getElement("xpath", name).shouldBe(Condition.visible);
        getElement("xpath", price).shouldBe(Condition.visible);

        String nameText=getText("xpath", name);
        String priceText=getText("xpath", price).replace("$","").replaceAll("[^0-9]","").trim();
        String descriptionText=getText("xpath", description);

        product.setName(nameText);
        product.setPrice(Integer.parseInt(priceText));
        product.setDescription(descriptionText);

        return product;
    }
}
