package com.genaitestingforjava.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

// JUnit 5 tests for CalculatorService.
// These tests are manually written but represent the type of comprehensive,
// production-quality tests that AI-driven tools like Diffblue Cover aim to generate.
// An AI tool would analyze CalculatorService and automatically create these
// test methods, often exploring many more input combinations and edge cases.
class CalculatorServiceTest {

    private CalculatorService calculatorService;

    // This method runs before each test method.
    // An AI tool would understand the need to instantiate the service.
    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorService();
    }

    @Test
    @DisplayName("Should add two positive numbers correctly")
    void testAddPositiveNumbers() {
        // AI would identify int inputs and expect an int output.
        // It might generate various positive combinations.
        assertEquals(5, calculatorService.add(2, 3), "2 + 3 should equal 5");
    }

    @Test
    @DisplayName("Should add positive and negative number correctly")
    void testAddPositiveAndNegativeNumber() {
        // AI would often explore combinations with negative numbers.
        assertEquals(-1, calculatorService.add(2, -3), "2 + (-3) should equal -1");
    }

    @Test
    @DisplayName("Should subtract two numbers correctly")
    void testSubtractNumbers() {
        // AI would create tests for subtraction, including positive and negative results.
        assertEquals(1, calculatorService.subtract(3, 2), "3 - 2 should equal 1");
        assertEquals(-5, calculatorService.subtract(2, 7), "2 - 7 should equal -5");
    }

    @Test
    @DisplayName("Should multiply two numbers correctly")
    void testMultiplyNumbers() {
        // AI would generate tests for multiplication, handling zero and negative inputs.
        assertEquals(6, calculatorService.multiply(2, 3), "2 * 3 should equal 6");
        assertEquals(0, calculatorService.multiply(5, 0), "5 * 0 should equal 0");
        assertEquals(-10, calculatorService.multiply(2, -5), "2 * -5 should equal -10");
    }

    @Test
    @DisplayName("Should divide two numbers correctly")
    void testDivideNumbers() {
        // AI would identify double return type and generate tests for various divisions.
        assertEquals(2.5, calculatorService.divide(5, 2), 0.001, "5 / 2 should be 2.5");
        assertEquals(2.0, calculatorService.divide(4, 2), 0.001, "4 / 2 should be 2.0");
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when dividing by zero")
    void testDivideByZeroThrowsException() {
        // This is a critical edge case. AI testing tools are very good at identifying
        // and generating tests for exceptions and error conditions.
        assertThrows(IllegalArgumentException.class, () -> calculatorService.divide(10, 0),
                "Dividing by zero should throw IllegalArgumentException");
    }

    @ParameterizedTest
    @CsvSource({"2, true", "4, true", "0, true", "1, false", "3, false", "-2, true", "-3, false"})
    @DisplayName("Should correctly determine if a number is even using parameterized test")
    void testIsEven(int number, boolean expected) {
        // AI tools can also generate parameterized tests, covering a wide range of inputs
        // with a single test method, which is highly efficient.
        assertEquals(expected, calculatorService.isEven(number),
                "isEven(" + number + ") should return " + expected);
    }
}