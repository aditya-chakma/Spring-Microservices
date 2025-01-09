package com.iaxis.Spring.microsevices.products.v2.controller;

import com.iaxis.Spring.microsevices.products.v2.dto.ProductDto;
import com.iaxis.Spring.microsevices.products.v2.service.ProductServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author aditya.chakma
 * @since 09 Jan, 2025 10:55 AM
 */
@RestController
@RequestMapping("/product")
public class ProductControllerV2 {

    private ProductServiceV2 productServiceV2;

    @Autowired
    public ProductControllerV2(ProductServiceV2 productServiceV2) {
        this.productServiceV2 = productServiceV2;
    }

    @GetMapping("/list")
    public List<ProductDto> getProductList() {
        return productServiceV2.getProductList();
    }

}
