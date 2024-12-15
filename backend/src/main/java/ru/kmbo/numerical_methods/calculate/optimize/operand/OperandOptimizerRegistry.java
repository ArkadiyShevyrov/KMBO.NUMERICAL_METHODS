package ru.kmbo.numerical_methods.calculate.optimize.operand;

import ru.kmbo.numerical_methods.calculate.optimize.operand.strategy.AddOptimizationStrategy;
import ru.kmbo.numerical_methods.calculate.optimize.operand.strategy.MultiplyOptimizationStrategy;
import ru.kmbo.numerical_methods.calculate.optimize.operand.strategy.OperandOptimizationStrategy;
import ru.kmbo.numerical_methods.calculate.optimize.operand.strategy.UnsupportedOperandStrategy;
import ru.kmbo.numerical_methods.model.operand.Operand;
import ru.kmbo.numerical_methods.model.operand.implementation.Add;
import ru.kmbo.numerical_methods.model.operand.implementation.Multiply;
import java.util.HashMap;
import java.util.Map;

public class OperandOptimizerRegistry {
    private final Map<Class<? extends Operand>, OperandOptimizationStrategy> strategies = new HashMap<>();

    public OperandOptimizerRegistry(OperandOptimizer optimizer) {
        register(Add.class, new AddOptimizationStrategy(optimizer));
        register(Multiply.class, new MultiplyOptimizationStrategy(optimizer));
    }

    public void register(Class<? extends Operand> operandType, OperandOptimizationStrategy strategy) {
        strategies.put(operandType, strategy);
    }

    public OperandOptimizationStrategy getStrategy(Class<? extends Operand> operandType) {
        return strategies.getOrDefault(operandType, new UnsupportedOperandStrategy());
    }
}

