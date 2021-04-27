package com.example.processor;

/**
 * Immutable
 */
public class InputLineItem {
    private final String currencyCode;
    private final int amount;
    private final double exchangeRate;

    public InputLineItem(String currencyCode, int amount, double exchangeRate) {
        this.currencyCode = currencyCode;
        this.amount = amount;
        this.exchangeRate = exchangeRate;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public int getAmount() {
        return amount;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }
}
