package com.iaxis.Spring.microsevices.products.v2.dto;

import java.io.Serial;

/**
 * @author aditya.chakma
 * @since 09 Jan, 2025 10:56 AM
 */
public class ProductDto extends com.iaxis.Spring.microsevices.products.v1.dto.ProductDto {

    @Serial
    private static final long serialVersionUID = 1L;

    private String productCode;

    public ProductDto(String name, Double price, String productCode) {
        super(name, price);
        this.productCode = productCode;
    }

    public String getProductCode() {
        return productCode;
    }
}
