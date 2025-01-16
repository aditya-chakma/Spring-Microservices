package com.iAxis.currency_conversion_service.controller;

import com.iAxis.currency_conversion_service.dto.CurrencyConversionDto;
import com.iAxis.currency_conversion_service.proxy.CurrencyExchangeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author aditya.chakma
 * @since 16 Jan, 2025 2:30 PM
 */
@RestController
public class CurrencyConversionController {

    private final Environment environment;

    private final CurrencyExchangeProxy currencyExchangeProxy;

    @Autowired
    public CurrencyConversionController(Environment environment, CurrencyExchangeProxy currencyExchangeProxy) {
        this.environment = environment;
        this.currencyExchangeProxy = currencyExchangeProxy;
    }

    @GetMapping("/convert/{from}/{to}/{quantity}")
    public CurrencyConversionDto getCurrencyConversion(@PathVariable String from, @PathVariable String to, @PathVariable double quantity) {
        Map<String, String> parameters = new HashMap<>();

        parameters.put("from", from);
        parameters.put("to", to);

        RestTemplate restTemplate = new RestTemplate();
        CurrencyConversionDto currencyConversionDto = restTemplate.getForObject("http://localhost:8000/currency-exchange/rate/{from}/{to}",
                CurrencyConversionDto.class, parameters);

        if (currencyConversionDto == null) {
            return null;
        }

        String port = "cc:%s, ce:%s".formatted(environment.getProperty("local.server.port"), currencyConversionDto.getEnvironment());

        currencyConversionDto.setQuantity(quantity);
        currencyConversionDto.calculateConvertedAmount();
        currencyConversionDto.setEnvironment(port);

        return currencyConversionDto;
    }

    @GetMapping("/convert/feign/{from}/{to}/{quantity}")
    public CurrencyConversionDto getFeignCurrencyConversion(@PathVariable String from, @PathVariable String to, @PathVariable double quantity) {
        CurrencyConversionDto currencyConversionDto = currencyExchangeProxy.getCurrencyExchange(from, to);

        String port = "cc:%s, ce:%s - feign".formatted(environment.getProperty("local.server.port"), currencyConversionDto.getEnvironment());

        currencyConversionDto.setEnvironment(port);
        currencyConversionDto.setQuantity(quantity);
        currencyConversionDto.calculateConvertedAmount();

        return currencyConversionDto;
    }

}
