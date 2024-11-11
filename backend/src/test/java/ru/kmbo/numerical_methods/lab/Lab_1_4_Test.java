package ru.kmbo.numerical_methods.lab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.kmbo.numerical_methods.calculate.CubicSplineInterpolatorCalculate;
import ru.kmbo.numerical_methods.model.function.implementation.TabularFunction;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Lab_1_4_Test {

    private TabularFunction function1;
    private Double xStar1;
    private TabularFunction function2;
    private Double xStar2;
    private TabularFunction function3;
    private Double xStar3;
    private TabularFunction function4;
    private Double xStar4;
    private TabularFunction function5;
    private Double xStar5;
    private TabularFunction function6;
    private Double xStar6;

    @BeforeEach
    void setUp() {
        function1 = new TabularFunction(Map.of(
                0.0, 0.0,
                1.0, 0.5,
                2.0, 0.86603,
                3.0, 1.0,
                4.0, 0.86603
        ));
        xStar1 = 1.5;

        function2 = new TabularFunction(Map.of(
                0.0, 1.0,
                1.0, 0.86603,
                2.0, 0.5,
                3.0, 0.0,
                4.0, -0.5
        ));
        xStar2 = 1.5;

        function3 = new TabularFunction(Map.of(
                0.0, 0.0,
                0.9, 0.26892,
                1.8, 0.85408,
                2.7, 0.7856,
                3.6, 6.3138
        ));
        xStar3 = 1.5;

        function4 = new TabularFunction(Map.of(
                1.0, 2.4142,
                1.9, 1.0818,
                2.8, 0.50953,
                3.7, 0.11836,
                4.6, -0.24008
        ));
        xStar4 = 2.66666;

        function5 = new TabularFunction(Map.of(
                0.1, -2.3026,
                0.5, -0.69315,
                0.9, -0.10536,
                1.3, 0.26236,
                1.7, 0.53063
        ));
        xStar5 = 0.8;

        function6 = new TabularFunction(Map.of(
                -2.0, 0.13534,
                -1.0, 0.36788,
                0.0, 1.0,
                1.0, 2.7183,
                2.0, 7.3891
        ));
        xStar6 = 0.2;
    }

    @Test
    void testLagrangeInterpolate1() {
        double actualValue = CubicSplineInterpolatorCalculate.evaluateSpline(function1, xStar1);
        assertEquals(0.7262375669642858, actualValue, 1e-1);
    }

    @Test
    void testLagrangeInterpolate2() {
        double actualValue = CubicSplineInterpolatorCalculate.evaluateSpline(function2, xStar2);
        assertEquals(0.7019029464285714, actualValue, 1e-1);
    }

    @Test
    void testLagrangeInterpolate3() {
        double actualValue = CubicSplineInterpolatorCalculate.evaluateSpline(function3, xStar3);
        assertEquals(0.9015021693121694, actualValue, 1e-1);
    }

    @Test
    void testLagrangeInterpolate4() {
        double actualValue = CubicSplineInterpolatorCalculate.evaluateSpline(function4, xStar4);
        assertEquals(0.5456161103234621, actualValue, 1e-1);
    }

    @Test
    void testLagrangeInterpolate5() {
        double actualValue = CubicSplineInterpolatorCalculate.evaluateSpline(function5, xStar5);
        assertEquals(-0.15223525948660716, actualValue, 1e-1);
    }

    @Test
    void testLagrangeInterpolate6() {
        double actualValue = CubicSplineInterpolatorCalculate.evaluateSpline(function6, xStar6);
        assertEquals(1.0879613257142857, actualValue, 1e-1);
    }
}
