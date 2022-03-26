package com.github.glo2003;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void whenEmptyString_thenReturnsZero() {
        int result = calculator.add("");

        assertEquals(0, result);
    }

    @Test
    void whenNonNumericValues_thenThrowInvalidInput() {
        assertThrows(InvalidNumberFormatException.class,
            () -> calculator.add("4,a"));
    }

    @Test
    void whenSingleNumber_thenReturnsNumber() {
        int result = calculator.add("1");

        assertEquals(1, result);
    }

    @Test
    void whenTwoNumbers_thenReturnsSum() {
        int result = calculator.add("1,2");

        assertEquals(3, result);
    }

    @Test
    void whenTrailingDelimiter_thenReturnsSum() {
        int result = calculator.add("1,2,");

        assertEquals(3, result);
    }

    @Test
    void whenDuplicateDelimiter_thenReturnsSum() {
        int result = calculator.add("1,,2");

        assertEquals(3, result);
    }

    @Test
    void whenMultipleNumbers_thenReturnsSum() {
        int result = calculator.add("1,2,3");

        assertEquals(6, result);
    }

    @Test
    void whenMultipleNumbersWithNewLine_thenReturnsSum() {
        int result = calculator.add("1\n2,3");

        assertEquals(6, result);
    }

    @Test
    void whenTrailingNewLine_thenReturnsSum() {
        int result = calculator.add("1,\n");

        assertEquals(1, result);
    }
}