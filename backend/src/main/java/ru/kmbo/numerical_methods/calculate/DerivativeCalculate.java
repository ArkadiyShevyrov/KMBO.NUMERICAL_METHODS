package ru.kmbo.numerical_methods.calculate;

import lombok.experimental.UtilityClass;
import ru.kmbo.numerical_methods.model.function.TabularFunction;
import java.util.Map;
import java.util.NavigableMap;

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

        if (Math.abs(h2-h1) > EPSILON) {
            throw new IllegalArgumentException("Шаги сетки неравномерны.");
        }

        return (y2 - 2 * y1 + y0) / (Math.pow(h1, 2));
    }
}
