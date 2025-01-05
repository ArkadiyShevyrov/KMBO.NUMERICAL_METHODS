package ru.kmbo.numerical_methods.core.calculate.derivative.operand.strategy;

import ru.kmbo.numerical_methods.core.calculate.derivative.operand.OperandDerivative;
import ru.kmbo.numerical_methods.core.calculate.derivative.operand.OperandDerivativeStrategy;
import ru.kmbo.numerical_methods.core.model.operand.Operand;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Add;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Multiply;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Variable;
import java.util.ArrayList;
import java.util.List;

public class MultiplyDerivativeStrategy extends OperandDerivativeStrategy {

    public MultiplyDerivativeStrategy(OperandDerivative derivative) {
        super(derivative);
    }

    @Override
    public Operand differentiate(Operand operand, Variable diffVariable) {
        Multiply multiply = (Multiply) operand;
        return differentiate(multiply, diffVariable);
    }

    private Operand differentiate(Multiply multiply, Variable diffVariable) {
        List<Operand> operands = multiply.getOperands();
        List<Operand> operandsAdd = new ArrayList<>();
        for (int i = 0; i < operands.size(); i++) {
            List<Operand> productTerms = new ArrayList<>();
            for (int j = 0; j < operands.size(); j++) {
                if (i == j) {
                    productTerms.add(derivative.differentiate(operands.get(j), diffVariable));
                } else {
                    productTerms.add(operands.get(j));
                }
            }
            Operand product = new Multiply(productTerms);
            operandsAdd.add(product);
        }
        return new Add(operandsAdd);
    }
}
