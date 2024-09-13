package ru.kmbo.numerical_methods.calculate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.kmbo.numerical_methods.model.function.TabularFunction;
import ru.kmbo.numerical_methods.model.operand.Operand;
import ru.kmbo.numerical_methods.model.operand.Add;
import ru.kmbo.numerical_methods.model.operand.Sin;

class InterpolationCalculateTest {

    private TabularFunction function;
    private final double[] xValues = {1.0, 2.0, 3.0};
    private final Operand operand = new Add(new Sin(), new Sin());

    @BeforeEach
    void setUp() {
        function = new TabularFunction(xValues, operand);
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
