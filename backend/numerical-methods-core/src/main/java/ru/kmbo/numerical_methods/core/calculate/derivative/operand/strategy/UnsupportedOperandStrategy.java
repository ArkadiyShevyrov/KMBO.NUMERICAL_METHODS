package ru.kmbo.numerical_methods.core.calculate.derivative.operand.strategy;

import ru.kmbo.numerical_methods.core.model.operand.Operand;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Variable;
import ru.kmbo.numerical_methods.core.model.operand.Operand;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Variable;
import ru.kmbo.numerical_methods.core.calculate.derivative.operand.OperandDerivativeStrategy;
import ru.kmbo.numerical_methods.core.model.operand.Operand;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Variable;
import ru.kmbo.numerical_methods.core.model.operand.Operand;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Variable;

public class UnsupportedOperandStrategy extends OperandDerivativeStrategy {
    public UnsupportedOperandStrategy() {
        super(null);
    }

    @Override
    public Operand differentiate(Operand operand, Variable diffVariable) {
        throw new UnsupportedOperationException("No strategy found for type: " + operand.getClass().getName());
    }
}
