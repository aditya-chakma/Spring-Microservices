package com.iaxis.Spring.microsevices.products.v1.dto;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author aditya.chakma
 * @since 09 Jan, 2025 10:48 AM
 */
public class ProductDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String name;

    private Double price;

    public ProductDto(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

}
