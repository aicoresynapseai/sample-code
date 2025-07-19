package com.genai.devops.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This test class simulates the kind of comprehensive and intelligent JUnit tests
 * that an AI-driven test generation tool (like Diffblue Cover or a custom LLM-based tool)
 * might produce for the Calculator class.
 *
 * Notice the variety of test cases:
 * - Happy paths
 * - Edge cases (zero, negative numbers, large numbers)
 * - Error conditions (division by zero, overflow)
 * - Parameterized tests for broad coverage.
 *
 * An AI tool excels at identifying such diverse input combinations without explicit
 * human intervention.
 */
@DisplayName("Calculator Tests (AI-Generated Simulation)")
class CalculatorAIGeneratedTest {

    private Calculator calculator;

    /**
     * Setup method run before each test. An AI would also understand the need
     * to initialize dependencies or the class under test.
     */
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    // --- Add Method Tests ---

    @Test
    @DisplayName("Should add two positive numbers correctly")
    void add_PositiveNumbers_ReturnsCorrectSum() {
        assertEquals(5, calculator.add(2, 3), "2 + 3 should be 5");
    }

    @Test
    @DisplayName("Should add a positive and a negative number correctly")
    void add_PositiveAndNegative_ReturnsCorrectSum() {
        assertEquals(-1, calculator.add(2, -3), "2 + (-3) should be -1");
    }

    @Test
    @DisplayName("Should add two negative numbers correctly")
    void add_NegativeNumbers_ReturnsCorrectSum() {
        assertEquals(-5, calculator.add(-2, -3), "(-2) + (-3) should be -5");
    }

    @Test
    @DisplayName("Should add zero to a number correctly")
    void add_WithZero_ReturnsSameNumber() {
        assertEquals(7, calculator.add(7, 0), "7 + 0 should be 7");
        assertEquals(-10, calculator.add(0, -10), "0 + (-10) should be -10");
        assertEquals(0, calculator.add(0, 0), "0 + 0 should be 0");
    }

    @Test
    @DisplayName("Should handle large number addition without overflow (within int limits)")
    void add_LargeNumbers_ReturnsCorrectSum() {
        assertEquals(2147483647, calculator.add(1000000000, 1147483647), "Addition of large numbers");
        // An AI might also generate tests for intentional overflow, if the context allows
        // assertThrows(ArithmeticException.class, () -> calculator.add(Integer.MAX_VALUE, 1));
    }


    // --- Subtract Method Tests ---

    @Test
    @DisplayName("Should subtract two positive numbers correctly")
    void subtract_PositiveNumbers_ReturnsCorrectDifference() {
        assertEquals(1, calculator.subtract(3, 2), "3 - 2 should be 1");
        assertEquals(-1, calculator.subtract(2, 3), "2 - 3 should be -1");
    }

    @Test
    @DisplayName("Should subtract a negative number from a positive number")
    void subtract_PositiveMinusNegative_ReturnsCorrectDifference() {
        assertEquals(5, calculator.subtract(2, -3), "2 - (-3) should be 5");
    }

    @Test
    @DisplayName("Should subtract zero from a number")
    void subtract_WithZero_ReturnsSameNumber() {
        assertEquals(5, calculator.subtract(5, 0), "5 - 0 should be 5");
        assertEquals(-5, calculator.subtract(-5, 0), "(-5) - 0 should be -5");
        assertEquals(0, calculator.subtract(0, 0), "0 - 0 should be 0");
    }

    // --- Multiply Method Tests ---

    @Test
    @DisplayName("Should multiply two positive numbers correctly")
    void multiply_PositiveNumbers_ReturnsCorrectProduct() {
        assertEquals(6, calculator.multiply(2, 3), "2 * 3 should be 6");
    }

    @Test
    @DisplayName("Should multiply by zero correctly")
    void multiply_ByZero_ReturnsZero() {
        assertEquals(0, calculator.multiply(5, 0), "5 * 0 should be 0");
        assertEquals(0, calculator.multiply(0, 100), "0 * 100 should be 0");
        assertEquals(0, calculator.multiply(0, 0), "0 * 0 should be 0");
    }

    @Test
    @DisplayName("Should multiply positive and negative numbers correctly")
    void multiply_PositiveAndNegative_ReturnsCorrectProduct() {
        assertEquals(-6, calculator.multiply(2, -3), "2 * (-3) should be -6");
        assertEquals(-6, calculator.multiply(-2, 3), "(-2) * 3 should be -6");
    }

    @Test
    @DisplayName("Should multiply two negative numbers correctly")
    void multiply_NegativeNumbers_ReturnsPositiveProduct() {
        assertEquals(6, calculator.multiply(-2, -3), "(-2) * (-3) should be 6");
    }

    @Test
    @DisplayName("Should handle multiplication with one correctly")
    void multiply_ByOne_ReturnsSameNumber() {
        assertEquals(5, calculator.multiply(5, 1), "5 * 1 should be 5");
        assertEquals(-7, calculator.multiply(-7, 1), "(-7) * 1 should be -7");
    }

