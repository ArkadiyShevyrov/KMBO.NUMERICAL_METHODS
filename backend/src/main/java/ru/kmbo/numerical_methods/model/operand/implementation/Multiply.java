package ru.kmbo.numerical_methods.model.operand.implementation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import ru.kmbo.numerical_methods.model.operand.Operand;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Multiply implements Operand {
    private final List<Operand> operands = new ArrayList<>();

    @JsonCreator
    public Multiply(@JsonProperty("operands") List<Operand> operands) {
        this.operands.addAll(operands);
    }

    public Multiply(Object... objects) {
        for (Object object : objects) {
            if (object instanceof Operand operand) {
                operands.add(operand);
                continue;
            }
            if (object instanceof Double operand) {
                operands.add(new Num(operand));
                continue;
            }
            if (object instanceof Integer operand) {
                operands.add(new Num(operand));
                continue;
            }
            throw new RuntimeException("Unsupported object type in Multiply operation.");
        }
    }

    @Override
    public Double getResult() {
        return operands.stream()
                .mapToDouble(Operand::getResult)
                .reduce(1.0, (a, b) -> a * b);
    }

    @Override
    public String toString() {
        StringBuilder br = new StringBuilder();
        for (int i = 0; i < operands.size(); i++) {

            Operand operand = operands.get(i);
            if (operand instanceof Add) {
                br.append("(");
                br.append(operand);
                br.append(")");
            } else {
                br.append(operand);
            }
            if (i < operands.size() - 1) {
                br.append(" * ");
            }
        }
        return br.toString();
    }
}