package com.example.preprocess;

import com.example.processor.InputLineItem;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValueExtractor {
    private final Pattern pattern;

    public ValueExtractor() {
        this.pattern = Pattern.compile("([A-Z]{3}) (.+) (.+)");
    }

    public InputLineItem extract(String line) {
        Matcher matcher = pattern.matcher(line);
        if (matcher.matches()) {
            try {
                String currencyCode = matcher.group(1);
                int amount = Integer.parseInt(matcher.group(2));
                double exchangeRate = Double.parseDouble(matcher.group(3));
                if (exchangeRate > 0) {
                    return new InputLineItem(currencyCode, amount, exchangeRate);
                }
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return null;
    }
}
