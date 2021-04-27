package com.example.processor;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Processor {
    private final ConcurrentHashMap<String, InputLineItem> concurrentHashMap;

    public Processor() {
        this.concurrentHashMap = new ConcurrentHashMap<>();
    }

    public void putEntry(String key, InputLineItem newVal) {
        concurrentHashMap.compute(key, (k, oldVal) ->
                (oldVal == null) ? newVal : new InputLineItem(oldVal.getCurrencyCode(), oldVal.getAmount() + newVal.getAmount(), newVal.getExchangeRate()));
    }

    public Map<String, InputLineItem> getAllRecords() {
        return Collections.unmodifiableMap(concurrentHashMap);
    }
}
