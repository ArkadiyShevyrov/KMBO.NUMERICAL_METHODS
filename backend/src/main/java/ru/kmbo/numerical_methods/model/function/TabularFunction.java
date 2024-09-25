package ru.kmbo.numerical_methods.model.function;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import ru.kmbo.numerical_methods.model.operand.Operand;
import ru.kmbo.numerical_methods.model.operand.implementation.Variable;
import java.util.Map;
import java.util.TreeMap;

@Getter
@Schema(description = "Модель табличной функции, которая хранит значения функции в виде узлов")
public class TabularFunction {
    @Schema(description = "Узлы функции в виде пары (x, f(x))",
            example = "{\"-1.0\": -0.5, \"0.0\": 0.0, \"1.0\": 0.5, \"2.0\": 0.86603, \"3.0\": 1.0}")
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

    public Double getResult(double x) {
        return nodes.get(x);
    }

    @Override
    public String toString() {
        return nodes.toString();
    }
}
