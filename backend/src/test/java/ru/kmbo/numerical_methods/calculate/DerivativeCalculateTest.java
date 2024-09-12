package ru.kmbo.numerical_methods.calculate;

import org.junit.jupiter.api.Test;
import ru.kmbo.numerical_methods.model.function.TabularFunction;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DerivativeCalculateTest {

    @Test
    void test11() {
        TabularFunction tabularFunction = new TabularFunction(Map.of(
                -1.0, -0.5,
                0.0, 0.0,
                1.0, 0.5,
                2.0, 0.86603,
                3.0, 1.0
        ));

        Double result = DerivativeCalculate.firstDerivative(tabularFunction, 1.0);
        assertEquals(0.433015, result, 1e-6);
    }

    @Test
    void test12() {
        TabularFunction tabularFunction = new TabularFunction(Map.of(
                -1.0, -0.5,
                0.0, 0.0,
                1.0, 0.5,
                2.0, 0.86603,
                3.0, 1.0
        ));

        Double result = DerivativeCalculate.secondDerivative(tabularFunction, 1.0);
        assertEquals(-0.13397, result, 1e-6);
    }

    @Test
    void test21() {
        TabularFunction tabularFunction = new TabularFunction(Map.of(
                1.0, 0.0,
                1.5, 0.40547,
                2.0, 0.69315,
                2.5, 0.91629,
                3.0, 1.0986
        ));

        Double result = DerivativeCalculate.firstDerivative(tabularFunction, 2.0);
        assertEquals(0.51082, result, 1e-6);
    }

    @Test
    void test22() {
        TabularFunction tabularFunction = new TabularFunction(Map.of(
                1.0, 0.0,
                1.5, 0.40547,
                2.0, 0.69315,
                2.5, 0.91629,
                3.0, 1.0986
        ));

        Double result = DerivativeCalculate.secondDerivative(tabularFunction, 2.0);
        assertEquals(-0.25816, result, 1e-6);
    }

    @Test
    void test31() {
        TabularFunction tabularFunction = new TabularFunction(Map.of(
                0.0, 1.0,
                0.1, 1.1052,
                0.2, 1.2214,
                0.3, 1.3499,
                0.4, 1.4918
        ));

        Double result = DerivativeCalculate.firstDerivative(tabularFunction, 0.2);
        assertEquals(1.2235, result, 1e-6);
    }

    @Test
    void test32() {
        TabularFunction tabularFunction = new TabularFunction(Map.of(
                0.0, 1.0,
                0.1, 1.1052,
                0.2, 1.2214,
                0.3, 1.3499,
                0.4, 1.4918
        ));

        Double result = DerivativeCalculate.secondDerivative(tabularFunction, 0.2);
        assertEquals(1.23, result, 1e-6);
    }

    @Test
    void test41() {
        TabularFunction tabularFunction = new TabularFunction(Map.of(
                0.0, 0.0,
                1.0, 1.0,
                2.0, 1.4142,
                3.0, 1.7321,
                4.0, 2.0
        ));

        Double result = DerivativeCalculate.firstDerivative(tabularFunction, 2.0);
        assertEquals(0.36605, result, 1e-6);
    }

    @Test
    void test42() {
        TabularFunction tabularFunction = new TabularFunction(Map.of(
                0.0, 0.0,
                1.0, 1.0,
                2.0, 1.4142,
                3.0, 1.7321,
                4.0, 2.0
        ));

        Double result = DerivativeCalculate.secondDerivative(tabularFunction, 2.0);
        assertEquals(-0.0963, result, 1e-6);
    }

    @Test
    void test51() {
        TabularFunction tabularFunction = new TabularFunction(Map.of(
                -0.2, -0.20136,
                0.0, 0.0,
                0.2, 0.20136,
                0.4, 0.41152,
                0.6, 0.6435
        ));
        Double result = DerivativeCalculate.firstDerivative(tabularFunction, 0.2);
        assertEquals(1.0288, result, 1e-6);
    }

    @Test
    void test52() {
        TabularFunction tabularFunction = new TabularFunction(Map.of(
                -0.2, -0.20136,
                0.0, 0.0,
                0.2, 0.20136,
                0.4, 0.41152,
                0.6, 0.6435
        ));
        Double result = DerivativeCalculate.secondDerivative(tabularFunction, 0.2);
        assertEquals(0.22, result, 1e-6);
    }

    @Test
    void test61() {
        TabularFunction tabularFunction = new TabularFunction(Map.of(
                -0.2, 1.7722,
                0.0, 1.5708,
                0.2, 1.3694,
                0.4, 1.1593,
                0.6, 0.9273
        ));

        Double result = DerivativeCalculate.firstDerivative(tabularFunction, 0.2);
        assertEquals(-1.02875, result, 1e-6);
    }

    @Test
    void test62() {
        TabularFunction tabularFunction = new TabularFunction(Map.of(
                -0.2, 1.7722,
                0.0, 1.5708,
                0.2, 1.3694,
                0.4, 1.1593,
                0.6, 0.9273
        ));

        Double result = DerivativeCalculate.secondDerivative(tabularFunction, 0.2);
        assertEquals(-0.2175, result, 1e-6);
    }
}
