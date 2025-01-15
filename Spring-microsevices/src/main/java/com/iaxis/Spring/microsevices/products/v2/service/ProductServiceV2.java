package com.iaxis.Spring.microsevices.products.v2.service;

import com.iaxis.Spring.microsevices.products.v2.dto.ProductDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aditya.chakma
 * @since 09 Jan, 2025 10:56 AM
 */
@Service
@Qualifier("productServiceV2")
public class ProductServiceV2 {

    private static final List<ProductDto> productListV2 = new ArrayList<>();

    static {
        productListV2.add(new ProductDto("Mango", 50.0, "M50"));
        productListV2.add(new ProductDto("Water", 20.0, "W20"));
        productListV2.add(new ProductDto("Tixol", 190.50, "T1905"));
    }

    public List<ProductDto> getProductList() {
        return productListV2;
    }

}
