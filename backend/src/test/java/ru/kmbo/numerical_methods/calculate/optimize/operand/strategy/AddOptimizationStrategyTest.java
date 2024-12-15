package ru.kmbo.numerical_methods.calculate.optimize.operand.strategy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import ru.kmbo.numerical_methods.calculate.optimize.operand.DefaultOperandOptimizer;
import ru.kmbo.numerical_methods.calculate.optimize.operand.OperandOptimizer;
import ru.kmbo.numerical_methods.model.operand.Operand;
import ru.kmbo.numerical_methods.model.operand.implementation.Add;
import ru.kmbo.numerical_methods.model.operand.implementation.Num;

import static org.junit.jupiter.api.Assertions.*;

class AddOptimizationStrategyTest {

    private AddOptimizationStrategy strategy;

    @BeforeEach
    void setUp() {
        OperandOptimizer optimizer = new DefaultOperandOptimizer();
        strategy = new AddOptimizationStrategy(optimizer);
    }

    @Test
    void testOptimizeSimpleAddition() {
        Add add = new Add(new Num(1), new Num(2));
        Operand result = strategy.optimize(add);
        assertEquals(new Num(3), result);
    }

    @Test
    void testOptimizeNestedAddition() {
        Add innerAdd = new Add(new Num(1), new Num(2));
        Add outerAdd = new Add(innerAdd, new Num(3));
        Operand result = strategy.optimize(outerAdd);
        assertEquals(new Num(6), result);
    }

    @Test
    void testOptimizeAdditionWithZero() {
        Add add = new Add(new Num(0), new Num(5));
        Operand result = strategy.optimize(add);
        assertEquals(new Num(5), result);
    }

    @Test
    void testOptimizeAdditionWithMultipleOperands() {
        Add add = new Add(new Num(1), new Num(2), new Num(3), new Num(4));
        Operand result = strategy.optimize(add);
        assertEquals(new Num(10), result);
    }

    @Test
    void testOptimizeComplexNestedAddition() {
        Add nestedAdd = new Add(new Num(1), new Add(new Num(2), new Num(3)));
        Operand result = strategy.optimize(nestedAdd);
        assertEquals(new Num(6), result);
    }
}