    @Test
    @DisplayName("Should handle multiplication with large numbers")
    void multiply_LargeNumbers_ReturnsCorrectProduct() {
        assertEquals(2000000000, calculator.multiply(100000, 20000), "100000 * 20000 should be 2000000000");
    }

    // --- Divide Method Tests ---

    @Test
    @DisplayName("Should divide two positive numbers correctly")
    void divide_PositiveNumbers_ReturnsCorrectQuotient() {
        assertEquals(2.5, calculator.divide(5, 2), 0.001, "5 / 2 should be 2.5");
        assertEquals(2.0, calculator.divide(4, 2), 0.001, "4 / 2 should be 2.0");
    }

    @Test
    @DisplayName("Should divide positive by negative number correctly")
    void divide_PositiveByNegative_ReturnsCorrectQuotient() {
        assertEquals(-2.5, calculator.divide(5, -2), 0.001, "5 / (-2) should be -2.5");
    }

    @Test
    @DisplayName("Should divide negative by positive number correctly")
    void divide_NegativeByPositive_ReturnsCorrectQuotient() {
        assertEquals(-2.5, calculator.divide(-5, 2), 0.001, "(-5) / 2 should be -2.5");
    }

    @Test
    @DisplayName("Should divide negative by negative number correctly")
    void divide_NegativeByNegative_ReturnsCorrectQuotient() {
        assertEquals(2.5, calculator.divide(-5, -2), 0.001, "(-5) / (-2) should be 2.5");
    }

    @Test
    @DisplayName("Should divide zero by a non-zero number")
    void divide_ZeroByNonZero_ReturnsZero() {
        assertEquals(0.0, calculator.divide(0, 5), 0.001, "0 / 5 should be 0.0");
        assertEquals(0.0, calculator.divide(0, -5), 0.001, "0 / (-5) should be 0.0");
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when dividing by zero")
    void divide_ByZero_ThrowsException() {
        // An AI testing tool would specifically look for these kinds of error conditions
        // and generate tests to ensure appropriate exceptions are thrown.
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () ->
                        calculator.divide(10, 0),
                "Division by zero should throw IllegalArgumentException"
        );
        assertEquals("Cannot divide by zero", thrown.getMessage());
    }

    // --- Power Method Tests ---
    // Parameterized tests are excellent for covering many input combinations,
    // a pattern AI can effectively leverage for comprehensive testing.

    @ParameterizedTest(name = "base={0}, exponent={1}, expected={2}")
    @CsvSource({
            "2, 3, 8",     // 2^3 = 8
            "5, 0, 1",     // 5^0 = 1
            "1, 10, 1",    // 1^10 = 1
            "0, 5, 0",     // 0^5 = 0
            "-2, 2, 4",    // (-2)^2 = 4
            "-2, 3, -8",   // (-2)^3 = -8
            "10, 1, 10",   // 10^1 = 10
            "0, 0, 1"      // 0^0 is commonly 1 in this context
    })
    @DisplayName("Should calculate power correctly for various valid inputs")
    void power_ValidInputs_ReturnsCorrectResult(int base, int exponent, long expected) {
        assertEquals(expected, calculator.power(base, exponent));
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException for 0 to negative power")
    void power_ZeroToNegativeExponent_ThrowsException() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () ->
                        calculator.power(0, -1),
                "0 to a negative power should throw IllegalArgumentException"
        );
        assertEquals("0 raised to a negative power is undefined.", thrown.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -5, -100})
    @DisplayName("Should throw IllegalArgumentException for negative exponents (not fully supported)")
    void power_NegativeExponent_ThrowsException(int exponent) {
        // This tests the explicit limitation of our sample 'power' method.
        // An AI tool would detect this unhandled scenario and generate a test for it.
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () ->
                        calculator.power(2, exponent),
                "Negative exponents should throw IllegalArgumentException based on current implementation"
        );
        assertEquals("Negative exponents not fully supported for integer power result in this example.", thrown.getMessage());
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException for power operation resulting in long overflow")
    void power_Overflow_ThrowsException() {
        // An AI's intelligence extends to finding input combinations that lead to overflows,
        // which are common sources of subtle bugs.
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () ->
                        calculator.power(Integer.MAX_VALUE, 2), // A value that will cause overflow when squared
                "Power operation resulting in overflow should throw IllegalArgumentException"
        );
        assertEquals("Result of power operation overflows long type.", thrown.getMessage());

        IllegalArgumentException thrown2 = assertThrows(IllegalArgumentException.class, () ->
                        calculator.power(2, 63), // 2^63 will overflow long
                "Power operation resulting in overflow should throw IllegalArgumentException"
        );
        assertEquals("Result of power operation overflows long type.", thrown2.getMessage());
    }
}