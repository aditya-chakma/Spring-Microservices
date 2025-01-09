package com.iaxis.Spring.microsevices.products.v1.service;

import com.iaxis.Spring.microsevices.products.v1.dto.ProductDto;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aditya.chakma
 * @since 09 Jan, 2025 10:50 AM
 */
@Service
@Primary
public class ProductServiceV1 {

    private static final List<ProductDto> products = new ArrayList<>();

    static {
        products.add(new ProductDto("Mango", 50.00));
        products.add(new ProductDto("Water", 20.00));
        products.add(new ProductDto("Tixol", 190.50));
    }

    public List<ProductDto> getProducts() {
        return products;
    }

}
