package ru.kmbo.numerical_methods.labs.calculate.derivative.operand.strategy;

import org.junit.jupiter.api.Test;
import ru.kmbo.numerical_methods.core.calculate.derivative.operand.DefaultOperandDerivative;
import ru.kmbo.numerical_methods.core.calculate.derivative.operand.strategy.PowDerivativeStrategy;
import ru.kmbo.numerical_methods.core.model.operand.Operand;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Neg;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Num;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Pow;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Variable;
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