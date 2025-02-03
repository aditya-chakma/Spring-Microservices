package com.iAxis.currency_exchange_service.repository;

import com.iAxis.currency_exchange_service.entity.CurrencyRate;
import com.iAxis.currency_exchange_service.enums.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author aditya.chakma
 * @since 16 Jan, 2025 11:27 AM
 */
public interface CurrencyRateRepository extends JpaRepository<CurrencyRate, Integer> {

    @Query("FROM CurrencyRate WHERE currency = :curr")
    CurrencyRate findByCurrency(Currency curr);

}
