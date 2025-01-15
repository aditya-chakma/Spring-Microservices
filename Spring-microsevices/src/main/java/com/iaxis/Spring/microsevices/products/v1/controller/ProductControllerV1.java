package com.iaxis.Spring.microsevices.products.v1.controller;

import com.iaxis.Spring.microsevices.products.v1.dto.ProductDto;
import com.iaxis.Spring.microsevices.products.v1.service.ProductServiceV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author aditya.chakma
 * @since 09 Jan, 2025 10:50 AM
 */
@RestController
@RequestMapping("/v1/product")
public class ProductControllerV1 {

    private ProductServiceV1 productServiceV1;

    @Autowired
    public ProductControllerV1(ProductServiceV1 productServiceV1) {
        this.productServiceV1 = productServiceV1;
    }

    @GetMapping("/list")
    public List<ProductDto> productDtoList() {
        return productServiceV1.getProducts();
    }

}
