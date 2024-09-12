package ru.kmbo.numerical_methods.model;

import lombok.Getter;
import java.util.Map;
import java.util.TreeMap;

@Getter
public class TabularFunction {
    private final TreeMap<Double, Double> functionSignatures = new TreeMap<>();

    public TabularFunction(Map<Double, Double> functionSignatures) {
        this.functionSignatures.putAll(functionSignatures);
    }

    public Double getResult(double x) {
        return functionSignatures.get(x);
    }
}
