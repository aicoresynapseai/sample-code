package com.aijavadevops.app;

/**
 * A simple Calculator class to demonstrate various arithmetic operations
 * and provide examples for unit test generation.
 */
public class Calculator {

    /**
     * Adds two integers.
     * @param a The first integer.
     * @param b The second integer.
     * @return The sum of 'a' and 'b'.
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * Subtracts the second integer from the first.
     * @param a The first integer (minuend).
     * @param b The second integer (subtrahend).
     * @return The difference 'a - b'.
     */
    public int subtract(int a, int b) {
        return a - b;
    }

    /**
     * Multiplies two integers.
     * @param a The first integer.
     * @param b The second integer.
     * @return The product of 'a' and 'b'.
     */
    public int multiply(int a, int b) {
        return a * b;
    }

    /**
     * Divides the first integer by the second.
     * Throws an IllegalArgumentException if the divisor is zero.
     * @param a The dividend.
     * @param b The divisor.
     * @return The quotient 'a / b'.
     * @throws IllegalArgumentException if 'b' is 0.
     */
    public double divide(int a, int b) {
        if (b == 0) {
            // AI tools should identify this edge case and generate a test for it.
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
        return (double) a / b;
    }

    /**
     * Checks if a given number is even.
     * @param number The integer to check.
     * @return true if the number is even, false otherwise.
     */
    public boolean isEven(int number) {
        // AI tools can cover positive, negative, and zero inputs for this method.
        return number % 2 == 0;
    }

    /**
     * Calculates the factorial of a non-negative integer.
     * Throws an IllegalArgumentException for negative numbers.
     * @param n The number for which to calculate the factorial.
     * @return The factorial of 'n'.
     * @throws IllegalArgumentException if 'n' is negative.
     */
    public long factorial(int n) {
        if (n < 0) {
            // Another edge case for AI tools to test: negative input.
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        // AI tools might test large 'n' values that could lead to overflow for 'long'.
        return result;
    }
}