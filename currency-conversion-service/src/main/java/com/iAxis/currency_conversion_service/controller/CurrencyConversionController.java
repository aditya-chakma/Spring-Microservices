package com.iAxis.currency_conversion_service.controller;

import com.iAxis.currency_conversion_service.dto.CurrencyConversionDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aditya.chakma
 * @since 16 Jan, 2025 2:30 PM
 */
@RestController
public class CurrencyConversionController {

    @GetMapping("/convert/{from}/{to}/{quantity}")
    public CurrencyConversionDto getCurrencyConversion(@PathVariable String from, @PathVariable String to, @PathVariable double quantity) {
        return new CurrencyConversionDto(10001, from, to, quantity);
    }

}
