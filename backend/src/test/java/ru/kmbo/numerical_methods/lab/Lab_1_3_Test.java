package ru.kmbo.numerical_methods.lab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.kmbo.numerical_methods.calculate.InterpolationCalculate;
import ru.kmbo.numerical_methods.model.function.TabularFunction;
import ru.kmbo.numerical_methods.model.operand.*;
import ru.kmbo.numerical_methods.model.operand.Num;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.kmbo.numerical_methods.constant.Constant.PI;
import static ru.kmbo.numerical_methods.constant.Constant.PRECISION;

public class Lab_1_3_Test {


    private TabularFunction function1;
    private final Num num1 = new Num();
    private Double xStar1;
    private TabularFunction function2;
    private final Num num2 = new Num();
    private Double xStar2;
    private TabularFunction function3;
    private final Num num3 = new Num();
    private Double xStar3;
    private TabularFunction function4;
    private final Num num4 = new Num();
    private Double xStar4;
    private TabularFunction function5;
    private final Num num5 = new Num();
    private Double xStar5;
    private TabularFunction function6;
    private final Num num6 = new Num();
    private Double xStar6;


    @BeforeEach
    void setUp() {

        function1 = new TabularFunction(
                new double[]{0.1 * PI, 0.2 * PI, 0.3 * PI, 0.4 * PI},
                new Sin(num1),
                num1
        );
        xStar1 = PI / 4;

        function2 = new TabularFunction(
                new double[]{0, PI / 6, 2 * PI / 6, 3 * PI / 6},
                new Cos(num2),
                num2
        );
        xStar2 = PI / 4;

        function3 = new TabularFunction(
                new double[]{-2, -1, 0, 1},
                new Exp(num3),
                num3
        );
        xStar3 = -0.5;

        function4 = new TabularFunction(
                new double[]{0, 1.7, 3.4, 5.1},
                new Sqrt(num4),
                num4
        );
        xStar4 = 3.0;

        function5 = new TabularFunction(
                new double[]{0, PI / 6, 2 * PI / 6, 3 * PI / 6},
                new Multiply(
                        num5,
                        new Sin(num5)
                ),
                num5
        );
        xStar5 = PI / 4;

        function6 = new TabularFunction(
                new double[]{-1.2, -0.7, -0.2, 0.3},
                new Multiply(
                        new Pow(
                                num6,
                                2
                        ),
                        new Exp(num6)
                ),
                num6
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
}
