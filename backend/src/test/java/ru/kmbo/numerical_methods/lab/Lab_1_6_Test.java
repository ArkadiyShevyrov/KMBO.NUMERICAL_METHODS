package ru.kmbo.numerical_methods.lab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.kmbo.numerical_methods.calculate.integration.numeral.one_dimensional.NumericalIntegration;
import ru.kmbo.numerical_methods.model.function.implementation.OperandFunction;
import ru.kmbo.numerical_methods.model.operand.*;
import ru.kmbo.numerical_methods.model.operand.implementation.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.kmbo.numerical_methods.constant.Constant.PRECISION;

public class Lab_1_6_Test {
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
    void test1() {
        double actualValueRL = NumericalIntegration.integrate(f1, a1, b1, h1, NumericalIntegration.TypeMethod.RECTANGLE_LEFT_METHOD);
        double toleranceRL = NumericalIntegration.tolerance(f1, a1, b1, h1, NumericalIntegration.TypeMethod.RECTANGLE_LEFT_METHOD);
        assertEquals(-0.1875, actualValueRL, PRECISION);
        assertEquals(0.2777777777777778, toleranceRL, PRECISION);
        assertEquals(-0.0591223, actualValueRL, toleranceRL);

        double actualValueRM = NumericalIntegration.integrate(f1, a1, b1, h1, NumericalIntegration.TypeMethod.RECTANGLE_MEDIAN_METHOD);
        double toleranceRM = NumericalIntegration.tolerance(f1, a1, b1, h1, NumericalIntegration.TypeMethod.RECTANGLE_MEDIAN_METHOD);
        assertEquals(-0.05450105450105448, actualValueRM, PRECISION);
        assertEquals(0.030864197530864196, toleranceRM, PRECISION);
        assertEquals(-0.0591223, actualValueRM, toleranceRM);

        double actualValueRR = NumericalIntegration.integrate(f1, a1, b1, h1, NumericalIntegration.TypeMethod.RECTANGLE_RIGHT_METHOD);
        double toleranceRR = NumericalIntegration.tolerance(f1, a1, b1, h1, NumericalIntegration.TypeMethod.RECTANGLE_RIGHT_METHOD);
        assertEquals(0.05059523809523809, actualValueRR, PRECISION);
        assertEquals(0.2777777777777778, toleranceRR, PRECISION);
        assertEquals(-0.0591223, actualValueRR, toleranceRR);

        double actualValueS = NumericalIntegration.integrate(f1, a1, b1, h1, NumericalIntegration.TypeMethod.SIMPSON_METHOD);
        double toleranceS = NumericalIntegration.tolerance(f1, a1, b1, h1, NumericalIntegration.TypeMethod.SIMPSON_METHOD);
        assertEquals(-0.05952380952380952, actualValueS, PRECISION);
        assertEquals(0.0027434842249657062, toleranceS, PRECISION);
        assertEquals(-0.0591223, actualValueS, toleranceS);

        double actualValueT = NumericalIntegration.integrate(f1, a1, b1, h1, NumericalIntegration.TypeMethod.TRAPEZOID_METHOD);
        double toleranceT = NumericalIntegration.tolerance(f1, a1, b1, h1, NumericalIntegration.TypeMethod.TRAPEZOID_METHOD);
        assertEquals(-0.06845238095238096, actualValueT, PRECISION);
        assertEquals(0.018896447469043027, toleranceT, PRECISION);
        assertEquals(-0.0591223, actualValueT, toleranceT);
    }

