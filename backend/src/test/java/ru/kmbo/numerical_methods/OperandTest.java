package ru.kmbo.numerical_methods;

import org.junit.jupiter.api.Test;
import ru.kmbo.numerical_methods.model.operand.Num;
import ru.kmbo.numerical_methods.model.operand.Operand;
import ru.kmbo.numerical_methods.model.operand.Sin;
import ru.kmbo.numerical_methods.model.operand.Add;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        Num num1 = new Num();
        Num num2 = new Num();

        Operand operand = new Add(
                new Sin(num1),
                new Sin(num2)
        );

        num1.setNumber(1.);
        num2.setNumber(0.);

        assertEquals(0.8414709848, operand.getResult());
    }
}
