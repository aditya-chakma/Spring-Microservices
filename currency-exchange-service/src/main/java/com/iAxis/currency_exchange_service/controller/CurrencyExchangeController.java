package com.iAxis.currency_exchange_service.controller;

import com.iAxis.currency_exchange_service.dto.CurrencyExchange;
import com.iAxis.currency_exchange_service.entity.CurrencyRate;
import com.iAxis.currency_exchange_service.enums.Currency;
import com.iAxis.currency_exchange_service.service.CurrencyRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aditya.chakma
 * @since 16 Jan, 2025 10:18 AM
 */
@RestController
public class CurrencyExchangeController {

    private final Environment environment;

    private final CurrencyRateService currencyRateService;

    @Autowired
    public CurrencyExchangeController(Environment environment, CurrencyRateService currencyRateService) {
        this.environment = environment;
        this.currencyRateService = currencyRateService;
    }

    @GetMapping("/rate/{from}/{to}")
    public CurrencyExchange getCurrencyExchange(@PathVariable Currency from, @PathVariable Currency to) {
        CurrencyRate fromCurrencyRate = currencyRateService.getCurrencyRate(from);
        CurrencyRate toCurrencyRate = currencyRateService.getCurrencyRate(to);

        CurrencyExchange currencyExchange = new CurrencyExchange(10001L, fromCurrencyRate, toCurrencyRate);

        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);

        return currencyExchange;
    }

}
