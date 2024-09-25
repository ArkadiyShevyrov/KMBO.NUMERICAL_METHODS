package ru.kmbo.numerical_methods.calculate;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.kmbo.numerical_methods.calculate.derivative.operand.DerivativeOperandCalculate;
import ru.kmbo.numerical_methods.model.function.Function;
import ru.kmbo.numerical_methods.model.operand.*;
import ru.kmbo.numerical_methods.model.operand.implementation.Add;
import ru.kmbo.numerical_methods.model.operand.implementation.Multiply;
import ru.kmbo.numerical_methods.model.operand.implementation.Pow;
import ru.kmbo.numerical_methods.model.operand.implementation.Variable;

@Slf4j
class DerivativeOperandCalculateTest {
    private Function f;

    @BeforeEach
    void setUp() {
        Variable x = new Variable("x");
        Operand operand1 = new Multiply(
                x,
                new Pow(
                        new Add(
                                new Multiply(
                                        3,
                                        x
                                ),
                                4
                        ),
                        -2
                )
        );
        f = new Function(operand1, x);
    }

    @Test
    void test1() {
        Function derivative = DerivativeOperandCalculate.derivative(f);
        log.info(derivative.apply(1.).toString());
    }

}
