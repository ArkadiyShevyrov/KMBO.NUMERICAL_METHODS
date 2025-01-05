package ru.kmbo.numerical_methods.labs.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.kmbo.numerical_methods.core.calculate.integration.numeral.one_dimensional.NumericalIntegration;
import ru.kmbo.numerical_methods.core.model.function.implementation.OperandFunction;
import ru.kmbo.numerical_methods.core.model.operand.Operand;
import ru.kmbo.numerical_methods.core.model.operand.implementation.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.kmbo.numerical_methods.core.constant.Constant.PRECISION;

@SpringBootTest
class Lab_1_6_ServiceTest {
    @Autowired
    private Lab_1_6_Service service;

    private OperandFunction f1;
    private Double a1, b1, h1;

    private OperandFunction f2;
    private Double a2, b2, h2;

    private OperandFunction f3;
    private Double a3, b3, h3;

    private OperandFunction f4;
    private Double a4, b4, h4;

    private OperandFunction f5;
    private Double a5, b5, h5;

    private OperandFunction f6;
    private Double a6, b6, h6;

    @BeforeEach
    void setUp() {
        Variable x1 = new Variable("x");
        Operand operand1 = new Multiply(
            x1,
            new Pow(new Add(new Multiply(2., x1), 5.), -1)
        );
        f1 = new OperandFunction(operand1, x1);
        a1 = -1.;
        b1 = 1.;
        h1 = 0.5;

        Variable x2 = new Variable("x");
        Operand operand2 = new Multiply(
            x2,
            new Pow(new Add(new Multiply(3., x2), 4.), -2)
        );
        f2 = new OperandFunction(operand2, x2);
        a2 = 0.;
        b2 = 4.;
        h2 = 1.;

        Variable x3 = new Variable("x");
        Operand operand3 = new Multiply(
            x3,
            new Pow(new Add(new Multiply(3., x3), 4.), -3)
        );
        f3 = new OperandFunction(operand3, x3);
        a3 = -1.;
        b3 = 1.;
        h3 = 0.5;

        Variable x4 = new Variable("x");
        Operand operand4 = new Multiply(
            new Add(new Multiply(3., x4), 4.),
            new Pow(new Add(new Multiply(2., x4), 7.), -1)
        );
        f4 = new OperandFunction(operand4, x4);
        a4 = -2.;
        b4 = 2.;
        h4 = 1.;

        Variable x5 = new Variable("x");
        Operand operand5 = new Multiply(
            1.,
            new Pow(new Add(new Pow(x5, 2), 4.), -1)
        );
        f5 = new OperandFunction(operand5, x5);
        a5 = -2.;
        b5 = 2.;
        h5 = 1.;

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
        f6 = new OperandFunction(operand6, x6);
        a6 = -2.;
        b6 = 2.;
        h6 = 1.;
    }

    @Test
    void testRectangleLeftMethod_f1() {
        double actualValue = service.integrate(f1, a1, b1, h1, NumericalIntegration.TypeMethod.RECTANGLE_LEFT_METHOD);
        double tolerance = service.tolerance(f1, a1, b1, h1, NumericalIntegration.TypeMethod.RECTANGLE_LEFT_METHOD);
        assertEquals(-0.1875, actualValue, PRECISION);
        assertEquals(0.2777777777777778, tolerance, PRECISION);
        assertEquals(-0.0591223, actualValue, tolerance);
    }

    @Test
    void testRectangleMedianMethod_f1() {
        double actualValue = service.integrate(f1, a1, b1, h1, NumericalIntegration.TypeMethod.RECTANGLE_MEDIAN_METHOD);
        double tolerance = service.tolerance(f1, a1, b1, h1, NumericalIntegration.TypeMethod.RECTANGLE_MEDIAN_METHOD);
        assertEquals(-0.05450105450105448, actualValue, PRECISION);
        assertEquals(0.030864197530864196, tolerance, PRECISION);
        assertEquals(-0.0591223, actualValue, tolerance);
    }

