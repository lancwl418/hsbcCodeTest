package com.example.preprocess;

import com.example.processor.InputLineItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValueExtractorTest {
    private ValueExtractor extractor;

    @BeforeEach
    void init() {
        extractor = new ValueExtractor();
    }

    @Test
    void should_return_null_when_input_invalid_amount() {
        // Given
        String line = "USD -98f 1";
        // When
        InputLineItem inputLineItem = extractor.extract(line);
        // Then
        assertNull(inputLineItem);
    }

    @Test
    void should_return_null_when_input_invalid_exchange_rate() {
        // Given
        String line = "USD -98f -1";
        // When
        InputLineItem inputLineItem = extractor.extract(line);
        // Then
        assertNull(inputLineItem);
    }

    @Test
    void should_return_correct_object_when_input_valid_line() {
        // Given
        String line = "CNY +621 6.48";
        // When
        InputLineItem inputLineItem = extractor.extract(line);
        // Then
        assertEquals("CNY", inputLineItem.getCurrencyCode());
        assertEquals(621, inputLineItem.getAmount());
        assertTrue(Math.abs(inputLineItem.getExchangeRate() - 6.48) < 0.000001);
    }
}