package ru.kmbo.numerical_methods.calculate;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.kmbo.numerical_methods.calculate.derivative.operand_function.OperandFunctionDerivative;
import ru.kmbo.numerical_methods.model.function.implementation.OperandFunction;
import ru.kmbo.numerical_methods.model.operand.Operand;
import ru.kmbo.numerical_methods.model.operand.implementation.Add;
import ru.kmbo.numerical_methods.model.operand.implementation.Multiply;
import ru.kmbo.numerical_methods.model.operand.implementation.Pow;
import ru.kmbo.numerical_methods.model.operand.implementation.Variable;

@Slf4j
class OperandDerivativeCalculateTest {
    private OperandFunction f;

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
        f = new OperandFunction(operand1, x);
    }

    @Test
    void test1() {
        OperandFunction derivative = OperandFunctionDerivative.differentiate(f);
        log.info(derivative.apply(1.).toString());
    }

}
