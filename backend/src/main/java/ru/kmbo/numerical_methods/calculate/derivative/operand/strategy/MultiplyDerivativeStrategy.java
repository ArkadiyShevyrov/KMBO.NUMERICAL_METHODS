package ru.kmbo.numerical_methods.calculate.derivative.operand.strategy;

import ru.kmbo.numerical_methods.calculate.derivative.operand.OperandDerivative;
import ru.kmbo.numerical_methods.calculate.derivative.operand.OperandDerivativeStrategy;
import ru.kmbo.numerical_methods.model.operand.Operand;
import ru.kmbo.numerical_methods.model.operand.implementation.Add;
import ru.kmbo.numerical_methods.model.operand.implementation.Multiply;
import ru.kmbo.numerical_methods.model.operand.implementation.Variable;
import java.util.ArrayList;
import java.util.List;

public class MultiplyDerivativeStrategy extends OperandDerivativeStrategy {

    public MultiplyDerivativeStrategy(OperandDerivative derivative) {
        super(derivative);
    }

    @Override
    public Operand differentiate(Operand operand, Variable deffierintiationVariable) {
        Multiply multiply = (Multiply) operand;
        return differentiate(multiply, deffierintiationVariable);
    }

    private Operand differentiate(Multiply multiply, Variable deffierintiationVariable) {
        List<Operand> operands = multiply.getOperands();
        List<Operand> operandsAdd = new ArrayList<>();
        for (int i = 0; i < operands.size(); i++) {
            List<Operand> productTerms = new ArrayList<>();
            for (int j = 0; j < operands.size(); j++) {
                if (i == j) {
                    productTerms.add(derivative.differentiate(operands.get(j), deffierintiationVariable));
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
