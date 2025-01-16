package com.iAxis.currency_exchange_service.enums;

/**
 * @author aditya.chakma
 * @since 16 Jan, 2025 10:20 AM
 */
public enum Currency {

    USD("United States Dollars"),
    INR("Indian Rupee"),
    BDT("Bangladeshi Taka");

    private final String name;

    Currency(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean is(Currency currency) {
        return this.equals(currency);
    }

}
