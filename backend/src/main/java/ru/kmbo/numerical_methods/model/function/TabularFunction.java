package ru.kmbo.numerical_methods.model.function;

import lombok.Getter;
import ru.kmbo.numerical_methods.model.operand.Operand;
import java.util.Map;
import java.util.TreeMap;

@Getter
public class TabularFunction {
    private final TreeMap<Double, Double> functionSignatures = new TreeMap<>();

    public TabularFunction(Map<Double, Double> functionSignatures) {
        this.functionSignatures.putAll(functionSignatures);
    }

    public TabularFunction(double[] xValues, Operand operand) {
        for (double x : xValues) {
            functionSignatures.put(x, operand.getResult(x));
        }
    }

    public Double getResult(double x) {
        return functionSignatures.get(x);
    }
}
