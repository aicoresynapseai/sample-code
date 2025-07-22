package com.aijavadevops.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test; // Import for @Test annotation
import static org.junit.jupiter.api.Assertions.*; // Static imports for assertion methods

/**
 * Manually written JUnit 5 tests for the Calculator class.
 * These represent the baseline tests that developers would typically write.
 * AI testing tools aim to augment or replace the effort for such boilerplate tests.
 */
class CalculatorTest {

    private final Calculator calculator = new Calculator(); // Instance of the class under test

    @Test // Marks a method as a test method
    @DisplayName("Test add method with positive numbers") // Provides a custom display name for the test
    void testAddPositive() {
        // Assert that 2 + 3 equals 5
        assertEquals(5, calculator.add(2, 3), "Adding two positive numbers should yield correct sum.");
    }

    @Test
    @DisplayName("Test add method with negative numbers")
    void testAddNegative() {
        // Assert that -2 + -3 equals -5
        assertEquals(-5, calculator.add(-2, -3), "Adding two negative numbers should yield correct sum.");
    }

    @Test
    @DisplayName("Test add method with mixed positive and negative numbers")
    void testAddMixed() {
        // Assert that 5 + (-3) equals 2
        assertEquals(2, calculator.add(5, -3), "Adding mixed positive and negative numbers should yield correct sum.");
    }

    @Test
    @DisplayName("Test subtract method")
    void testSubtract() {
        // Test basic subtraction
        assertEquals(1, calculator.subtract(3, 2), "3 - 2 should be 1.");
        assertEquals(-1, calculator.subtract(2, 3), "2 - 3 should be -1.");
        assertEquals(0, calculator.subtract(5, 5), "5 - 5 should be 0.");
    }

    @Test
    @DisplayName("Test multiply method")
    void testMultiply() {
        // Test various multiplication scenarios
        assertEquals(6, calculator.multiply(2, 3), "2 * 3 should be 6.");
        assertEquals(0, calculator.multiply(5, 0), "Any number multiplied by 0 should be 0.");
        assertEquals(-6, calculator.multiply(2, -3), "2 * -3 should be -6.");
        assertEquals(6, calculator.multiply(-2, -3), "-2 * -3 should be 6.");
    }

    @Test
    @DisplayName("Test divide method with valid inputs")
    void testDivide() {
        // Test division with expected precision
        assertEquals(2.0, calculator.divide(4, 2), 0.001, "4 / 2 should be 2.0.");
        assertEquals(1.5, calculator.divide(3, 2), 0.001, "3 / 2 should be 1.5.");
        assertEquals(-2.5, calculator.divide(-5, 2), 0.001, "-5 / 2 should be -2.5.");
    }

    @Test
    @DisplayName("Test divide method with division by zero")
    void testDivideByZero() {
        // Verify that an IllegalArgumentException is thrown when dividing by zero
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(10, 0),
                "Dividing by zero should throw IllegalArgumentException.");
    }

    @Test
    @DisplayName("Test isEven method")
    void testIsEven() {
        // Test various even and odd numbers
        assertTrue(calculator.isEven(2), "2 should be even.");
        assertFalse(calculator.isEven(3), "3 should be odd.");
        assertTrue(calculator.isEven(0), "0 should be even.");
        assertTrue(calculator.isEven(-4), "-4 should be even.");
        assertFalse(calculator.isEven(-5), "-5 should be odd.");
    }

    @Test
    @DisplayName("Test factorial with non-negative numbers")
    void testFactorialPositive() {
        // Test factorial for 0, 1, and positive integers
        assertEquals(1, calculator.factorial(0), "Factorial of 0 should be 1.");
        assertEquals(1, calculator.factorial(1), "Factorial of 1 should be 1.");
        assertEquals(2, calculator.factorial(2), "Factorial of 2 should be 2.");
        assertEquals(6, calculator.factorial(3), "Factorial of 3 should be 6.");
        assertEquals(120, calculator.factorial(5), "Factorial of 5 should be 120.");
    }

    @Test
    @DisplayName("Test factorial with negative number")
    void testFactorialNegative() {
        // Verify that an IllegalArgumentException is thrown for negative input
        assertThrows(IllegalArgumentException.class, () -> calculator.factorial(-1),
                "Factorial of a negative number should throw IllegalArgumentException.");
    }
}