    @Test
    void test2() {
        double actualValueRL = NumericalIntegration.integrate(f2, a2, b2, h2, NumericalIntegration.TypeMethod.RECTANGLE_LEFT_METHOD);
        double toleranceRL = NumericalIntegration.tolerance(f2, a2, b2, h2, NumericalIntegration.TypeMethod.RECTANGLE_LEFT_METHOD);
        assertEquals(0.05815964255524695, actualValueRL, PRECISION);
        assertEquals(0.125, toleranceRL, PRECISION);
        assertEquals(0.0706994, actualValueRL, toleranceRL);

        double actualValueRM = NumericalIntegration.integrate(f2, a2, b2, h2, NumericalIntegration.TypeMethod.RECTANGLE_MEDIAN_METHOD);
        double toleranceRM = NumericalIntegration.tolerance(f2, a2, b2, h2, NumericalIntegration.TypeMethod.RECTANGLE_MEDIAN_METHOD);
        assertEquals(0.07284061196629331, actualValueRM, PRECISION);
        assertEquals(0.03125, toleranceRM, PRECISION);
        assertEquals(0.0706994, actualValueRM, toleranceRM);

        double actualValueRR = NumericalIntegration.integrate(f2, a2, b2, h2, NumericalIntegration.TypeMethod.RECTANGLE_RIGHT_METHOD);
        double toleranceRR = NumericalIntegration.tolerance(f2, a2, b2, h2, NumericalIntegration.TypeMethod.RECTANGLE_RIGHT_METHOD);
        assertEquals(0.07378464255524694, actualValueRR, PRECISION);
        assertEquals(0.125, toleranceRR, PRECISION);
        assertEquals(0.0706994, actualValueRR, toleranceRR);

        double actualValueS = NumericalIntegration.integrate(f2, a2, b2, h2, NumericalIntegration.TypeMethod.SIMPSON_METHOD);
        double toleranceS = NumericalIntegration.tolerance(f2, a2, b2, h2, NumericalIntegration.TypeMethod.SIMPSON_METHOD);
        assertEquals(0.0694211900736626, actualValueS, PRECISION);
        assertEquals(0.05625, toleranceS, PRECISION);
        assertEquals(0.0706994, actualValueS, toleranceS);

        double actualValueT = NumericalIntegration.integrate(f2, a2, b2, h2, NumericalIntegration.TypeMethod.TRAPEZOID_METHOD);
        double toleranceT = NumericalIntegration.tolerance(f2, a2, b2, h2, NumericalIntegration.TypeMethod.TRAPEZOID_METHOD);
        assertEquals(0.06597214255524694, actualValueT, PRECISION);
        assertEquals(0.021484375003519893, toleranceT, PRECISION);
        assertEquals(0.0706994, actualValueT, toleranceT);
    }

    @Test
    void test3() {
        double actualValueRL = NumericalIntegration.integrate(f3, a3, b3, h3, NumericalIntegration.TypeMethod.RECTANGLE_LEFT_METHOD);
        double toleranceRL = NumericalIntegration.tolerance(f3, a3, b3, h3, NumericalIntegration.TypeMethod.RECTANGLE_LEFT_METHOD);
        assertEquals(-0.5144973703981969, actualValueRL, PRECISION);
        assertEquals(5.0, toleranceRL, PRECISION);
        assertEquals(-0.12245, actualValueRL, toleranceRL);

        double actualValueRM = NumericalIntegration.integrate(f3, a3, b3, h3, NumericalIntegration.TypeMethod.RECTANGLE_MEDIAN_METHOD);
        double toleranceRM = NumericalIntegration.tolerance(f3, a3, b3, h3, NumericalIntegration.TypeMethod.RECTANGLE_MEDIAN_METHOD);
        assertEquals(-0.07090982378616856, actualValueRM, PRECISION);
        assertEquals(5.25, toleranceRM, PRECISION);
        assertEquals(-0.12245, actualValueRM, toleranceRM);

        double actualValueRR = NumericalIntegration.integrate(f3, a3, b3, h3, NumericalIntegration.TypeMethod.RECTANGLE_RIGHT_METHOD);
        double toleranceRR = NumericalIntegration.tolerance(f3, a3, b3, h3, NumericalIntegration.TypeMethod.RECTANGLE_RIGHT_METHOD);
        assertEquals(-0.013039644450674978, actualValueRR, PRECISION);
        assertEquals(5.0, toleranceRR, PRECISION);
        assertEquals(-0.12245, actualValueRR, toleranceRR);

        double actualValueS = NumericalIntegration.integrate(f3, a3, b3, h3, NumericalIntegration.TypeMethod.SIMPSON_METHOD);
        double toleranceS = NumericalIntegration.tolerance(f3, a3, b3, h3, NumericalIntegration.TypeMethod.SIMPSON_METHOD);
        assertEquals(-0.18551058521508848, actualValueS, PRECISION);
        assertEquals(24.75, toleranceS, PRECISION);
        assertEquals(-0.12245, actualValueS, toleranceS);

        double actualValueT = NumericalIntegration.integrate(f3, a3, b3, h3, NumericalIntegration.TypeMethod.TRAPEZOID_METHOD);
        double toleranceT = NumericalIntegration.tolerance(f3, a3, b3, h3, NumericalIntegration.TypeMethod.TRAPEZOID_METHOD);
        assertEquals(-0.2637685074244359, actualValueT, PRECISION);
        assertEquals(0.4167013744273219, toleranceT, PRECISION);
        assertEquals(-0.12245, actualValueT, toleranceT);
    }

