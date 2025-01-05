package ru.kmbo.numerical_methods.labs.calculate.optimize.operand.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.kmbo.numerical_methods.core.calculate.optimize.operand.DefaultOperandOptimizer;
import ru.kmbo.numerical_methods.core.calculate.optimize.operand.OperandOptimizer;
import ru.kmbo.numerical_methods.core.calculate.optimize.operand.strategy.CosOptimizationStrategy;
import ru.kmbo.numerical_methods.core.model.operand.Operand;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Add;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Cos;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Num;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CosOptimizationStrategyTest {

    private CosOptimizationStrategy strategy;

    @BeforeEach
    void setUp() {
        OperandOptimizer optimizer = new DefaultOperandOptimizer();
        strategy = new CosOptimizationStrategy(optimizer);
    }

    @Test
    void testOptimizeCosineWithZeroOperand() {
        Cos cos = new Cos(new Num(1));
        Operand result = strategy.optimize(cos);
        assertEquals(new Cos(new Num(1)), result);
    }

    @Test
    void testOptimizeTrigonometricExpression() {
        Cos cos = new Cos(new Add(new Num(0), new Num(1)));
        Operand result = strategy.optimize(cos);
        assertEquals(new Cos(new Num(1)), result);
    }
}
