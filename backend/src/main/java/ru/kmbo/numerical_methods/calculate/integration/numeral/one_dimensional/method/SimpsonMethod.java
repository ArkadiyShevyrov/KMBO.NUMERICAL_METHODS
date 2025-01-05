package ru.kmbo.numerical_methods.calculate.integration.numeral.one_dimensional.method;

import ru.kmbo.numerical_methods.calculate.BasicCalculate;
import ru.kmbo.numerical_methods.calculate.DerivativeCalculate;
import ru.kmbo.numerical_methods.calculate.integration.numeral.one_dimensional.NumericalIntegrationMethod;
import ru.kmbo.numerical_methods.model.function.implementation.OperandFunction;
import java.util.HashMap;
import java.util.Map;

public class SimpsonMethod implements NumericalIntegrationMethod {
    @Override
    public Double integrate(OperandFunction f, double a, double b, double h) {
        int N = (int) ((b - a) / h);
        Map<Integer, Double> xMap = new HashMap<>();
        for (int i = 0; i <= N; i++) {
            xMap.put(i, a + i * h);
        }
        double y_0 = f.apply(xMap.get(0));
        double y_N = f.apply(xMap.get(N));
        double y_2i = bigSumEven(f, 1, N / 2 - 1, xMap);
        double y_2i_1 = bigSumOdd(f, 1, N / 2, xMap);
        return (h / 3) * (y_0 + 2 * y_2i + 4 * y_2i_1 + y_N);
    }

    //TODO
    @Override
    public Double tolerance(OperandFunction f, double a, double b, double h) {
        double maxFourthDerivative = DerivativeCalculate.findMaxDerivative(f,4, a, b, h);
        return ((b - a) / 180) * BasicCalculate.pow(h, 4) * maxFourthDerivative;
    }

    private double bigSumEven(OperandFunction f, int iStart, int iEnd, Map<Integer, Double> xMap) {
        double sum = 0;
        for (int i = iStart; i <= iEnd; i++) {
            sum += f.apply(xMap.get(2 * i));
        }
        return sum;
    }

    private double bigSumOdd(OperandFunction f, int iStart, int iEnd, Map<Integer, Double> xMap) {
        double sum = 0;
        for (int i = iStart; i <= iEnd; i++) {
            sum += f.apply(xMap.get(2 * i - 1));
        }
        return sum;
    }
}
