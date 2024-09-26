package ru.kmbo.numerical_methods.model.function.implementation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import ru.kmbo.numerical_methods.model.function.Function;
import ru.kmbo.numerical_methods.model.operand.Operand;
import ru.kmbo.numerical_methods.model.operand.implementation.Variable;
import java.util.Map;
import java.util.TreeMap;

@Getter
public class TabularFunction implements Function {
    private final TreeMap<Double, Double> nodes = new TreeMap<>();

    @JsonCreator
    public TabularFunction(@JsonProperty("nodes") Map<Double, Double> nodes) {
        this.nodes.putAll(nodes);
    }

    public TabularFunction(double[] xValues, Operand operand, Variable variable) {
        for (double x : xValues) {
            variable.setVar(x);
            nodes.put(x, operand.getResult());
        }
    }

    @Override
    public Double apply(Double x) {
        return nodes.get(x);
    }

    @Override
    public String toString() {
        return nodes.toString();
    }
}
