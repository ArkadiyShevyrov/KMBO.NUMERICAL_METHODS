package ru.kmbo.numerical_methods.core.model.function.implementation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import ru.kmbo.numerical_methods.core.model.function.Function;
import java.util.*;

@Getter
public class TabularFunction implements Function {
    private final TreeMap<Double, Double> nodes = new TreeMap<>();

    @JsonCreator
    public TabularFunction(@JsonProperty("nodes") Map<Double, Double> nodes) {
        this.nodes.putAll(nodes);
    }

    public TabularFunction(double[] X, OperandFunction operandFunction) {
        for (double x : X) {
            nodes.put(x, operandFunction.apply(x));
        }
    }

    @Override
    public Double apply(Double x) {
        return nodes.get(x);
    }

    public List<Double> getX() {
        return nodes.keySet().stream().toList();
    }

    public List<Double> getY() {
        Set<Double> X = nodes.keySet();
        List<Double> Y = new ArrayList<>(X.size());
        for (Double x : X) {
            Y.add(apply(x));
        }
        return Y;
    }

    @Override
    public String toString() {
        return nodes.toString();
    }
}
