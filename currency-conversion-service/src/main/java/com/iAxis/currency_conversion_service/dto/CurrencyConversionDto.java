package com.iAxis.currency_conversion_service.dto;

import java.math.BigDecimal;

/**
 * @author aditya.chakma
 * @since 16 Jan, 2025 2:26 PM
 */
public class CurrencyConversionDto {

    private int id;

    private String from;

    private String to;

    private double quantity;

    private BigDecimal convertedAmount;

    public CurrencyConversionDto(int id, String from, String to, double quantity) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(BigDecimal convertedAmount) {
        this.convertedAmount = convertedAmount;
    }

}