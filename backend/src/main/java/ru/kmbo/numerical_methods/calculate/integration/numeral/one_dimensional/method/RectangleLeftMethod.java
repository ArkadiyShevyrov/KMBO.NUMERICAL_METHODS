
package ru.kmbo.numerical_methods.calculate.integration.numeral.one_dimensional.method;

import ru.kmbo.numerical_methods.calculate.BasicCalculate;
import ru.kmbo.numerical_methods.calculate.DerivativeCalculate;
import ru.kmbo.numerical_methods.calculate.integration.numeral.one_dimensional.NumericalIntegrationMethod;
import ru.kmbo.numerical_methods.model.function.Function;
import java.util.HashMap;
import java.util.Map;

public class RectangleLeftMethod implements NumericalIntegrationMethod {
    @Override
    public Double integrate(Function f, double a, double b, double h) {
        int N = (int) ((b - a) / h);
        Map<Integer, Double> xMap = new HashMap<>();
        for (int i = 0; i <= N; i++) {
            xMap.put(i, a + i * h);
        }
        double y_i = bigSum(f, 0, N - 1, xMap);
        return h * y_i;
    }

    @Override
    public Double tolerance(Function f, double a, double b, double h) {
        double maxFirstDerivative = DerivativeCalculate.findMaxFirstDerivative(f, a, b, h);
        return ((b - a) / 2) * BasicCalculate.pow(h, 1) * maxFirstDerivative;
    }

    private double bigSum(Function f, int iStart, int iEnd, Map<Integer, Double> xMap) {
        double sum = 0;
        for (int i = iStart; i <= iEnd; i++) {
            sum += f.apply(xMap.get(i));
        }
        return sum;
    }
}