    @Test
    void test4() {
        double actualValueRL = NumericalIntegration.integrate(f4, a4, b4, h4, NumericalIntegration.TypeMethod.RECTANGLE_LEFT_METHOD);
        double toleranceRL = NumericalIntegration.tolerance(f4, a4, b4, h4, NumericalIntegration.TypeMethod.RECTANGLE_LEFT_METHOD);
        assertEquals(0.8825396825396825, actualValueRL, PRECISION);
        assertEquals(2.888888888888889, toleranceRL, PRECISION);
        assertEquals(1.77733, actualValueRL, toleranceRL);

        double actualValueRM = NumericalIntegration.integrate(f4, a4, b4, h4, NumericalIntegration.TypeMethod.RECTANGLE_MEDIAN_METHOD);
        double toleranceRM = NumericalIntegration.tolerance(f4, a4, b4, h4, NumericalIntegration.TypeMethod.RECTANGLE_MEDIAN_METHOD);
        assertEquals(1.8291666666666666, actualValueRM, PRECISION);
        assertEquals(0.32098765432098764, toleranceRM, PRECISION);
        assertEquals(1.77733, actualValueRM, toleranceRM);

        double actualValueRR = NumericalIntegration.integrate(f4, a4, b4, h4, NumericalIntegration.TypeMethod.RECTANGLE_RIGHT_METHOD);
        double toleranceRR = NumericalIntegration.tolerance(f4, a4, b4, h4, NumericalIntegration.TypeMethod.RECTANGLE_RIGHT_METHOD);
        assertEquals(2.458297258297258, actualValueRR, PRECISION);
        assertEquals(2.888888888888889, toleranceRR, PRECISION);
        assertEquals(1.77733, actualValueRR, toleranceRR);

        double actualValueS = NumericalIntegration.integrate(f4, a4, b4, h4, NumericalIntegration.TypeMethod.SIMPSON_METHOD);
        double toleranceS = NumericalIntegration.tolerance(f4, a4, b4, h4, NumericalIntegration.TypeMethod.SIMPSON_METHOD);
        assertEquals(1.7654641654641656, actualValueS, PRECISION);
        assertEquals(0.22825788751714676, toleranceS, PRECISION);
        assertEquals(1.77733, actualValueS, toleranceS);

        double actualValueT = NumericalIntegration.integrate(f4, a4, b4, h4, NumericalIntegration.TypeMethod.TRAPEZOID_METHOD);
        double toleranceT = NumericalIntegration.tolerance(f4, a4, b4, h4, NumericalIntegration.TypeMethod.TRAPEZOID_METHOD);
        assertEquals(1.6704184704184701, actualValueT, PRECISION);
        assertEquals(0.4456688093290583, toleranceT, PRECISION);
        assertEquals(1.77733, actualValueT, toleranceT);
    }

