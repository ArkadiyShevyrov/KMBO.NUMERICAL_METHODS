package ru.kmbo.numerical_methods.core.calculate.derivative.operand;

import org.junit.jupiter.api.Test;
import ru.kmbo.numerical_methods.core.model.operand.Operand;
import ru.kmbo.numerical_methods.core.model.operand.implementation.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DefaultOperandDerivativeTest {
    private DefaultOperandDerivative derivative = new DefaultOperandDerivative();

    @Test
    void differentiate() {
        Variable x = new Variable("x");
        Operand operand = new Multiply(
            x,
            new Pow(new Add(new Multiply(2., x), 5.), new Neg(new Num(1)))
        );
        Operand differentiate = derivative.differentiate(operand, x);

        assertEquals("(2 * x + 5)^(-1) + (2 * x + 5)^(-2) * -2 * x", differentiate.toString());
    }

    @Test
    void differentiate2() {
        Variable x = new Variable("x");
        Operand operand = new Multiply(
            1.,
            new Pow(new Add(new Pow(x, 2), 4.), -1)
        );
        Operand differentiate = derivative.differentiate(derivative.differentiate(operand, x), x);

        assertEquals("(x^2 + 4)^(-2) * -2 + (x^2 + 4)^(-3) * 8 * x^1 * x^1", differentiate.toString());
    }

    @Test
    void differentiate3() {
        Variable x = new Variable("x");
        Operand operand = new Multiply(
            x,
            new Pow(
                new Add(
                    49.,
                    new Neg(
                        new Pow(
                            x,
                            2)
                    )
                ),
                0.5
            )
        );
        Operand differentiate = derivative.differentiate(operand, x);

        assertEquals("(-(x^2) + 49)^(-0.5) * -(2 * x^1) * 0.5 * x + (-(x^2) + 49)^0.5", differentiate.toString());
    }


}