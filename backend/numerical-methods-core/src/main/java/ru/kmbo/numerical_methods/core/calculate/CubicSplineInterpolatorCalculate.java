package ru.kmbo.numerical_methods.core.calculate;

import lombok.experimental.UtilityClass;
import ru.kmbo.numerical_methods.core.model.basic.Matrix;
import ru.kmbo.numerical_methods.core.model.basic.SystemLinearEquations;
import ru.kmbo.numerical_methods.core.model.basic.Vector;
import ru.kmbo.numerical_methods.core.model.function.implementation.TabularFunction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@UtilityClass
public class CubicSplineInterpolatorCalculate {

    public Double evaluateSpline(TabularFunction tabularFunction, double xStar) {
        int n = tabularFunction.getNodes().size() - 1;
        List<Double> X = tabularFunction.getX();
        List<Double> Y = tabularFunction.getY();

        Map<Integer, Double> h = getH(n, X);

        Vector c = getC(n, h, Y);


        Map<Integer, Double> a = getA(n, Y);
        Map<Integer, Double> b = getB(n, Y, h, c);
        Map<Integer, Double> d = getD(n, c, h);

        int i;
        for (i = 1; i <= n; i++) {
            if (X.get(i - 1) <= xStar && xStar <= X.get(i)) {
                break;
            }
        }
        return a.get(i) +
            b.get(i) * (xStar - X.get(i)) +
            c.get(i) / 2 * (xStar - X.get(i)) * (xStar - X.get(i)) +
            d.get(i) / 6 * (xStar - X.get(i)) * (xStar - X.get(i)) * (xStar - X.get(i));
    }

    private static Vector getC(int n, Map<Integer, Double> h, List<Double> y) {
        Matrix A = new Matrix();
        A.set(0, 0, 1.);
        for (int i = 1; i <= n - 1; i++) {
            A.set(i, i - 1, h.get(i));
            A.set(i, i, 2 * (h.get(i) + h.get(i + 1)));
            A.set(i, i + 1, h.get(i + 1));
        }
        A.set(n, n, 1.);
        Vector B = new Vector();
        B.set(0, 0.);
        for (int i = 1; i <= n - 1; i++) {
            B.set(i, 6 *
                ((
                    (y.get(i + 1) - y.get(i)) / h.get(i + 1)
                ) - (
                    (y.get(i) - y.get(i - 1)) / h.get(i)
                ))
            );
        }
        B.set(n, 0.);
        SystemLinearEquations systemLinearEquations = new SystemLinearEquations(A, B);
        return SystemLinearEquationsCalculate.calculate(systemLinearEquations);
    }

    private static Map<Integer, Double> getH(int n, List<Double> X) {
        Map<Integer, Double> h = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            h.put(i, X.get(i) - X.get(i - 1));
        }
        return h;
    }

    private Map<Integer, Double> getA(int n, List<Double> Y) {
        Map<Integer, Double> a = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            a.put(i, Y.get(i));
        }
        return a;
    }

    private Map<Integer, Double> getB(int n, List<Double> y, Map<Integer, Double> h, Vector c) {
        Map<Integer, Double> b = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            b.put(i, ((y.get(i) - y.get(i - 1)) / h.get(i)) + (c.get(i) * (h.get(i) / 3)) + (c.get(i - 1) * (h.get(i) / 6)));
        }
        return b;
    }

    private Map<Integer, Double> getD(int n, Vector c, Map<Integer, Double> h) {
        Map<Integer, Double> d = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            d.put(i, (c.get(i) - c.get(i - 1)) / h.get(i));
        }
        return d;
    }

}
