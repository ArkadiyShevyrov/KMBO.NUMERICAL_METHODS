package ru.kmbo.numerical_methods.calculate.optimize.operand.strategy;

import ru.kmbo.numerical_methods.calculate.optimize.operand.OperandOptimizer;
import ru.kmbo.numerical_methods.model.operand.Operand;
import ru.kmbo.numerical_methods.model.operand.implementation.Variable;

public class VariableOptimizationStrategy extends OperandOptimizationStrategy {

    public VariableOptimizationStrategy(OperandOptimizer optimizer) {
        super(optimizer);
    }

    @Override
    public Operand optimize(Operand operand) {
        Variable variable = (Variable) operand;
        return optimize(variable);
    }

    private Operand optimize(Variable variable) {
        return variable;
    }
}
