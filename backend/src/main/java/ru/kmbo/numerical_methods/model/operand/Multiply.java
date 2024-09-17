package ru.kmbo.numerical_methods.model.operand;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Multiply implements Operand {
    private final List<Operand> operands = new ArrayList<>();

    public Multiply(List<Operand> operands) {
        this.operands.addAll(operands);
    }

    public Multiply(Object... objects) {
        if (objects.length < 2) {
            throw new RuntimeException("Multiply operation requires at least two operands.");
        }
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
        Double result = 1.0;
        for (Operand op : operands) {
            result *= op.getResult();
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder br = new StringBuilder();
        br.append("(");
        for (int i = 0; i < operands.size(); i++) {
            br.append(operands.get(i));
            if (i < operands.size() - 1) {
                br.append(" * ");
            }
        }
        br.append(")");
        return br.toString();
    }
}