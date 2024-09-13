package ru.kmbo.numerical_methods;

import org.junit.jupiter.api.Test;
import ru.kmbo.numerical_methods.model.operand.Number;
import ru.kmbo.numerical_methods.model.operand.Operand;
import ru.kmbo.numerical_methods.model.operand.Sin;
import ru.kmbo.numerical_methods.model.operand.Add;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OperandTest {

    @Test
    void test1() {

        Operand operand = new Add(
                new Sin(new Number(1)),
                new Sin(new Number(1))
        );

        assertEquals(1.6829419696, operand.getResult());
    }

    @Test
    void test2() {

        Operand operand = new Add(
                new Sin(new Number()),
                new Sin(new Number())
        );

        assertEquals(1.6829419696, operand.getResult(1.));
    }

    @Test
    void test3() {

        Operand operand = new Add(
                new Sin(),
                new Sin()
        );

        assertEquals(1.6829419696, operand.getResult(1.));
    }

    @Test
    void test4() {
        Number number1 = new Number();
        Number number2 = new Number();

        Operand operand = new Add(
                new Sin(number1),
                new Sin(number2)
        );

        number1.setNumber(1.);
        number2.setNumber(0.);

        assertEquals(0.8414709848, operand.getResult());
    }
}