    @Test
    void testRectangleRightMethod_f1() {
        double actualValue = service.integrate(f1, a1, b1, h1, NumericalIntegration.TypeMethod.RECTANGLE_RIGHT_METHOD);
        double tolerance = service.tolerance(f1, a1, b1, h1, NumericalIntegration.TypeMethod.RECTANGLE_RIGHT_METHOD);
        assertEquals(0.05059523809523809, actualValue, PRECISION);
        assertEquals(0.2777777777777778, tolerance, PRECISION);
        assertEquals(-0.0591223, actualValue, tolerance);
    }

    @Test
    void testSimpsonMethod_f1() {
        double actualValue = service.integrate(f1, a1, b1, h1, NumericalIntegration.TypeMethod.SIMPSON_METHOD);
        double tolerance = service.tolerance(f1, a1, b1, h1, NumericalIntegration.TypeMethod.SIMPSON_METHOD);
        assertEquals(-0.05952380952380952, actualValue, PRECISION);
        assertEquals(0.0027434842249657062, tolerance, PRECISION);
        assertEquals(-0.0591223, actualValue, tolerance);
    }

    @Test
    void testTrapezoidMethod_f1() {
        double actualValue = service.integrate(f1, a1, b1, h1, NumericalIntegration.TypeMethod.TRAPEZOID_METHOD);
        double tolerance = service.tolerance(f1, a1, b1, h1, NumericalIntegration.TypeMethod.TRAPEZOID_METHOD);
        assertEquals(-0.06845238095238096, actualValue, PRECISION);
        assertEquals(0.018896447469043027, tolerance, PRECISION);
        assertEquals(-0.0591223, actualValue, tolerance);
    }

    @Test
    void testRectangleLeftMethod_f2() {
        double actualValue = service.integrate(f2, a2, b2, h2, NumericalIntegration.TypeMethod.RECTANGLE_LEFT_METHOD);
        double tolerance = service.tolerance(f2, a2, b2, h2, NumericalIntegration.TypeMethod.RECTANGLE_LEFT_METHOD);
        assertEquals(0.05815964255524695, actualValue, PRECISION);
        assertEquals(0.125, tolerance, PRECISION);
        assertEquals(0.0706994, actualValue, tolerance);
    }

    @Test
    void testRectangleMedianMethod_f2() {
        double actualValue = service.integrate(f2, a2, b2, h2, NumericalIntegration.TypeMethod.RECTANGLE_MEDIAN_METHOD);
        double tolerance = service.tolerance(f2, a2, b2, h2, NumericalIntegration.TypeMethod.RECTANGLE_MEDIAN_METHOD);
        assertEquals(0.07284061196629331, actualValue, PRECISION);
        assertEquals(0.03125, tolerance, PRECISION);
        assertEquals(0.0706994, actualValue, tolerance);
    }

    @Test
    void testRectangleRightMethod_f2() {
        double actualValue = service.integrate(f2, a2, b2, h2, NumericalIntegration.TypeMethod.RECTANGLE_RIGHT_METHOD);
        double tolerance = service.tolerance(f2, a2, b2, h2, NumericalIntegration.TypeMethod.RECTANGLE_RIGHT_METHOD);
        assertEquals(0.07378464255524694, actualValue, PRECISION);
        assertEquals(0.125, tolerance, PRECISION);
        assertEquals(0.0706994, actualValue, tolerance);
    }

    @Test
    void testSimpsonMethod_f2() {
        double actualValue = service.integrate(f2, a2, b2, h2, NumericalIntegration.TypeMethod.SIMPSON_METHOD);
        double tolerance = service.tolerance(f2, a2, b2, h2, NumericalIntegration.TypeMethod.SIMPSON_METHOD);
        assertEquals(0.0694211900736626, actualValue, PRECISION);
        assertEquals(0.05625, tolerance, PRECISION);
        assertEquals(0.0706994, actualValue, tolerance);
    }

