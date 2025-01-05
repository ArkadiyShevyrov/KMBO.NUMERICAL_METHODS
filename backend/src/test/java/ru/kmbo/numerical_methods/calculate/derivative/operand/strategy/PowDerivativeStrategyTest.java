package ru.kmbo.numerical_methods.calculate.derivative.operand.strategy;

import org.junit.jupiter.api.Test;
import ru.kmbo.numerical_methods.calculate.derivative.operand.DefaultOperandDerivative;
import ru.kmbo.numerical_methods.model.operand.Operand;
import ru.kmbo.numerical_methods.model.operand.implementation.*;
import static org.junit.jupiter.api.Assertions.*;

class PowDerivativeStrategyTest {
    private PowDerivativeStrategy derivative = new PowDerivativeStrategy(new DefaultOperandDerivative());

    @Test
    void differentiate() {
        Variable x = new Variable("x");
        Operand operand = new Pow(x, new Neg(new Num(1)));
        Operand differentiate = derivative.differentiate(operand, x);

        assertEquals("", differentiate.toString());
    }
}