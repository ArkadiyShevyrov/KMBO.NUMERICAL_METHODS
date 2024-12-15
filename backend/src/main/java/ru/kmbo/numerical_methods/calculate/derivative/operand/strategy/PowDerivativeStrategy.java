package ru.kmbo.numerical_methods.calculate.derivative.operand.strategy;

import ru.kmbo.numerical_methods.calculate.derivative.operand.OperandDerivative;
import ru.kmbo.numerical_methods.model.operand.Operand;
import ru.kmbo.numerical_methods.model.operand.implementation.Multiply;
import ru.kmbo.numerical_methods.model.operand.implementation.Pow;

public class PowDerivativeStrategy extends OperandDerivativeStrategy {

    public PowDerivativeStrategy(OperandDerivative derivative) {
        super(derivative);
    }

    @Override
    public Operand differentiate(Operand operand) {
        Pow pow = (Pow) operand;
        return differentiate(pow);
    }

    private Operand differentiate(Pow pow) {
        return new Multiply(
                pow.getExp(),
                new Pow(pow.getBase(),
                        (int) (pow.getExp().getResult() - 1)),
                derivative.differentiate(pow.getBase())
        );
    }
}
