package ru.kmbo.numerical_methods.core.calculate.derivative.operand.strategy;

import ru.kmbo.numerical_methods.core.calculate.derivative.operand.OperandDerivative;
import ru.kmbo.numerical_methods.core.model.operand.Operand;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Num;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Variable;
import ru.kmbo.numerical_methods.core.calculate.derivative.operand.OperandDerivative;
import ru.kmbo.numerical_methods.core.model.operand.Operand;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Num;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Variable;
import ru.kmbo.numerical_methods.core.calculate.derivative.operand.OperandDerivative;
import ru.kmbo.numerical_methods.core.calculate.derivative.operand.OperandDerivativeStrategy;
import ru.kmbo.numerical_methods.core.model.operand.Operand;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Num;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Variable;
import ru.kmbo.numerical_methods.core.calculate.derivative.operand.OperandDerivative;
import ru.kmbo.numerical_methods.core.model.operand.Operand;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Num;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Variable;

public class VariableDerivativeStrategy extends OperandDerivativeStrategy {

    public VariableDerivativeStrategy(OperandDerivative derivative) {
        super(derivative);
    }

    @Override
    public Operand differentiate(Operand operand, Variable diffVariable) {
        Variable variable = (Variable) operand;
        return differentiate(variable, diffVariable);
    }

    private Operand differentiate(Variable variable, Variable diffVariable) {
        return variable.getName().equals(diffVariable.getName()) ?
                new Num(1.) : new Num(0.);
    }
}
