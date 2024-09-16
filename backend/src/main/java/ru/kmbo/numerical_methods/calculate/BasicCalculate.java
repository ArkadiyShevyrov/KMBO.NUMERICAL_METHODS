package ru.kmbo.numerical_methods.calculate;

import lombok.experimental.UtilityClass;

@UtilityClass
public class BasicCalculate {

    public double pow(double base, double exp) {
        return fastPow(base, (int) exp);
    }

    public double pow(double base, int exp) {
        return fastPow(base, exp);
    }

    public double fastPow(double base, int exp) {
        if (exp < 0) {
            return 1 / fastPow(base, -exp);
        }
        if (exp == 0) {
            return 1;
        }
        if (exp % 2 == 0) {
            return fastPow(base * base, exp / 2);
        } else {
            return base * fastPow(base * base, (exp - 1) / 2);
        }
    }

    public double factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Факториал не определен для отрицательных чисел.");
        }
        double result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
