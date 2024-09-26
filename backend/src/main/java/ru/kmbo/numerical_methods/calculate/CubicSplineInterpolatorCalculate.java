package ru.kmbo.numerical_methods.calculate;

import lombok.experimental.UtilityClass;
import ru.kmbo.numerical_methods.model.function.implementation.TabularFunction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@UtilityClass
public class CubicSplineInterpolatorCalculate {

    public Double evaluateSpline(TabularFunction tabularFunction, double xStar) {
        int n = tabularFunction.getNodes().size() - 1;
        List<Double> x = new ArrayList<>(tabularFunction.getNodes().keySet());
        List<Double> y = new ArrayList<>(tabularFunction.getNodes().values());

        Map<Integer, Double> h = getH(n, x);

        Map<Integer, Double> c = getC(n, h, y);


        Map<Integer, Double> a = getA(n, y);
        Map<Integer, Double> b = getB(n, y, h, c);
        Map<Integer, Double> d = getD(n, c, h);

        int i = 0;
        while (i < n && xStar > x.get(i + 1)) {
            i++;
        }
        return a.get(i) + b.get(i) * (xStar - x.get(i)) + c.get(i) + d.get(i);
    }

    private static Map<Integer, Double> getC(int n, Map<Integer, Double> h, List<Double> y) {
        Map<Integer, Double> c = new HashMap<>();
        double[][] matrixA = new double[n + 1][n + 1];
        double[] vectorB = new double[n + 1];

        for (int i = 1; i < n; i++) {
            if (i == 1) {
                matrixA[i][i] = 2 * (h.get(i) + h.get(i + 1));
                matrixA[i][i + 1] = h.get(i + 1);
                continue;
            }
            if (i == n - 1) {
                matrixA[i][i - 1] = h.get(i);
                matrixA[i][i] = 2 * (h.get(i) + h.get(i + 1));
                continue;
            }
            matrixA[i][i - 1] = h.get(i);
            matrixA[i][i] = 2 * (h.get(i) + h.get(i + 1));
            matrixA[i][i + 1] = h.get(i + 1);
        }
        matrixA[0][0]=1;
        matrixA[n][n]=1;

        for (int i = 1; i < n; i++) {
            vectorB[i] = 3 * ((y.get(i + 1) - y.get(i)) / h.get(i + 1) - (y.get(i) - y.get(i - 1)) / h.get(i));
        }
        vectorB[0]=0;
        vectorB[n]=0;

        double[] solve = GaussianElimination.solve(matrixA, vectorB);
        for (int i = 0; i < solve.length; i++) {
            c.put(i, solve[i]);
        }

        return c;
    }

    private static Map<Integer, Double> getH(int n, List<Double> x) {
        Map<Integer, Double> h = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            h.put(i, x.get(i) - x.get(i - 1));
        }
        return h;
    }

    private Map<Integer, Double> getA(int n, List<Double> y) {
        Map<Integer, Double> a = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            a.put(i, y.get(i));
        }
        return a;
    }

    private Map<Integer, Double> getB(int n, List<Double> y, Map<Integer, Double> h, Map<Integer, Double> c) {
        Map<Integer, Double> b = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            b.put(i, ((y.get(i) - y.get(i - 1)) / h.get(i)) - (((2 * c.get(i - 1) + c.get(i)) / 3) * h.get(i)));
        }
        return b;
    }

    private Map<Integer, Double> getD(int n, Map<Integer, Double> c, Map<Integer, Double> h) {
        Map<Integer, Double> d = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            d.put(i, (c.get(i) - c.get(i - 1)) / (3 * h.get(i)));
        }
        return d;
    }

}
