package com.genaitestingforjava.service;

import org.springframework.stereotype.Service;

// A simple service class that performs basic arithmetic operations.
// This class is designed to be the target for unit test generation by AI tools.
// It includes various method signatures and a potential edge case (division by zero)
// to showcase how AI can generate diverse test scenarios.
@Service
public class CalculatorService {

    /**
     * Adds two integers.
     * @param a The first integer.
     * @param b The second integer.
     * @return The sum of a and b.
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * Subtracts the second integer from the first.
     * @param a The first integer.
     * @param b The second integer.
     * @return The result of a minus b.
     */
    public int subtract(int a, int b) {
        return a - b;
    }

    /**
     * Multiplies two integers.
     * @param a The first integer.
     * @param b The second integer.
     * @return The product of a and b.
     */
    public int multiply(int a, int b) {
        return a * b;
    }

    /**
     * Divides the first integer by the second.
     * Throws an IllegalArgumentException if the divisor is zero.
     * This method is a good candidate for AI tools to generate tests for the
     * exception case, ensuring robust error handling.
     * @param a The dividend.
     * @param b The divisor.
     * @return The result of a divided by b.
     * @throws IllegalArgumentException if the divisor (b) is zero.
     */
    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divisor cannot be zero.");
        }
        return (double) a / b; // Cast to double to ensure floating-point division
    }

    /**
     * Checks if a number is even.
     * @param number The integer to check.
     * @return True if the number is even, false otherwise.
     */
    public boolean isEven(int number) {
        return number % 2 == 0;
    }
}