package ru.kmbo.numerical_methods.model.function.implementation;

import ru.kmbo.numerical_methods.model.function.Function;
import java.util.List;

public class LagrangeInterpolationPolynomial implements Function {
    private final List<Double> X;
    private final List<Double> Y;

    public LagrangeInterpolationPolynomial(TabularFunction func) {
        X = func.getX();
        Y = func.getY();
    }

    @Override
    public Double apply(Double x) {
        int n = X.size() - 1;
        double sum = 0;
        for (int i = 0; i <= n; i++) {
            double product = 1.0;
            for (int j = 0; j <= n; j++) {
                if (j == i) continue;
                product *= (x - X.get(j)) / (X.get(i) - X.get(j));
            }
            sum += Y.get(i) * product;
        }
        return sum;
    }

    @Override
    public String toString() {
        return "LagrangeInterpolationPolynomial{\n" +
                "X=" + X + ",\n " +
                "Y=" + Y + "\n " +
                '}';
    }
}