package ru.kmbo.numerical_methods;

import org.junit.jupiter.api.Test;
import ru.kmbo.numerical_methods.calculate.optimize.operand.DefaultOperandOptimizer;
import ru.kmbo.numerical_methods.model.operand.Operand;
import ru.kmbo.numerical_methods.model.operand.implementation.Add;
import ru.kmbo.numerical_methods.model.operand.implementation.Num;
import ru.kmbo.numerical_methods.model.operand.implementation.Sin;
import ru.kmbo.numerical_methods.model.operand.implementation.Variable;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OperandTest {

    @Test
    void test1() {

        Operand operand = new Add(
                new Sin(new Num(1)),
                new Sin(new Num(1))
        );

        assertEquals(1.6829419696, operand.getResult());
    }

    @Test
    void test2() {
        Num num = new Num(1.);

        Operand operand = new Add(
                new Sin(num),
                new Sin(num)
        );

        assertEquals(1.6829419696, operand.getResult());
    }

    @Test
    void test3() {
        Num num = new Num(1.);

        Operand operand = new Add(
                new Sin(num),
                new Sin(num)
        );

        assertEquals(1.6829419696, operand.getResult());
    }

    @Test
    void test4() {

        Variable x1 = new Variable("x");

        Operand operand = new Add(
                new Num(1.),
                x1,
                new Num(0.),
                new Num(1.),
                new Num(0.),
                new Num(1.),
                x1
        );
        Operand optimize = new DefaultOperandOptimizer().optimize(operand);
        assertEquals("3+2*x", operand.toString());
    }
}
