package ru.kmbo.numerical_methods.lab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.kmbo.numerical_methods.calculate.CubicSplineInterpolatorCalculate;
import ru.kmbo.numerical_methods.model.basic.FunctionalOption;
import ru.kmbo.numerical_methods.model.basic.Point;
import ru.kmbo.numerical_methods.model.function.TabularFunction;
import ru.kmbo.numerical_methods.service.lab_logic.L_1_5_Logic;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.kmbo.numerical_methods.constant.Constant.PRECISION;

public class Lab_1_5_Test {

    private TabularFunction function1;
    private TabularFunction function2;
    private TabularFunction function3;
    private TabularFunction function4;
    private TabularFunction function5;
    private TabularFunction function6;

    @BeforeEach
    void setUp() {
        function1 = new TabularFunction(Map.of(
                -1.0, -0.5,
                0.0, 0.0,
                1.0, 0.5,
                2.0, 0.86603,
                3.0, 1.0,
                4.0, 0.86603
        ));

        function2 = new TabularFunction(Map.of(
                -1.0, 0.86603,
                0.0, 1.0,
                1.0, 0.86603,
                2.0, 0.50,
                3.0, 0.0,
                4.0, -0.50
        ));

        function3 = new TabularFunction(Map.of(
                -0.9, -0.36892,
                0.0, 0.0,
                0.9, 0.36892,
                1.8, 0.85408,
                2.7, 1.7856,
                3.6, 6.3138
        ));

        function4 = new TabularFunction(Map.of(
                1.0, 2.4142,
                1.9, 1.0818,
                2.8, 0.50953,
                3.7, 0.11836,
                4.6, -0.24008,
                5.5, -0.66818
        ));

        function5 = new TabularFunction(Map.of(
                0.1, -2.3026,
                0.5, -0.69315,
                0.9, -0.10536,
                1.3, 0.26236,
                1.7, 0.53063,
                2.1, 0.74194
        ));

        function6 = new TabularFunction(Map.of(
                -3.0, 0.04979,
                -2.0, 0.13534,
                -1.0, 0.36788,
                0.0, 1.0,
                1.0, 2.7183,
                2.0, 7.3891
        ));
    }

    @Test
    void testLagrangeInterpolate1() {
        TabularFunction function0 = new TabularFunction(Map.of(
                0.0, 0.0,
                1.0, 1.,
                2.0, 2.,
                3.0, 3.0,
                4.0, 4.
        ));
        FunctionalOption functionalOption = new FunctionalOption(0, 5, 0.5);
        List<Point> pointFunction = L_1_5_Logic.getPointFunction(function0, functionalOption, 3);
        System.out.println();
//        double actualValue = (double) pointFunction;
//        assertEquals(0.7262375669642858, actualValue, PRECISION);
    }

}
