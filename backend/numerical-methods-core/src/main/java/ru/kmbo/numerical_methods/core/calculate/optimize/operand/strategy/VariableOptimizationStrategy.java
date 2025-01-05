package ru.kmbo.numerical_methods.core.calculate.optimize.operand.strategy;

import ru.kmbo.numerical_methods.core.calculate.optimize.operand.OperandOptimizer;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Variable;
import ru.kmbo.numerical_methods.core.calculate.optimize.operand.OperandOptimizer;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Variable;
import ru.kmbo.numerical_methods.core.calculate.optimize.operand.OperandOptimizationStrategy;
import ru.kmbo.numerical_methods.core.calculate.optimize.operand.OperandOptimizer;
import ru.kmbo.numerical_methods.core.model.operand.Operand;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Variable;
import ru.kmbo.numerical_methods.core.calculate.optimize.operand.OperandOptimizer;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Variable;

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
