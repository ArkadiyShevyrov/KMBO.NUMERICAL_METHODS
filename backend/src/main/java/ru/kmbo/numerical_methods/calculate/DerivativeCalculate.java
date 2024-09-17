package ru.kmbo.numerical_methods.calculate;

import lombok.experimental.UtilityClass;
//import ru.kmbo.numerical_methods.calculate.derivative.operand.DerivativeOperandCalculate;
import ru.kmbo.numerical_methods.calculate.derivative.operand.DerivativeOperandCalculate;
import ru.kmbo.numerical_methods.model.function.Function;
import ru.kmbo.numerical_methods.model.function.TabularFunction;
import java.util.*;

@UtilityClass
public class DerivativeCalculate {
    public static final double EPSILON = 1e-10;

    public Double firstDerivative(TabularFunction tabularFunction, double xStar) {
        NavigableMap<Double, Double> data = tabularFunction.getNodes();
        Map.Entry<Double, Double> lowerEntry = data.lowerEntry(xStar);
        Map.Entry<Double, Double> upperEntry = data.higherEntry(xStar);


        if (lowerEntry == null || upperEntry == null) {
            throw new IllegalArgumentException("Точка x* находится за пределами интервала значений или на границе.");
        }

        double x1 = lowerEntry.getKey();
        double y1 = lowerEntry.getValue();
        double x2 = upperEntry.getKey();
        double y2 = upperEntry.getValue();
        double h = x2 - x1;

        return (y2 - y1) / (h);
    }

    public Double secondDerivative(TabularFunction tabularFunction, double xStar) {
        NavigableMap<Double, Double> data = tabularFunction.getNodes();
        Map.Entry<Double, Double> lowerEntry = data.lowerEntry(xStar);
        Map.Entry<Double, Double> currentEntry = data.floorEntry(xStar);
        Map.Entry<Double, Double> upperEntry = data.higherEntry(xStar);

        if (lowerEntry == null || currentEntry == null || upperEntry == null) {
            throw new IllegalArgumentException("Точка x* находится за пределами интервала значений или на границе.");
        }

        double x0 = lowerEntry.getKey();
        double y0 = lowerEntry.getValue();
        double x1 = currentEntry.getKey();
        double y1 = currentEntry.getValue();
        double x2 = upperEntry.getKey();
        double y2 = upperEntry.getValue();

        double h1 = x1 - x0;
        double h2 = x2 - x1;

        if (Math.abs(h2 - h1) > EPSILON) {
            throw new IllegalArgumentException("Шаги сетки неравномерны.");
        }

        return (y2 - 2 * y1 + y0) / (Math.pow(h1, 2));
    }


    public double findMaxFourthDerivative(Function f, double a, double b, double h) {
        List<Double> derivatives = new ArrayList<>();
        int N = (int) ((b - a) / h);
        for (int i = 0; i <= N; i++) {
            double x = a + i * h;
            derivatives.add(Math.abs(derivative(f, x, 4)));
        }
        return Collections.max(derivatives);
    }

    public double findMaxThirdDerivative(Function f, double a, double b, double h) {
        List<Double> derivatives = new ArrayList<>();
        int N = (int) ((b - a) / h);
        for (int i = 0; i <= N; i++) {
            double x = a + i * h;
            derivatives.add(Math.abs(derivative(f, x, 3)));
        }
        return Collections.max(derivatives);
    }

    public double findMaxSecondDerivative(Function f, double a, double b, double h) {
        List<Double> derivatives = new ArrayList<>();
        int N = (int) ((b - a) / h);
        for (int i = 0; i <= N; i++) {
            double x = a + i * h;
            derivatives.add(Math.abs(derivative(f, x, 2)));
        }
        return Collections.max(derivatives);
    }

    public double findMaxFirstDerivative(Function f, double a, double b, double h) {
        List<Double> derivatives = new ArrayList<>();
        int N = (int) ((b - a) / h);
        for (int i = 0; i <= N; i++) {
            double x = a + i * h;
            derivatives.add(Math.abs(derivative(f, x, 1)));
        }
        return Collections.max(derivatives);
    }

    public double fourthDerivative(Function f, double x, double h) {
        return (f.apply(x - 2 * h) - 4 * f.apply(x - h) + 6 * f.apply(x) - 4 * f.apply(x + h) + f.apply(x + 2 * h)) / (h * h * h * h);
    }

    private double thirdDerivative(Function f, double x, double h) {
        return (f.apply(x - 2 * h) - 2 * f.apply(x - h) + 2 * f.apply(x + h) - f.apply(x + 2 * h)) / (2 * h * h * h);
    }

    private double secondDerivative(Function f, double x, double h) {
        return (f.apply(x + h) - 2 * f.apply(x) + f.apply(x - h)) / (h * h);
    }

    public static double firstDerivative(Function func, double x, double h) {
        return (func.apply(x + h) - func.apply(x - h)) / (2 * h);
    }

    public double derivative(Function function, double x, int rang) {
        Function derivativeFunction = function;
        derivativeFunction.getVariable().setVar(null);
        for (int i = 0; i < rang; i++) {
            derivativeFunction = DerivativeOperandCalculate.derivative(derivativeFunction);
        }
        return derivativeFunction.apply(x);
    }
}
