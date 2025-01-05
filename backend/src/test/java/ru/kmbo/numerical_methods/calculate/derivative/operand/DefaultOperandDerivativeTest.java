package ru.kmbo.numerical_methods.calculate.derivative.operand;

import org.junit.jupiter.api.Test;
import ru.kmbo.numerical_methods.model.operand.Operand;
import ru.kmbo.numerical_methods.model.operand.implementation.*;
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

        assertEquals("", differentiate.toString());
    }

    @Test
    void differentiate2() {
        Variable x = new Variable("x");
        Operand operand = new Multiply(
            1.,
            new Pow(new Add(new Pow(x, 2), 4.), -1)
        );
        Operand differentiate = derivative.differentiate(derivative.differentiate(operand, x), x);

        assertEquals("", differentiate.toString());
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

        assertEquals("", differentiate.toString());
    }


}