package ru.kmbo.numerical_methods.labs.calculate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.kmbo.numerical_methods.core.calculate.TaylorCalculate;

import static org.junit.jupiter.api.Assertions.*;

class TaylorCalculateTest {

    @Test
    void testSin() {
        Assertions.assertEquals(0, TaylorCalculate.sin(0), TaylorCalculate.PRECISION);
        assertEquals(1, TaylorCalculate.sin(Math.PI / 2), TaylorCalculate.PRECISION);
        assertEquals(-1, TaylorCalculate.sin(-Math.PI / 2), TaylorCalculate.PRECISION);
        assertEquals(0, TaylorCalculate.sin(Math.PI), TaylorCalculate.PRECISION);
        assertEquals(0, TaylorCalculate.sin(2 * Math.PI), TaylorCalculate.PRECISION);
        assertThrows(IllegalArgumentException.class, () -> TaylorCalculate.sin(0, 0));
        assertEquals(Math.sin(Math.PI / 4), TaylorCalculate.sin(Math.PI / 4), TaylorCalculate.PRECISION);
        assertEquals(Math.sin(-Math.PI / 4), TaylorCalculate.sin(-Math.PI / 4), TaylorCalculate.PRECISION);
        assertEquals(Math.sin(3 * Math.PI / 4), TaylorCalculate.sin(3 * Math.PI / 4), TaylorCalculate.PRECISION);
        assertEquals(Math.sin(-3 * Math.PI / 4), TaylorCalculate.sin(-3 * Math.PI / 4), TaylorCalculate.PRECISION);
    }

    @Test
    void testCos() {
        assertEquals(1, TaylorCalculate.cos(0), TaylorCalculate.PRECISION);
        assertEquals(0, TaylorCalculate.cos(Math.PI / 2), TaylorCalculate.PRECISION);
        assertEquals(-1, TaylorCalculate.cos(Math.PI), TaylorCalculate.PRECISION);
        assertEquals(0, TaylorCalculate.cos(3 * Math.PI / 2), TaylorCalculate.PRECISION);
        assertEquals(1, TaylorCalculate.cos(2 * Math.PI), TaylorCalculate.PRECISION);
        assertThrows(IllegalArgumentException.class, () -> TaylorCalculate.cos(0, 0));
        assertEquals(Math.cos(Math.PI / 4), TaylorCalculate.cos(Math.PI / 4), TaylorCalculate.PRECISION);
        assertEquals(Math.cos(-Math.PI / 4), TaylorCalculate.cos(-Math.PI / 4), TaylorCalculate.PRECISION);
        assertEquals(Math.cos(3 * Math.PI / 4), TaylorCalculate.cos(3 * Math.PI / 4), TaylorCalculate.PRECISION);
        assertEquals(Math.cos(-3 * Math.PI / 4), TaylorCalculate.cos(-3 * Math.PI / 4), TaylorCalculate.PRECISION);
    }

    @Test
    void testExp() {
        assertEquals(1, TaylorCalculate.exp(0), TaylorCalculate.PRECISION);
        assertEquals(Math.E, TaylorCalculate.exp(1), TaylorCalculate.PRECISION);
        assertEquals(Math.exp(1), TaylorCalculate.exp(1), TaylorCalculate.PRECISION);
        assertEquals(Math.exp(-1), TaylorCalculate.exp(-1), TaylorCalculate.PRECISION);
        assertEquals(Math.exp(10), TaylorCalculate.exp(10), TaylorCalculate.PRECISION);
        assertEquals(Math.exp(-10), TaylorCalculate.exp(-10), TaylorCalculate.PRECISION);
        assertThrows(IllegalArgumentException.class, () -> TaylorCalculate.exp(0, 0));
    }

    @Test
    void testLg() {
        assertEquals(0, TaylorCalculate.lg(1), TaylorCalculate.PRECISION);
        assertEquals(1, TaylorCalculate.lg(10), TaylorCalculate.PRECISION);
        assertEquals(-1, TaylorCalculate.lg(0.1), TaylorCalculate.PRECISION);
        assertThrows(IllegalArgumentException.class, () -> TaylorCalculate.lg(0, 0));
        assertThrows(IllegalArgumentException.class, () -> TaylorCalculate.lg(-1, TaylorCalculate.PRECISION));
    }

    @Test
    void testLog() {
        assertEquals(1, TaylorCalculate.log(10, 10), TaylorCalculate.PRECISION);
        assertEquals(2, TaylorCalculate.log(2, 4), TaylorCalculate.PRECISION);
        assertEquals(-2, TaylorCalculate.log(2, 0.25), TaylorCalculate.PRECISION);
        assertThrows(IllegalArgumentException.class, () -> TaylorCalculate.log(0, 1, TaylorCalculate.PRECISION));
        assertThrows(IllegalArgumentException.class, () -> TaylorCalculate.log(2, -1, TaylorCalculate.PRECISION));
        assertThrows(IllegalArgumentException.class, () -> TaylorCalculate.log(2, 1, 0));
    }

    @Test
    void testLn() {
        assertEquals(0, TaylorCalculate.ln(1), TaylorCalculate.PRECISION);
        assertEquals(1, TaylorCalculate.ln(Math.E), TaylorCalculate.PRECISION);
        assertEquals(Math.log(2), TaylorCalculate.ln(2), TaylorCalculate.PRECISION);
        assertEquals(Math.log(0.5), TaylorCalculate.ln(0.5), TaylorCalculate.PRECISION);
        assertEquals(Math.log(10), TaylorCalculate.ln(10), TaylorCalculate.PRECISION);
        assertThrows(IllegalArgumentException.class, () -> TaylorCalculate.ln(0, TaylorCalculate.PRECISION));
        assertThrows(IllegalArgumentException.class, () -> TaylorCalculate.ln(-1, TaylorCalculate.PRECISION));
        assertThrows(IllegalArgumentException.class, () -> TaylorCalculate.ln(1, 0));
    }
}
