package com.genai.devops.calculator;

/**
 * A simple utility class to perform basic arithmetic operations.
 * This class serves as our "application code" that AI-driven testing tools
 * or intelligent test generation logic would target.
 */
public class Calculator {

    /**
     * Adds two numbers.
     * @param a The first number.
     * @param b The second number.
     * @return The sum of a and b.
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * Subtracts the second number from the first.
     * @param a The first number (minuend).
     * @param b The second number (subtrahend).
     * @return The difference between a and b.
     */
    public int subtract(int a, int b) {
        return a - b;
    }

    /**
     * Multiplies two numbers.
     * @param a The first number.
     * @param b The second number.
     * @return The product of a and b.
     */
    public int multiply(int a, int b) {
        return a * b;
    }

    /**
     * Divides the first number by the second.
     * @param a The dividend.
     * @param b The divisor.
     * @return The result of the division.
     * @throws IllegalArgumentException if the divisor (b) is zero.
     */
    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return (double) a / b;
    }

    /**
     * Calculates the power of a number.
     * @param base The base number.
     * @param exponent The exponent.
     * @return The result of base raised to the power of exponent.
     * @throws IllegalArgumentException if base is 0 and exponent is negative, or if the result overflows.
     */
    public long power(int base, int exponent) {
        if (exponent < 0) {
            if (base == 0) {
                throw new IllegalArgumentException("0 raised to a negative power is undefined.");
            }
            // For negative exponents, it's 1 / (base ^ |exponent|).
            // This method returns long, so we simplify for integer power and might not handle fractions.
            // A real AI test might catch this nuance or suggest floating point.
            throw new IllegalArgumentException("Negative exponents not fully supported for integer power result in this example.");
        }
        if (exponent == 0) {
            return 1; // Any non-zero number to the power of 0 is 1. 0^0 is typically 1 in contexts like this.
        }
        long result = 1;
        for (int i = 0; i < exponent; i++) {
            // Check for overflow before multiplication
            if (Long.MAX_VALUE / Math.abs(base) < Math.abs(result)) {
                throw new IllegalArgumentException("Result of power operation overflows long type.");
            }
            result *= base;
        }
        return result;
    }
}