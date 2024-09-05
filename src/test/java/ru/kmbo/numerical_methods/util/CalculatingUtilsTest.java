package ru.kmbo.numerical_methods.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatingUtilsTest {

    @Test
    void testCalculateSin() {
        assertEquals(0, CalculatingUtils.calculateSin(0), CalculatingUtils.PRECISION);
        assertEquals(1, CalculatingUtils.calculateSin(Math.PI / 2), CalculatingUtils.PRECISION);
        assertEquals(-1, CalculatingUtils.calculateSin(-Math.PI / 2), CalculatingUtils.PRECISION);
        assertEquals(0, CalculatingUtils.calculateSin(Math.PI), CalculatingUtils.PRECISION);
        assertEquals(0, CalculatingUtils.calculateSin(2 * Math.PI), CalculatingUtils.PRECISION);
        assertThrows(IllegalArgumentException.class, () -> CalculatingUtils.calculateSin(0, 0));
        assertEquals(Math.sin(Math.PI / 4), CalculatingUtils.calculateSin(Math.PI / 4), CalculatingUtils.PRECISION);
        assertEquals(Math.sin(-Math.PI / 4), CalculatingUtils.calculateSin(-Math.PI / 4), CalculatingUtils.PRECISION);
        assertEquals(Math.sin(3 * Math.PI / 4), CalculatingUtils.calculateSin(3 * Math.PI / 4), CalculatingUtils.PRECISION);
        assertEquals(Math.sin(-3 * Math.PI / 4), CalculatingUtils.calculateSin(-3 * Math.PI / 4), CalculatingUtils.PRECISION);
    }

    @Test
    void testCalculateCos() {
        assertEquals(1, CalculatingUtils.calculateCos(0), CalculatingUtils.PRECISION);
        assertEquals(0, CalculatingUtils.calculateCos(Math.PI / 2), CalculatingUtils.PRECISION);
        assertEquals(-1, CalculatingUtils.calculateCos(Math.PI), CalculatingUtils.PRECISION);
        assertEquals(0, CalculatingUtils.calculateCos(3 * Math.PI / 2), CalculatingUtils.PRECISION);
        assertEquals(1, CalculatingUtils.calculateCos(2 * Math.PI), CalculatingUtils.PRECISION);
        assertThrows(IllegalArgumentException.class, () -> CalculatingUtils.calculateCos(0, 0));
        assertEquals(Math.cos(Math.PI / 4), CalculatingUtils.calculateCos(Math.PI / 4), CalculatingUtils.PRECISION);
        assertEquals(Math.cos(-Math.PI / 4), CalculatingUtils.calculateCos(-Math.PI / 4), CalculatingUtils.PRECISION);
        assertEquals(Math.cos(3 * Math.PI / 4), CalculatingUtils.calculateCos(3 * Math.PI / 4), CalculatingUtils.PRECISION);
        assertEquals(Math.cos(-3 * Math.PI / 4), CalculatingUtils.calculateCos(-3 * Math.PI / 4), CalculatingUtils.PRECISION);
    }

    @Test
    void testCalculateExp() {
        assertEquals(1, CalculatingUtils.calculateExp(0), CalculatingUtils.PRECISION);
        assertEquals(Math.E, CalculatingUtils.calculateExp(1), CalculatingUtils.PRECISION);
        assertEquals(Math.exp(1), CalculatingUtils.calculateExp(1), CalculatingUtils.PRECISION);
        assertEquals(Math.exp(-1), CalculatingUtils.calculateExp(-1), CalculatingUtils.PRECISION);
        assertEquals(Math.exp(10), CalculatingUtils.calculateExp(10), CalculatingUtils.PRECISION);
        assertEquals(Math.exp(-10), CalculatingUtils.calculateExp(-10), CalculatingUtils.PRECISION);
        assertThrows(IllegalArgumentException.class, () -> CalculatingUtils.calculateExp(0, 0));
    }

    @Test
    void testCalculateLg() {
        assertEquals(0, CalculatingUtils.calculateLg(1), CalculatingUtils.PRECISION);
        assertEquals(1, CalculatingUtils.calculateLg(10), CalculatingUtils.PRECISION);
        assertEquals(-1, CalculatingUtils.calculateLg(0.1), CalculatingUtils.PRECISION);
        assertThrows(IllegalArgumentException.class, () -> CalculatingUtils.calculateLg(0, 0));
        assertThrows(IllegalArgumentException.class, () -> CalculatingUtils.calculateLg(-1, CalculatingUtils.PRECISION));
    }

    @Test
    void testCalculateLog() {
        assertEquals(1, CalculatingUtils.calculateLog(10, 10), CalculatingUtils.PRECISION);
        assertEquals(2, CalculatingUtils.calculateLog(2, 4), CalculatingUtils.PRECISION);
        assertEquals(-2, CalculatingUtils.calculateLog(2, 0.25), CalculatingUtils.PRECISION);
        assertThrows(IllegalArgumentException.class, () -> CalculatingUtils.calculateLog(0, 1, CalculatingUtils.PRECISION));
        assertThrows(IllegalArgumentException.class, () -> CalculatingUtils.calculateLog(2, -1, CalculatingUtils.PRECISION));
        assertThrows(IllegalArgumentException.class, () -> CalculatingUtils.calculateLog(2, 1, 0));
    }

    @Test
    void testCalculateLn() {
        assertEquals(0, CalculatingUtils.calculateLn(1), CalculatingUtils.PRECISION);
        assertEquals(1, CalculatingUtils.calculateLn(Math.E), CalculatingUtils.PRECISION);
        assertEquals(Math.log(2), CalculatingUtils.calculateLn(2), CalculatingUtils.PRECISION);
        assertEquals(Math.log(0.5), CalculatingUtils.calculateLn(0.5), CalculatingUtils.PRECISION);
        assertEquals(Math.log(10), CalculatingUtils.calculateLn(10), CalculatingUtils.PRECISION);
        assertThrows(IllegalArgumentException.class, () -> CalculatingUtils.calculateLn(0, CalculatingUtils.PRECISION));
        assertThrows(IllegalArgumentException.class, () -> CalculatingUtils.calculateLn(-1, CalculatingUtils.PRECISION));
        assertThrows(IllegalArgumentException.class, () -> CalculatingUtils.calculateLn(1, 0));
    }

    @Test
    void testFactorial() {
        assertEquals(1, CalculatingUtils.factorial(0));
        assertEquals(1, CalculatingUtils.factorial(1));
        assertEquals(2, CalculatingUtils.factorial(2));
        assertEquals(6, CalculatingUtils.factorial(3));
        assertEquals(24, CalculatingUtils.factorial(4));
        assertThrows(IllegalArgumentException.class, () -> CalculatingUtils.factorial(-1));
    }
}
