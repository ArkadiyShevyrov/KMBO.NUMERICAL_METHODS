package ru.kmbo.numerical_methods.calculate.derivative.operand.strategy;

import ru.kmbo.numerical_methods.calculate.derivative.operand.OperandDerivative;
import ru.kmbo.numerical_methods.calculate.derivative.operand.OperandDerivativeStrategy;
import ru.kmbo.numerical_methods.model.operand.Operand;
import ru.kmbo.numerical_methods.model.operand.implementation.Add;
import ru.kmbo.numerical_methods.model.operand.implementation.Variable;
import java.util.ArrayList;
import java.util.List;

public class AddDerivativeStrategy extends OperandDerivativeStrategy {

    public AddDerivativeStrategy(OperandDerivative derivative) {
        super(derivative);
    }

    @Override
    public Operand differentiate(Operand operand, Variable deffierintiationVariable) {
        Add add = (Add) operand;
        return differentiate(add, deffierintiationVariable);
    }

    private Operand differentiate(Add add, Variable deffierintiationVariable) {
        List<Operand> derivativeOperands = new ArrayList<>();
        for (Operand operand : add.getOperands()) {
            derivativeOperands.add(derivative.differentiate(operand, deffierintiationVariable));
        }
        return new Add(derivativeOperands);
    }
}