    @Test
    void testTrapezoidMethod_f2() {
        double actualValue = service.integrate(f2, a2, b2, h2, NumericalIntegration.TypeMethod.TRAPEZOID_METHOD);
        double tolerance = service.tolerance(f2, a2, b2, h2, NumericalIntegration.TypeMethod.TRAPEZOID_METHOD);
        assertEquals(0.06597214255524694, actualValue, PRECISION);
        assertEquals(0.021484375003519893, tolerance, PRECISION);
        assertEquals(0.0706994, actualValue, tolerance);
    }

    @Test
    void testRectangleLeftMethod_f3() {
        double actualValue = service.integrate(f3, a3, b3, h3, NumericalIntegration.TypeMethod.RECTANGLE_LEFT_METHOD);
        double tolerance = service.tolerance(f3, a3, b3, h3, NumericalIntegration.TypeMethod.RECTANGLE_LEFT_METHOD);
        assertEquals(-0.5144973703981969, actualValue, PRECISION);
        assertEquals(5.0, tolerance, PRECISION);
        assertEquals(-0.12245, actualValue, tolerance);
    }

    @Test
    void testRectangleMedianMethod_f3() {
        double actualValue = service.integrate(f3, a3, b3, h3, NumericalIntegration.TypeMethod.RECTANGLE_MEDIAN_METHOD);
        double tolerance = service.tolerance(f3, a3, b3, h3, NumericalIntegration.TypeMethod.RECTANGLE_MEDIAN_METHOD);
        assertEquals(-0.07090982378616856, actualValue, PRECISION);
        assertEquals(5.25, tolerance, PRECISION);
        assertEquals(-0.12245, actualValue, tolerance);
    }

    @Test
    void testRectangleRightMethod_f3() {
        double actualValue = service.integrate(f3, a3, b3, h3, NumericalIntegration.TypeMethod.RECTANGLE_RIGHT_METHOD);
        double tolerance = service.tolerance(f3, a3, b3, h3, NumericalIntegration.TypeMethod.RECTANGLE_RIGHT_METHOD);
        assertEquals(-0.013039644450674978, actualValue, PRECISION);
        assertEquals(5.0, tolerance, PRECISION);
        assertEquals(-0.12245, actualValue, tolerance);
    }

    @Test
    void testSimpsonMethod_f3() {
        double actualValue = service.integrate(f3, a3, b3, h3, NumericalIntegration.TypeMethod.SIMPSON_METHOD);
        double tolerance = service.tolerance(f3, a3, b3, h3, NumericalIntegration.TypeMethod.SIMPSON_METHOD);
        assertEquals(-0.18551058521508848, actualValue, PRECISION);
        assertEquals(24.75, tolerance, PRECISION);
        assertEquals(-0.12245, actualValue, tolerance);
    }

    @Test
    void testTrapezoidMethod_f3() {
        double actualValue = service.integrate(f3, a3, b3, h3, NumericalIntegration.TypeMethod.TRAPEZOID_METHOD);
        double tolerance = service.tolerance(f3, a3, b3, h3, NumericalIntegration.TypeMethod.TRAPEZOID_METHOD);
        assertEquals(-0.2637685074244359, actualValue, PRECISION);
        assertEquals(0.4167013744273219, tolerance, PRECISION);
        assertEquals(-0.12245, actualValue, tolerance);
    }

    @Test
    void testRectangleLeftMethod_f4() {
        double actualValue = service.integrate(f4, a4, b4, h4, NumericalIntegration.TypeMethod.RECTANGLE_LEFT_METHOD);
        double tolerance = service.tolerance(f4, a4, b4, h4, NumericalIntegration.TypeMethod.RECTANGLE_LEFT_METHOD);
        assertEquals(0.8825396825396825, actualValue, PRECISION);
        assertEquals(2.888888888888889, tolerance, PRECISION);
        assertEquals(1.77733, actualValue, tolerance);
    }

