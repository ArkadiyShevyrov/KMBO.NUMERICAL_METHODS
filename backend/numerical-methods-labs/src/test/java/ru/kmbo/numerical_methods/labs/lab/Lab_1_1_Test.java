package ru.kmbo.numerical_methods.labs.lab;

import org.junit.jupiter.api.Test;
import ru.kmbo.numerical_methods.core.calculate.TaylorCalculate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Lab_1_1_Test {

    @Test
    void testSinValues() {
        for (int i = 0; i < 10000; i++) {
            double randomX = Math.random();
            assertEquals(Math.sin(randomX), TaylorCalculate.sin(randomX), TaylorCalculate.PRECISION);
        }
    }

    @Test
    void testExpValues() {
        for (int i = 0; i < 10000; i++) {
            double randomX = Math.random();
            assertEquals(Math.exp(randomX), TaylorCalculate.exp(randomX), TaylorCalculate.PRECISION);
        }
    }

    //TODO улучить точность, если это возможно
    @Test
    void testLgValues() {
        for (int i = 0; i < 10000; i++) {
            double randomX = Math.random();
            assertEquals(Math.log10(randomX), TaylorCalculate.lg(randomX), 1e-5);
        }
    }

    @Test
    void testCosValues() {
        for (int i = 0; i < 10000; i++) {
            double randomX = Math.random();
            assertEquals(Math.cos(randomX), TaylorCalculate.cos(randomX), TaylorCalculate.PRECISION);
        }
    }

    //TODO улучить точность, если это возможно
    @Test
    void testLnValues() {
        for (int i = 0; i < 10000; i++) {
            double randomX = Math.random();
            assertEquals(Math.log(randomX), TaylorCalculate.ln(randomX), 1e-5);
        }
    }
    //TODO улучить точность, если это возможно
    @Test
    void testLogAValues() {
        for (int i = 0; i < 10000; i++) {
            double randomX = Math.random();
            double randomBase = Math.random();
            double expectedX = Math.log(randomX);
            double expectedBase = Math.log(randomBase);
            double actualX = TaylorCalculate.ln(randomX);
            double actualBase = TaylorCalculate.ln(randomBase);
            assertEquals(expectedX, actualX, 1e-5);
            assertEquals(expectedBase, actualBase, 1e-5);
        }
    }
}
