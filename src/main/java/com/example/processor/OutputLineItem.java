package com.example.processor;

public class OutputLineItem {
    private final InputLineItem inputLineItem;

    public OutputLineItem(InputLineItem inputLineItem) {
        this.inputLineItem = inputLineItem;
    }

    @Override
    public String toString() {
        return inputLineItem.getCurrencyCode() +
                " " + inputLineItem.getAmount() +
                " (USD " + inputLineItem.getAmount() / inputLineItem.getExchangeRate() + ")";
    }
}
