package ru.kmbo.numerical_methods.calculate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.kmbo.numerical_methods.model.function.implementation.OperandFunction;
import ru.kmbo.numerical_methods.model.function.implementation.TabularFunction;
import ru.kmbo.numerical_methods.model.operand.implementation.Variable;
import ru.kmbo.numerical_methods.model.operand.Operand;
import ru.kmbo.numerical_methods.model.operand.implementation.Add;
import ru.kmbo.numerical_methods.model.operand.implementation.Sin;

class InterpolationCalculateTest {

    private TabularFunction function;
    private final double[] xValues = {1.0, 2.0, 3.0};
    private final Variable var = new Variable("x");
    private final Operand operand = new Add(new Sin(var), new Sin(var));

    @BeforeEach
    void setUp() {
        function = new TabularFunction(xValues, new OperandFunction(operand, var));
    }

    @Test
    void testLagrangeInterpolate() {
        double xStar = 2.0;
        double expectedValue = 1.8185948536;
        double actualValue = InterpolationCalculate.lagrangeInterpolate(function, xStar);
        assertEquals(expectedValue, actualValue, 1e-6);
    }

    @Test
    void testNewtonInterpolate() {
        double xStar = 2.0;
        double expectedValue = 1.8185948536;
        double actualValue = InterpolationCalculate.newtonInterpolate(function, xStar);
        assertEquals(expectedValue, actualValue, 1e-6);
    }
}
