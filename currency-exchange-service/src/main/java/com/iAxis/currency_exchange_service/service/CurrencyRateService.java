package com.iAxis.currency_exchange_service.service;

import com.iAxis.currency_exchange_service.entity.CurrencyRate;
import com.iAxis.currency_exchange_service.enums.Currency;
import com.iAxis.currency_exchange_service.repository.CurrencyRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author aditya.chakma
 * @since 16 Jan, 2025 11:28 AM
 */
@Service
public class CurrencyRateService {

    private final CurrencyRateRepository currencyRateRepository;

    @Autowired
    public CurrencyRateService(CurrencyRateRepository currencyRateRepository) {
        this.currencyRateRepository = currencyRateRepository;
    }

    public CurrencyRate getCurrencyRate(Currency currency) {
        return currencyRateRepository.findByCurrency(currency);
    }

}
