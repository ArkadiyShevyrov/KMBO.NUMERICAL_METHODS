package ru.kmbo.numerical_methods.calculate;

import lombok.experimental.UtilityClass;
import ru.kmbo.numerical_methods.model.function.TabularFunction;

@UtilityClass
public class InterpolationCalculate {

    public static double lagrangeInterpolate(TabularFunction func, Double xStar) {
        Double[] x = func.getFunctionSignatures().keySet().toArray(new Double[0]);
        Double[] y = new Double[x.length];
        for (int i = 0; i < x.length; i++) {
            y[i] = func.getResult(x[i]);
        }
        return lagrangeInterpolate(x, y, xStar);
    }

    private static double lagrangeInterpolate(Double[] x, Double[] y, Double xStar) {
        int n = x.length;
        double result = 0.0;

        for (int i = 0; i < n; i++) {
            double term = y[i];
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    term *= (xStar - x[j]) / (x[i] - x[j]);
                }
            }
            result += term;
        }

        return result;
    }

    public static double newtonInterpolate(TabularFunction func, Double xStar) {
        Double[] x = func.getFunctionSignatures().keySet().toArray(new Double[0]);
        Double[] y = new Double[x.length];
        for (int i = 0; i < x.length; i++) {
            y[i] = func.getResult(x[i]);
        }
        return newtonInterpolate(x, y, xStar);
    }

    private static double newtonInterpolate(Double[] x, Double[] y, Double xStar) {
        int n = x.length;
        double[][] dividedDiff = new double[n][n];

        for (int i = 0; i < n; i++) {
            dividedDiff[i][0] = y[i];
        }

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                dividedDiff[i][j] = (dividedDiff[i + 1][j - 1] - dividedDiff[i][j - 1]) / (x[i + j] - x[i]);
            }
        }

        double result = dividedDiff[0][0];
        double term = 1.0;
        for (int i = 1; i < n; i++) {
            term *= (xStar - x[i - 1]);
            result += dividedDiff[0][i] * term;
        }

        return result;
    }
}
