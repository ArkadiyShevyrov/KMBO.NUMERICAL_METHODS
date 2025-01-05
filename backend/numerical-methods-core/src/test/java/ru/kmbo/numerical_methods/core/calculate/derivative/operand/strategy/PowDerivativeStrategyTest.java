package ru.kmbo.numerical_methods.core.calculate.derivative.operand.strategy;

import org.junit.jupiter.api.Test;
import ru.kmbo.numerical_methods.core.calculate.derivative.operand.DefaultOperandDerivative;
import ru.kmbo.numerical_methods.core.model.operand.Operand;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Neg;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Num;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Pow;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Variable;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PowDerivativeStrategyTest {
    private PowDerivativeStrategy derivative = new PowDerivativeStrategy(new DefaultOperandDerivative());

    @Test
    void differentiate() {
        Variable x = new Variable("x");
        Operand operand = new Pow(x, new Neg(new Num(1)));
        Operand differentiate = derivative.differentiate(operand, x);

        assertEquals("-1 * x^(-1 + -1) * 1 + x^(-1) * 0 * ln(x)", differentiate.toString());
    }
}