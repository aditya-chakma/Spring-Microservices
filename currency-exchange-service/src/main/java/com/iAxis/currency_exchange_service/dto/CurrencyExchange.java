package com.iAxis.currency_exchange_service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iAxis.currency_exchange_service.entity.CurrencyRate;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author aditya.chakma
 * @since 16 Jan, 2025 10:20 AM
 */
public class CurrencyExchange {

    private Long id;

    @JsonIgnore
    private CurrencyRate from;

    @JsonIgnore
    private CurrencyRate to;

    private BigDecimal conversionMultiple;

    private String environment;

    public CurrencyExchange() {
    }

    public CurrencyExchange(Long id, CurrencyRate from, CurrencyRate to) {
        this.id = id;
        this.from = from;
        this.to = to;

        calculateConversionMultiple();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CurrencyRate getFrom() {
        return from;
    }

    public void setFrom(CurrencyRate from) {
        this.from = from;
    }

    public CurrencyRate getTo() {
        return to;
    }

    public void setTo(CurrencyRate to) {
        this.to = to;
    }

    @JsonProperty("from")
    public String getFromName() {
        return from.getCurrency().name();
    }

    @JsonProperty("to")
    public String getToName() {
        return to.getCurrency().name();
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    private void calculateConversionMultiple() {
        double fromRate = from.getRate();
        double toRate = to.getRate();

        double fromInUsd = 1.0 / fromRate;
        double toInUsd = 1.0 / toRate;

        conversionMultiple = BigDecimal.valueOf(fromInUsd / toInUsd);
        conversionMultiple = conversionMultiple.setScale(2, RoundingMode.HALF_UP);
    }

}
