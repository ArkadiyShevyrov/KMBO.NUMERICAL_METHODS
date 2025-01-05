package ru.kmbo.numerical_methods.labs.lab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kmbo.numerical_methods.core.calculate.PolynomialCalculate;
import ru.kmbo.numerical_methods.core.model.function.implementation.TabularFunction;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Lab_1_5_Test {

    private static final Logger log = LoggerFactory.getLogger(Lab_1_5_Test.class);
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
        Double actualValue = PolynomialCalculate.getPointFunction(function1, 1., 4);
        assertEquals(0.5, actualValue, 1e-2);
    }

    @Test
    void testLagrangeInterpolate2() {
        Double actualValue = PolynomialCalculate.getPointFunction(function2, 1., 4);
        assertEquals(0.86603, actualValue, 1e-2);
    }

    @Test
    void testLagrangeInterpolate3() {
        Double actualValue = PolynomialCalculate.getPointFunction(function3, 0.9, 3);
        assertEquals(0.36892, actualValue, 1e-0);
    }

    @Test
    void testLagrangeInterpolate4() {
        Double actualValue = PolynomialCalculate.getPointFunction(function4, 2.8, 5);
        assertEquals(0.50953, actualValue, 1e-2);
    }

    @Test
    void testLagrangeInterpolate5() {
        Double actualValue = PolynomialCalculate.getPointFunction(function5, 0.9, 5);
        assertEquals(-0.10536, actualValue, 1e-2);
    }

    @Test
    void testLagrangeInterpolate6() {
        Double actualValue = PolynomialCalculate.getPointFunction(function6, -1.0, 4);
        assertEquals(0.36788, actualValue, 1e-1);
    }


//    @Test
//    void testLagrangeInterpolate31() {
//        Double actualValue1 = PolynomialCalculate.sum(function3, 0.9, 1);
//        Double actualValue2 = PolynomialCalculate.sum(function3, 0.9, 2);
//        Double actualValue3 = PolynomialCalculate.sum(function3, 0.9, 3);
//        Polynomial polynomial1 = PolynomialCalculate.polynomial(function3, 0.9, 1);
//        Polynomial polynomial2 = PolynomialCalculate.polynomial(function3, 0.9, 2);
//        Polynomial polynomial3 = PolynomialCalculate.polynomial(function3, 0.9, 3);
//        assertEquals(8.679022395367621, actualValue1, 1e-2);
//        assertEquals(2.355748702034285, actualValue2, 1e-2);
//        assertEquals(0.3557288768253966, actualValue3, 1e-2);
//        log.info(actualValue1.toString());
//        log.info(actualValue2.toString());
//        log.info(actualValue3.toString());
//        log.info(String.valueOf(polynomial1));
//        log.info(String.valueOf(polynomial2));
//        log.info(String.valueOf(polynomial3));
//
//    }

}
