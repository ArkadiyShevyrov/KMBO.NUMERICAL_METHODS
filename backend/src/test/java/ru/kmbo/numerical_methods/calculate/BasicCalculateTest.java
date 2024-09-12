package ru.kmbo.numerical_methods.calculate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BasicCalculateTest {

    @Test
    void testFactorial() {
        assertEquals(1, BasicCalculate.factorial(0));
        assertEquals(1, BasicCalculate.factorial(1));
        assertEquals(2, BasicCalculate.factorial(2));
        assertEquals(6, BasicCalculate.factorial(3));
        assertEquals(24, BasicCalculate.factorial(4));
        assertThrows(IllegalArgumentException.class, () -> BasicCalculate.factorial(-1));
    }
}
