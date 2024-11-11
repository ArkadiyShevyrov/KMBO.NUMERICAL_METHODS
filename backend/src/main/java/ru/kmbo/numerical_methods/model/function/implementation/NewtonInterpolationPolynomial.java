package ru.kmbo.numerical_methods.model.function.implementation;

import ru.kmbo.numerical_methods.model.function.Function;
import java.util.ArrayList;
import java.util.List;

public class NewtonInterpolationPolynomial implements Function {
    private final List<Double> X;
    private final List<Double> separateDifferences;

    public NewtonInterpolationPolynomial(TabularFunction func) {
        List<Double> X = func.getX();
        List<Double> Y = func.getY();
        int n = X.size() - 1;
        List<Double> separateDifferences = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            separateDifferences.add(0.);
        }
        separateDifferences.set(0, Y.getFirst());
        for (int k = 1; k <= n; k++) {
            double sum = 0;
            for (int i = 0; i <= k; i++) {
                double product = 1.0;
                for (int j = 0; j <= k; j++) {
                    if (j == i) continue;
                    product *= X.get(i) - X.get(j);
                }
                sum += Y.get(i) / product;
            }
            separateDifferences.set(k, sum);
        }
        this.X = X;
        this.separateDifferences = separateDifferences;
    }

    @Override
    public Double apply(Double xStar) {
        int n = X.size() - 1;
        double sum = 0;
        for (int k = 0; k <= n; k++) {
            double product = 1.0;
            for (int i = 0; i <= k - 1; i++) {
                product *= xStar - X.get(i);
            }
            sum += separateDifferences.get(k) * product;
        }
        return sum;
    }

    @Override
    public String toString() {
        return "NewtonInterpolationPolynomial{\n" +
                "X=" + X + ",\n " +
                "separateDifferences=" + separateDifferences + "\n " +
                '}';
    }
}