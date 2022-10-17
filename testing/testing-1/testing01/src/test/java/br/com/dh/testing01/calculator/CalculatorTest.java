package br.com.dh.testing01.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Sum test")
    public void sum_returnsDouble_whenValidInput() {
        // Setup
        double n1 = 10;
        double n2 = 20;
        double expected = 30;

        // Act
        double result = calculator.sum(n1, n2);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void divide_returnsDouble_whenTwoPositiveNumbers() {
        // Setup
        double n1 = 30;
        double n2 = 3;
        double expected = 10;

        // Act
        double result = calculator.divide(n1, n2);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void divide_returnsZero_whenDivideByZero() {
        // Setup
        double n1 = 30;
        double n2 = 0;
        double expected = 0;

        // Act
        double result = calculator.divide(n1, n2);

        // Assert
        assertEquals(expected, result);
    }
}
