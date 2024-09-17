package ru.kmbo.numerical_methods.calculate;

import lombok.experimental.UtilityClass;
import ru.kmbo.numerical_methods.util.RoundUtils;


@UtilityClass
public class TaylorCalculate {

    public static final double PRECISION = 1e-10;

    public double sin(double x) {
        return sin(x, PRECISION);
    }

    public double cos(double x) {
        return cos(x, PRECISION);
    }

    public double exp(double x) {
        return exp(x, PRECISION);
    }

    public double lg(double x) {
        return lg(x, PRECISION);
    }

    public double log(double base, double x) {
        return log(base, x, PRECISION);
    }

    public double ln(double x) {
        return ln(x, PRECISION);
    }

    public double sin(double x, double precision) {
        if (precision == 0) {
            throw new IllegalArgumentException("Точность 0 делает вычисление sin недостоверным. Для корректного результата выберите ненулевую точность.");
        }
        double result = 0;
        for (int n = 0; ; n++) {
            double term =
                    (BasicCalculate.pow(-1, n) * BasicCalculate.pow(x, 2 * n + 1)) /
                            BasicCalculate.factorial(2 * n + 1);
            result += term;
            if (Math.abs(term) < precision) {
                break;
            }
        }
        return RoundUtils.roundToPrecision(result, precision);
    }

    public double cos(double x, double precision) {
        if (precision == 0) {
            throw new IllegalArgumentException("Точность 0 делает вычисление cos недостоверным. Для корректного результата выберите ненулевую точность.");
        }
        double result = 0;
        for (int n = 0; ; n++) {
            double term =
                    (BasicCalculate.pow(-1, n) * BasicCalculate.pow(x, 2 * n)) /
                            BasicCalculate.factorial(2 * n);
            result += term;
            if (Math.abs(term) < precision) {
                break;
            }
        }
        return RoundUtils.roundToPrecision(result, precision);
    }

    public double exp(double x, double precision) {
        if (precision == 0) {
            throw new IllegalArgumentException("Точность 0 делает вычисление exp недостоверным. Для корректного результата выберите ненулевую точность.");
        }
        double result = 0;
        for (int n = 0; ; n++) {
            double term =
                    BasicCalculate.pow(x, n) /
                            BasicCalculate.factorial(n);
            result += term;
            if (Math.abs(term) < precision) {
                break;
            }
        }
        return RoundUtils.roundToPrecision(result, precision);
    }

    public double lg(double x, double precision) {
        return log(10, x, precision);
    }

    public double log(double base, double x, double precision) {
        double v = ln(x, precision);
        double v1 = ln(base, precision);
        double result = v /
                v1;
        return RoundUtils.roundToPrecision(result, precision * 10);
    }

    public double ln(double x, double precision) {
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
                        (BasicCalculate.pow(-1, n) * BasicCalculate.pow(x - 1, n + 1)) /
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
            result = ln(tempX, precision) + alpha * Math.log(constNum);
        }
        return RoundUtils.roundToPrecision(result, precision);
    }
}
