package ru.kmbo.numerical_methods.model.function;

import lombok.Getter;
import ru.kmbo.numerical_methods.model.operand.Num;
import ru.kmbo.numerical_methods.model.operand.Operand;
import java.util.Map;
import java.util.TreeMap;

@Getter
public class TabularFunction {
    private final TreeMap<Double, Double> nodes = new TreeMap<>();

    public TabularFunction(Map<Double, Double> nodes) {
        this.nodes.putAll(nodes);
    }

    public TabularFunction(double[] xValues, Operand operand, Num num) {
        for (double x : xValues) {
            num.setNumber(x);
            nodes.put(x, operand.getResult());
        }
    }

    public Double getResult(double x) {
        return nodes.get(x);
    }
}