    @Test
    void testRectangleMedianMethod_f4() {
        double actualValue = service.integrate(f4, a4, b4, h4, NumericalIntegration.TypeMethod.RECTANGLE_MEDIAN_METHOD);
        double tolerance = service.tolerance(f4, a4, b4, h4, NumericalIntegration.TypeMethod.RECTANGLE_MEDIAN_METHOD);
        assertEquals(1.8291666666666666, actualValue, PRECISION);
        assertEquals(0.32098765432098764, tolerance, PRECISION);
        assertEquals(1.77733, actualValue, tolerance);
    }

    @Test
    void testRectangleRightMethod_f4() {
        double actualValue = service.integrate(f4, a4, b4, h4, NumericalIntegration.TypeMethod.RECTANGLE_RIGHT_METHOD);
        double tolerance = service.tolerance(f4, a4, b4, h4, NumericalIntegration.TypeMethod.RECTANGLE_RIGHT_METHOD);
        assertEquals(2.458297258297258, actualValue, PRECISION);
        assertEquals(2.888888888888889, tolerance, PRECISION);
        assertEquals(1.77733, actualValue, tolerance);
    }

    @Test
    void testSimpsonMethod_f4() {
        double actualValue = service.integrate(f4, a4, b4, h4, NumericalIntegration.TypeMethod.SIMPSON_METHOD);
        double tolerance = service.tolerance(f4, a4, b4, h4, NumericalIntegration.TypeMethod.SIMPSON_METHOD);
        assertEquals(1.7654641654641656, actualValue, PRECISION);
        assertEquals(0.22825788751714676, tolerance, PRECISION);
        assertEquals(1.77733, actualValue, tolerance);
    }

    @Test
    void testTrapezoidMethod_f4() {
        double actualValue = service.integrate(f4, a4, b4, h4, NumericalIntegration.TypeMethod.TRAPEZOID_METHOD);
        double tolerance = service.tolerance(f4, a4, b4, h4, NumericalIntegration.TypeMethod.TRAPEZOID_METHOD);
        assertEquals(1.6704184704184701, actualValue, PRECISION);
        assertEquals(0.4456688093290583, tolerance, PRECISION);
        assertEquals(1.77733, actualValue, tolerance);
    }

    @Test
    void testRectangleLeftMethod_f5() {
        double actualValue = service.integrate(f5, a5, b5, h5, NumericalIntegration.TypeMethod.RECTANGLE_LEFT_METHOD);
        double tolerance = service.tolerance(f5, a5, b5, h5, NumericalIntegration.TypeMethod.RECTANGLE_LEFT_METHOD);
        assertEquals(0.7749999999999999, actualValue, PRECISION);
        assertEquals(0.16, tolerance, PRECISION);
        assertEquals(0.785398, actualValue, tolerance);
    }

    @Test
    void testRectangleMedianMethod_f5() {
        double actualValue = service.integrate(f5, a5, b5, h5, NumericalIntegration.TypeMethod.RECTANGLE_MEDIAN_METHOD);
        double tolerance = service.tolerance(f5, a5, b5, h5, NumericalIntegration.TypeMethod.RECTANGLE_MEDIAN_METHOD);
        assertEquals(0.79058823529411774, actualValue, PRECISION);
        assertEquals(0.020833333333333332, tolerance, PRECISION);
        assertEquals(0.785398, actualValue, tolerance);
    }

    @Test
    void testRectangleRightMethod_f5() {
        double actualValue = service.integrate(f5, a5, b5, h5, NumericalIntegration.TypeMethod.RECTANGLE_RIGHT_METHOD);
        double tolerance = service.tolerance(f5, a5, b5, h5, NumericalIntegration.TypeMethod.RECTANGLE_RIGHT_METHOD);
        assertEquals(0.775, actualValue, PRECISION);
        assertEquals(0.16, tolerance, PRECISION);
        assertEquals(0.785398, actualValue, tolerance);
    }

