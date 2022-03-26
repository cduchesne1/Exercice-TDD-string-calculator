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
}