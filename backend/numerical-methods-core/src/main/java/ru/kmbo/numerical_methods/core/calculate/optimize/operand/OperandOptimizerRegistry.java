package ru.kmbo.numerical_methods.core.calculate.optimize.operand;

import ru.kmbo.numerical_methods.core.calculate.optimize.operand.strategy.*;
import ru.kmbo.numerical_methods.core.model.operand.Operand;
import ru.kmbo.numerical_methods.core.model.operand.implementation.*;
import java.util.HashMap;
import java.util.Map;

public class OperandOptimizerRegistry {
    private final Map<Class<? extends Operand>, OperandOptimizationStrategy> strategies = new HashMap<>();

    public OperandOptimizerRegistry(OperandOptimizer optimizer) {
        register(Add.class, new AddOptimizationStrategy(optimizer));
        register(Cos.class, new CosOptimizationStrategy(optimizer));
        register(Multiply.class, new MultiplyOptimizationStrategy(optimizer));
        register(Neg.class, new NegOptimizationStrategy(optimizer));
        register(Num.class, new NumOptimizationStrategy(optimizer));
        register(Pow.class, new PowOptimizationStrategy(optimizer));
        register(Sin.class, new SinOptimizationStrategy(optimizer));
        register(Variable.class, new VariableOptimizationStrategy(optimizer));
        register(Ln.class, new LnOptimizationStrategy(optimizer));
    }

    public void register(Class<? extends Operand> operandType, OperandOptimizationStrategy strategy) {
        strategies.put(operandType, strategy);
    }

    public OperandOptimizationStrategy getStrategy(Class<? extends Operand> operandType) {
        return strategies.getOrDefault(operandType, new UnsupportedOperandStrategy());
    }
}

