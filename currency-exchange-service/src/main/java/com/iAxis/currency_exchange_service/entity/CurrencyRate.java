package com.iAxis.currency_exchange_service.entity;

import com.iAxis.currency_exchange_service.enums.Currency;
import jakarta.persistence.*;

/**
 * @author aditya.chakma
 * @since 16 Jan, 2025 11:25 AM
 */
@Entity
@Table(name = "currency_rate")
public class CurrencyRate {

    @Id
    private int id;

    @Enumerated(value = EnumType.STRING)
    private Currency currency;

    private double rate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

}