    @Test
    void testSimpsonMethod_f5() {
        double actualValue = service.integrate(f5, a5, b5, h5, NumericalIntegration.TypeMethod.SIMPSON_METHOD);
        double tolerance = service.tolerance(f5, a5, b5, h5, NumericalIntegration.TypeMethod.SIMPSON_METHOD);
        assertEquals(0.7833333333333333, actualValue, PRECISION);
        assertEquals(0.008333333333333333, tolerance, PRECISION);
        assertEquals(0.785398, actualValue, tolerance);
    }

    @Test
    void testTrapezoidMethod_f5() {
        double actualValue = service.integrate(f5, a5, b5, h5, NumericalIntegration.TypeMethod.TRAPEZOID_METHOD);
        double tolerance = service.tolerance(f5, a5, b5, h5, NumericalIntegration.TypeMethod.TRAPEZOID_METHOD);
        assertEquals(0.775, actualValue, PRECISION);
        assertEquals(0.041666666666939634, tolerance, PRECISION);
        assertEquals(0.785398, actualValue, tolerance);
    }

    @Test
    void testRectangleLeftMethod_f6() {
        double actualValue = service.integrate(f6, a6, b6, h6, NumericalIntegration.TypeMethod.RECTANGLE_LEFT_METHOD);
        double tolerance = service.tolerance(f6, a6, b6, h6, NumericalIntegration.TypeMethod.RECTANGLE_LEFT_METHOD);
        assertEquals(-13.416407864998742, actualValue, PRECISION);
        assertEquals(14, tolerance, PRECISION);
        assertEquals(0, actualValue, tolerance);
    }

    @Test
    void testRectangleMedianMethod_f6() {
        double actualValue = service.integrate(f6, a6, b6, h6, NumericalIntegration.TypeMethod.RECTANGLE_MEDIAN_METHOD);
        double tolerance = service.tolerance(f6, a6, b6, h6, NumericalIntegration.TypeMethod.RECTANGLE_MEDIAN_METHOD);
        assertEquals(0, actualValue, PRECISION);
        assertEquals(0.1534881229, tolerance, PRECISION);
        assertEquals(0, actualValue, tolerance);
    }

    @Test
    void testRectangleRightMethod_f6() {
        double actualValue = service.integrate(f6, a6, b6, h6, NumericalIntegration.TypeMethod.RECTANGLE_RIGHT_METHOD);
        double tolerance = service.tolerance(f6, a6, b6, h6, NumericalIntegration.TypeMethod.RECTANGLE_RIGHT_METHOD);
        assertEquals(13.416407864998739, actualValue, PRECISION);
        assertEquals(14, tolerance, PRECISION);
        assertEquals(0, actualValue, tolerance);
    }

    @Test
    void testSimpsonMethod_f6() {
        double actualValue = service.integrate(f6, a6, b6, h6, NumericalIntegration.TypeMethod.SIMPSON_METHOD);
        double tolerance = service.tolerance(f6, a6, b6, h6, NumericalIntegration.TypeMethod.SIMPSON_METHOD);
        assertEquals(0, actualValue, PRECISION);
        assertEquals(0.00261852766212, tolerance, PRECISION);
        assertEquals(0, actualValue, tolerance);
    }

    @Test
    void testTrapezoidMethod_f6() {
        double actualValue = service.integrate(f6, a6, b6, h6, NumericalIntegration.TypeMethod.TRAPEZOID_METHOD);
        double tolerance = service.tolerance(f6, a6, b6, h6, NumericalIntegration.TypeMethod.TRAPEZOID_METHOD);
        assertEquals(0, actualValue, PRECISION);
        assertEquals(0, tolerance, PRECISION);
        assertEquals(0, actualValue, tolerance);
    }
}