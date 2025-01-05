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
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class Lab_1_6_ServiceTest {
    @Autowired
    private Lab_1_6_Service service;

    private final Map<Integer, FunctionTest> functionTestMap = new HashMap<>();

    @Getter
    @AllArgsConstructor
    static class FunctionTest {
        private OperandFunction f;
        private Double a, b, h;
        private Double expected;
    }

    @BeforeEach
    void setUp() {
        Variable x1 = new Variable("x");
        Operand operand1 = new Multiply(
            x1,
            new Pow(new Add(new Multiply(2., x1), 5.), -1)
        );
        OperandFunction f1 = new OperandFunction(operand1, x1);
        Double a1 = -1.;
        Double b1 = 1.;
        Double h1 = 0.5;
        Double expected1 = -0.0591223;

        functionTestMap.put(1, new FunctionTest(f1, a1, b1, h1, expected1));

        Variable x2 = new Variable("x");
        Operand operand2 = new Multiply(
            x2,
            new Pow(new Add(new Multiply(3., x2), 4.), -2)
        );
        OperandFunction f2 = new OperandFunction(operand2, x2);
        Double a2 = 0.;
        Double b2 = 4.;
        Double h2 = 1.;
        Double expected2 = 0.0706994;

        functionTestMap.put(2, new FunctionTest(f2, a2, b2, h2, expected2));

        Variable x3 = new Variable("x");
        Operand operand3 = new Multiply(
            x3,
            new Pow(new Add(new Multiply(3., x3), 4.), -3)
        );
        OperandFunction f3 = new OperandFunction(operand3, x3);
        Double a3 = -1.;
        Double b3 = 1.;
        Double h3 = 0.5;
        Double expected3 = -0.12245;

        functionTestMap.put(3, new FunctionTest(f3, a3, b3, h3, expected3));

        Variable x4 = new Variable("x");
        Operand operand4 = new Multiply(
            new Add(new Multiply(3., x4), 4.),
            new Pow(new Add(new Multiply(2., x4), 7.), -1)
        );
        OperandFunction f4 = new OperandFunction(operand4, x4);
        Double a4 = -2.;
        Double b4 = 2.;
        Double h4 = 1.;
        Double expected4 = 1.77733;

        functionTestMap.put(4, new FunctionTest(f4, a4, b4, h4, expected4));

        Variable x5 = new Variable("x");
        Operand operand5 = new Multiply(
            1.,
            new Pow(new Add(new Pow(x5, 2), 4.), -1)
        );
        OperandFunction f5 = new OperandFunction(operand5, x5);
        Double a5 = -2.;
        Double b5 = 2.;
        Double h5 = 1.;
        Double expected5 = 0.785398;

        functionTestMap.put(5, new FunctionTest(f5, a5, b5, h5, expected5));

        Variable x6 = new Variable("x");
        Operand operand6 = new Multiply(
            x6,
            new Pow(
                new Add(
                    49.,
                    new Neg(
                        new Pow(
                            x6,
                            2)
                    )
                ),
                0.5
            )
        );
        OperandFunction f6 = new OperandFunction(operand6, x6);
        Double a6 = -2.;
        Double b6 = 2.;
        Double h6 = 1.;
        Double expected6 = 0.;

        functionTestMap.put(6, new FunctionTest(f6, a6, b6, h6, expected6));
    }

    @Test
    void testMethods() {
        for (FunctionTest functionTest : functionTestMap.values()) {
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