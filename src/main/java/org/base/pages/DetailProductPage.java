package org.base.pages;

import org.base.config.PageTools;
import org.base.models.Product;

public class DetailProductPage extends PageTools {
    private final String name="//h2[@class='name']";
    private final String price="//h3[@class='price-container']";
    private final String description="//div[@id='more-information']/p";

    public Product getDetailProduct() {
        Product product = new Product();

        product.setName(getText("xpath", name));
        product.setPrice(Integer.parseInt(getText("xpath",price).replace("$","").replaceAll("[^0-9]","").trim()));
        product.setDescription(getText("xpath", description));

        return product;
    }
}
