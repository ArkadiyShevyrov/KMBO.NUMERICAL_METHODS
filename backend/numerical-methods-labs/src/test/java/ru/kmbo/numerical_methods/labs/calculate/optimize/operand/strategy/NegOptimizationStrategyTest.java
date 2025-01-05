package ru.kmbo.numerical_methods.labs.calculate.optimize.operand.strategy;

import org.junit.jupiter.api.Test;
import ru.kmbo.numerical_methods.core.calculate.optimize.operand.DefaultOperandOptimizer;
import ru.kmbo.numerical_methods.core.calculate.optimize.operand.strategy.NegOptimizationStrategy;
import ru.kmbo.numerical_methods.core.model.operand.Operand;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Neg;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Num;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Variable;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NegOptimizationStrategyTest {
    NegOptimizationStrategy optimization = new NegOptimizationStrategy(new DefaultOperandOptimizer());


    @Test
    void optimize() {
        Operand operand = new Neg(new Neg(new Variable("x")));
        Operand optimize = optimization.optimize(operand);
        assertEquals("x", optimize.toString());
    }

    @Test
    void optimize1() {
        Operand operand = new Neg(new Neg(new Num(1)));
        Operand optimize = optimization.optimize(operand);
        assertEquals("1.0", optimize.toString());
    }
}