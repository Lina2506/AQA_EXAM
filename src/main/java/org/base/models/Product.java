package org.base.models;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@ToString
public class Product {
    private String name;
    private Integer price;
    private String description;

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name)&&Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
