package ru.kmbo.numerical_methods.labs.lab;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.kmbo.numerical_methods.core.calculate.InterpolationCalculate;
import ru.kmbo.numerical_methods.core.calculate.PolynomialCalculate;
import ru.kmbo.numerical_methods.core.model.function.Polynomial;
import ru.kmbo.numerical_methods.core.model.function.implementation.OperandFunction;
import ru.kmbo.numerical_methods.core.model.function.implementation.TabularFunction;
import ru.kmbo.numerical_methods.core.model.operand.implementation.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.kmbo.numerical_methods.core.constant.Constant.PI;
import static ru.kmbo.numerical_methods.core.constant.Constant.PRECISION;

@Slf4j
public class Lab_1_3_Test {


    private TabularFunction function1;
    private final Variable var1 = new Variable("x");
    private Double xStar1;
    private TabularFunction function2;
    private final Variable var2 = new Variable("x");
    private Double xStar2;
    private TabularFunction function3;
    private final Variable var3 = new Variable("x");
    private Double xStar3;
    private TabularFunction function4;
    private final Variable var4 = new Variable("x");
    private Double xStar4;
    private TabularFunction function5;
    private final Variable var5 = new Variable("x");
    private Double xStar5;
    private TabularFunction function6;
    private final Variable var6 = new Variable("x");
    private Double xStar6;


    @BeforeEach
    void setUp() {

        function1 = new TabularFunction(
                new double[]{0.1 * PI, 0.2 * PI, 0.3 * PI, 0.4 * PI},
                new OperandFunction(
                        new Sin(var1),
                        var1
                )
        );
        xStar1 = PI / 4;

        function2 = new TabularFunction(
                new double[]{0, PI / 6, 2 * PI / 6, 3 * PI / 6},
                new OperandFunction(
                        new Cos(var2),
                        var2
                )
        );
        xStar2 = PI / 4;

        function3 = new TabularFunction(
                new double[]{-2, -1, 0, 1},
                new OperandFunction(
                        new Exp(var3),
                        var3
                )
        );
        xStar3 = -0.5;

        function4 = new TabularFunction(
                new double[]{0, 1.7, 3.4, 5.1},
                new OperandFunction(
                        new Pow(var4, 0.5),
                        var4
                )
        );
        xStar4 = 3.0;

        function5 = new TabularFunction(
                new double[]{0, PI / 6, 2 * PI / 6, 3 * PI / 6},
                new OperandFunction(
                        new Multiply(
                                var5,
                                new Sin(var5)
                        ),
                        var5
                )
        );
        xStar5 = PI / 4;

        function6 = new TabularFunction(
                new double[]{-1.2, -0.7, -0.2, 0.3},
                new OperandFunction(
                        new Multiply(
                                new Pow(
                                        var6,
                                        2
                                ),
                                new Exp(var6)
                        ),
                        var6
                )
        );
        xStar6 = -0.5;
    }

    @Test
    void testLagrangeInterpolate1() {
        double actualValue = InterpolationCalculate.lagrangeInterpolate(function1, xStar1);
        assertEquals(0.70694666935, actualValue, PRECISION);
    }

    @Test
    void testNewtonInterpolate1() {
        double actualValue = InterpolationCalculate.newtonInterpolate(function1, xStar1);
        assertEquals(0.70694666935, actualValue, PRECISION);
    }

    @Test
    void testLagrangeInterpolate2() {
        double actualValue = InterpolationCalculate.lagrangeInterpolate(function2, xStar2);
        assertEquals(0.7058892896375, actualValue, PRECISION);
    }

    @Test
    void testNewtonInterpolate2() {
        double actualValue = InterpolationCalculate.newtonInterpolate(function2, xStar2);
        assertEquals(0.7058892896375, actualValue, PRECISION);
    }

    @Test
    void testLagrangeInterpolate3() {
        double actualValue = InterpolationCalculate.lagrangeInterpolate(function3, xStar3);
        assertEquals(0.59108111619375, actualValue, PRECISION);
    }

    @Test
    void testNewtonInterpolate3() {
        double actualValue = InterpolationCalculate.newtonInterpolate(function3, xStar3);
        assertEquals(0.59108111619375, actualValue, PRECISION);
    }

    @Test
    void testLagrangeInterpolate4() {
        double actualValue = InterpolationCalculate.lagrangeInterpolate(function4, xStar4);
        assertEquals(1.751777579385479, actualValue, PRECISION);
    }

    @Test
    void testNewtonInterpolate4() {
        double actualValue = InterpolationCalculate.newtonInterpolate(function4, xStar4);
        assertEquals(1.751777579385479, actualValue, PRECISION);
    }

    @Test
    void testLagrangeInterpolate5() {
        double actualValue = InterpolationCalculate.lagrangeInterpolate(function5, xStar5);
        assertEquals(0.5592184564123807, actualValue, PRECISION);
    }

    @Test
    void testNewtonInterpolate5() {
        double actualValue = InterpolationCalculate.newtonInterpolate(function5, xStar5);
        assertEquals(0.5592184564123807, actualValue, PRECISION);
    }

    @Test
    void testLagrangeInterpolate6() {
        double actualValue = InterpolationCalculate.lagrangeInterpolate(function6, xStar6);
        assertEquals(0.14362591697180802, actualValue, PRECISION);
    }

    @Test
    void testNewtonInterpolate6() {
        double actualValue = InterpolationCalculate.newtonInterpolate(function6, xStar6);
        assertEquals(0.14362591697180802, actualValue, PRECISION);
    }


//    @Test
//    void testLagrangeInterpolate31() {
//        double actualValue = PolynomialCalculate.getPointFunction(function3, xStar3, 3);
//        Double sum = PolynomialCalculate.b(function3, xStar3, 3);
//        Polynomial polynomial1 = PolynomialCalculate.polynomial(function3, xStar3, 3);
//        log.info(String.valueOf(actualValue));
//        log.info(String.valueOf(sum));
//        log.info(String.valueOf(polynomial1));
//    }

}
