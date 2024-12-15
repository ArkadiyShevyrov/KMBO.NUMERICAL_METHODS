package ru.kmbo.numerical_methods.calculate.derivative.operand.strategy;

import ru.kmbo.numerical_methods.calculate.derivative.operand.OperandDerivative;
import ru.kmbo.numerical_methods.model.operand.Operand;
import ru.kmbo.numerical_methods.model.operand.implementation.Num;
import ru.kmbo.numerical_methods.model.operand.implementation.Variable;

public class VariableDerivativeStrategy extends OperandDerivativeStrategy {

    public VariableDerivativeStrategy(OperandDerivative derivative) {
        super(derivative);
    }

    @Override
    public Operand differentiate(Operand operand) {
        Variable variable = (Variable) operand;
        return differentiate(variable);
    }

    private Operand differentiate(Variable variable) {
        return new Num(1.);
    }
}
