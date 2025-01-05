package ru.kmbo.numerical_methods.core.calculate.derivative.operand;

import ru.kmbo.numerical_methods.core.calculate.derivative.operand.strategy.*;
import ru.kmbo.numerical_methods.core.model.operand.Operand;
import ru.kmbo.numerical_methods.core.model.operand.implementation.*;
import java.util.HashMap;
import java.util.Map;

public class OperandDerivativeRegistry {
    private final Map<Class<? extends Operand>, OperandDerivativeStrategy> strategies = new HashMap<>();

    public OperandDerivativeRegistry(OperandDerivative derivative) {
        register(Add.class, new AddDerivativeStrategy(derivative));
        register(Cos.class, new CosDerivativeStrategy(derivative));
        register(Multiply.class, new MultiplyDerivativeStrategy(derivative));
        register(Neg.class, new NegDerivativeStrategy(derivative));
        register(Num.class, new NumDerivativeStrategy(derivative));
        register(Pow.class, new PowDerivativeStrategy(derivative));
        register(Sin.class, new SinDerivativeStrategy(derivative));
        register(Variable.class, new VariableDerivativeStrategy(derivative));
        register(Ln.class, new LnDerivativeStrategy(derivative));
    }

    public void register(Class<? extends Operand> operandType, OperandDerivativeStrategy strategy) {
        strategies.put(operandType, strategy);
    }

    public OperandDerivativeStrategy getStrategy(Class<? extends Operand> operandType) {
        return strategies.getOrDefault(operandType, new UnsupportedOperandStrategy());
    }
}

