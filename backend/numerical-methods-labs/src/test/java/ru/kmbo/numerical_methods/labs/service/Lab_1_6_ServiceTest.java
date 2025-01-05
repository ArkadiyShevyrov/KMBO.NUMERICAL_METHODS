package ru.kmbo.numerical_methods.labs.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.kmbo.numerical_methods.core.calculate.integration.numeral.one_dimensional.NumericalIntegration;
import ru.kmbo.numerical_methods.core.model.function.implementation.OperandFunction;
import ru.kmbo.numerical_methods.core.model.operand.Operand;
import ru.kmbo.numerical_methods.core.model.operand.implementation.*;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class Lab_1_6_ServiceTest {
    @Autowired
    private Lab_1_6_Service service;

    private final List<FunctionTest> functionTests = new ArrayList<>();

    @Getter
    @AllArgsConstructor
    static class FunctionTest {
        private OperandFunction f;
        private Double a, b, h;
        private Double expected;
    }

    @BeforeEach
    void setUp() {
        Variable x = new Variable("x");

        functionTests.add(createFunctionTest(
            new Multiply(x, new Pow(new Add(new Multiply(2., x), 5.), -1)),
            x, -1., 1., 0.5,
            -0.0591223
        ));

        functionTests.add(createFunctionTest(
            new Multiply(x, new Pow(new Add(new Multiply(3., x), 4.), -2)),
            x, 0., 4., 1.,
            0.0706994
        ));

        functionTests.add(createFunctionTest(
            new Multiply(x, new Pow(new Add(new Multiply(3., x), 4.), -3)),
            x, -1., 1., 0.5,
            -0.12245
        ));

        functionTests.add(createFunctionTest(
            new Multiply(new Add(new Multiply(3., x), 4.), new Pow(new Add(new Multiply(2., x), 7.), -1)),
            x, -2., 2., 1.,
            1.77733
        ));

        functionTests.add(createFunctionTest(
            new Multiply(1., new Pow(new Add(new Pow(x, 2), 4.), -1)),
            x, -2., 2., 1.,
            0.785398
        ));

        functionTests.add(createFunctionTest(
            new Multiply(x, new Pow(new Add(49., new Neg(new Pow(x, 2))), 0.5)),
            x, -2., 2., 1.,
            0.0
        ));
    }

    private FunctionTest createFunctionTest(Operand operand, Variable variable, double a, double b, double h, double expected) {
        OperandFunction function = new OperandFunction(operand, variable);
        return new FunctionTest(function, a, b, h, expected);
    }

    @Test
    void testMethods() {
        for (FunctionTest functionTest : functionTests) {
            for (NumericalIntegration.TypeMethod typeMethod : NumericalIntegration.TypeMethod.values()) {
                testMethod(functionTest, typeMethod);
            }
        }
    }

    private void testMethod(FunctionTest ft, NumericalIntegration.TypeMethod typeMethod) {
        double actualValue = service.integrate(ft.getF(), ft.getA(), ft.getB(), ft.getH(), typeMethod);
        double tolerance = service.tolerance(ft.getF(), ft.getA(), ft.getB(), ft.getH(), typeMethod);
        assertEquals(ft.getExpected(), actualValue, tolerance);
    }
}