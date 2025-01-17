package com.iAxis.currency_conversion_service.proxy;

import com.iAxis.currency_conversion_service.dto.CurrencyConversionDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author aditya.chakma
 * @since 16 Jan, 2025 4:17 PM
 */
@FeignClient(value = "currency-exchange", path = "/currency-exchange")
public interface CurrencyExchangeProxy {

    @GetMapping("/rate/{from}/{to}")
    CurrencyConversionDto getCurrencyExchange(@PathVariable String from, @PathVariable String to);
}