    @Test
    void test5() {
        double actualValueRL = NumericalIntegration.integrate(f5, a5, b5, h5, NumericalIntegration.TypeMethod.RECTANGLE_LEFT_METHOD);
        double toleranceRL = NumericalIntegration.tolerance(f5, a5, b5, h5, NumericalIntegration.TypeMethod.RECTANGLE_LEFT_METHOD);
        assertEquals(0.7749999999999999, actualValueRL, PRECISION);
        assertEquals(0.16, toleranceRL, PRECISION);
        assertEquals(0.785398, actualValueRL, toleranceRL);

        double actualValueRM = NumericalIntegration.integrate(f5, a5, b5, h5, NumericalIntegration.TypeMethod.RECTANGLE_MEDIAN_METHOD);
        double toleranceRM = NumericalIntegration.tolerance(f5, a5, b5, h5, NumericalIntegration.TypeMethod.RECTANGLE_MEDIAN_METHOD);
        assertEquals(0.79058823529411774, actualValueRM, PRECISION);
        assertEquals(0.020833333333333332, toleranceRM, PRECISION);
        assertEquals(0.785398, actualValueRM, toleranceRM);

        double actualValueRR = NumericalIntegration.integrate(f5, a5, b5, h5, NumericalIntegration.TypeMethod.RECTANGLE_RIGHT_METHOD);
        double toleranceRR = NumericalIntegration.tolerance(f5, a5, b5, h5, NumericalIntegration.TypeMethod.RECTANGLE_RIGHT_METHOD);
        assertEquals(0.775, actualValueRR, PRECISION);
        assertEquals(0.16, toleranceRR, PRECISION);
        assertEquals(0.785398, actualValueRR, toleranceRR);

        double actualValueS = NumericalIntegration.integrate(f5, a5, b5, h5, NumericalIntegration.TypeMethod.SIMPSON_METHOD);
        double toleranceS = NumericalIntegration.tolerance(f5, a5, b5, h5, NumericalIntegration.TypeMethod.SIMPSON_METHOD);
        assertEquals(0.7833333333333333, actualValueS, PRECISION);
        assertEquals(0.008333333333333333, toleranceS, PRECISION);
        assertEquals(0.785398, actualValueS, toleranceS);
        double actualValueT = NumericalIntegration.integrate(f5, a5, b5, h5, NumericalIntegration.TypeMethod.TRAPEZOID_METHOD);
        double toleranceT = NumericalIntegration.tolerance(f5, a5, b5, h5, NumericalIntegration.TypeMethod.TRAPEZOID_METHOD);
        assertEquals(0.775, actualValueT, PRECISION);
        assertEquals(0.041666666666939634, toleranceT, PRECISION);
        assertEquals(0.785398, actualValueT, toleranceT);
    }

    @Test
    void test6() {
        double actualValueRL = NumericalIntegration.integrate(f6, a6, b6, h6, NumericalIntegration.TypeMethod.RECTANGLE_LEFT_METHOD);
        double toleranceRL = NumericalIntegration.tolerance(f6, a6, b6, h6, NumericalIntegration.TypeMethod.RECTANGLE_LEFT_METHOD);
        assertEquals(-13.416407864998742, actualValueRL, PRECISION);
        assertEquals(14, toleranceRL, PRECISION);
        assertEquals(0, actualValueRL, toleranceRL);

        double actualValueRM = NumericalIntegration.integrate(f6, a6, b6, h6, NumericalIntegration.TypeMethod.RECTANGLE_MEDIAN_METHOD);
        double toleranceRM = NumericalIntegration.tolerance(f6, a6, b6, h6, NumericalIntegration.TypeMethod.RECTANGLE_MEDIAN_METHOD);
        assertEquals(0, actualValueRM, PRECISION);
        assertEquals(1.0, toleranceRM, PRECISION);
        assertEquals(0, actualValueRM, toleranceRM);

        double actualValueRR = NumericalIntegration.integrate(f6, a6, b6, h6, NumericalIntegration.TypeMethod.RECTANGLE_RIGHT_METHOD);
        double toleranceRR = NumericalIntegration.tolerance(f6, a6, b6, h6, NumericalIntegration.TypeMethod.RECTANGLE_RIGHT_METHOD);
        assertEquals(13.416407864998739, actualValueRR, PRECISION);
        assertEquals(14, toleranceRR, PRECISION);
        assertEquals(0, actualValueRR, toleranceRR);

        double actualValueS = NumericalIntegration.integrate(f6, a6, b6, h6, NumericalIntegration.TypeMethod.SIMPSON_METHOD);
        double toleranceS = NumericalIntegration.tolerance(f6, a6, b6, h6, NumericalIntegration.TypeMethod.SIMPSON_METHOD);
        assertEquals(0, actualValueS, PRECISION);
        assertEquals(0., toleranceS, PRECISION);
        assertEquals(0, actualValueS, toleranceS);

        double actualValueT = NumericalIntegration.integrate(f6, a6, b6, h6, NumericalIntegration.TypeMethod.TRAPEZOID_METHOD);
        double toleranceT = NumericalIntegration.tolerance(f6, a6, b6, h6, NumericalIntegration.TypeMethod.TRAPEZOID_METHOD);
        assertEquals(0, actualValueT, PRECISION);
        assertEquals(0, toleranceT, PRECISION);
        assertEquals(0, actualValueT, toleranceT);
    }
}
