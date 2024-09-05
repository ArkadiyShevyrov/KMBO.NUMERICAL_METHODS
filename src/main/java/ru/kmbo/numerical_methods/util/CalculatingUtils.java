package ru.kmbo.numerical_methods.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class CalculatingUtils {

    public static final double PRECISION = 1e-10;

    public double calculateSin(double x) {
        return calculateSin(x, PRECISION);
    }

    public double calculateCos(double x) {
        return calculateCos(x, PRECISION);
    }

    public double calculateExp(double x) {
        return calculateExp(x, PRECISION);
    }

    public double calculateLg(double x) {
        return calculateLg(x, PRECISION);
    }

    public double calculateLog(double base, double x) {
        return calculateLog(base, x, PRECISION);
    }

    public double calculateLn(double x) {
        return calculateLn(x, PRECISION);
    }

    public double calculateSin(double x, double precision) {
        if (precision == 0) {
            throw new IllegalArgumentException("Точность 0 делает вычисление sin недостоверным. Для корректного результата выберите ненулевую точность.");
        }
        double result = 0;
        for (int n = 0; ; n++) {
            double term =
                    (Math.pow(-1, n) * Math.pow(x, 2 * n + 1)) /
                            factorial(2 * n + 1);
            result += term;
            if (Math.abs(term) < precision) {
                break;
            }
        }
        return RoundUtils.roundToPrecision(result, precision);
    }

    public double calculateCos(double x, double precision) {
        if (precision == 0) {
            throw new IllegalArgumentException("Точность 0 делает вычисление cos недостоверным. Для корректного результата выберите ненулевую точность.");
        }
        double result = 0;
        for (int n = 0; ; n++) {
            double term =
                    (Math.pow(-1, n) * Math.pow(x, 2 * n)) /
                            factorial(2 * n);
            result += term;
            if (Math.abs(term) < precision) {
                break;
            }
        }
        return RoundUtils.roundToPrecision(result, precision);
    }

    public double calculateExp(double x, double precision) {
        if (precision == 0) {
            throw new IllegalArgumentException("Точность 0 делает вычисление exp недостоверным. Для корректного результата выберите ненулевую точность.");
        }
        double result = 0;
        for (int n = 0; ; n++) {
            double term =
                    Math.pow(x, n) /
                            factorial(n);
            result += term;
            if (Math.abs(term) < precision) {
                break;
            }
        }
        return RoundUtils.roundToPrecision(result, precision);
    }

    public double calculateLg(double x, double precision) {
        return calculateLog(10, x, precision);
    }

    public double calculateLog(double base, double x, double precision) {
        double v = calculateLn(x, precision);
        double v1 = calculateLn(base, precision);
        double result = v /
                v1;
        return RoundUtils.roundToPrecision(result, precision*10);
    }

    public double calculateLn(double x, double precision) {
        if (x <= 0) {
            throw new IllegalArgumentException("x должен быть больше 0 для вычисления логарифма.");
        }
        if (precision == 0) {
            throw new IllegalArgumentException("Точность 0 делает вычисление Ln недостоверным. Для корректного результата выберите ненулевую точность.");
        }
        double result = 0;
        if (x <= 1) {
            for (int n = 0; ; n++) {
                double term =
                        (Math.pow(-1, n) * Math.pow(x - 1, n + 1)) /
                                (n + 1);
                result += term;
                if (Math.abs(term) < precision) {
                    break;
                }
            }
        } else {
            int alpha = 0;
            double tempX = x;
            int constNum = 2;
            while (tempX >= 1) {
                tempX /= constNum;
                alpha++;
            }
            result = calculateLn(tempX, precision) + alpha * Math.log(constNum);
        }
        return RoundUtils.roundToPrecision(result, precision);
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
