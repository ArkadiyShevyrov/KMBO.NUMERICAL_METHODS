package ru.kmbo.numerical_methods.core.calculate.derivative.operand.strategy;

import ru.kmbo.numerical_methods.core.calculate.derivative.operand.OperandDerivative;
import ru.kmbo.numerical_methods.core.calculate.derivative.operand.OperandDerivativeStrategy;
import ru.kmbo.numerical_methods.core.model.operand.Operand;
import ru.kmbo.numerical_methods.core.model.operand.implementation.*;

public class PowDerivativeStrategy extends OperandDerivativeStrategy {

    public PowDerivativeStrategy(OperandDerivative derivative) {
        super(derivative);
    }

    @Override
    public Operand differentiate(Operand operand, Variable diffVariable) {
        Pow pow = (Pow) operand;
        return differentiate(pow, diffVariable);
    }

    private Operand differentiate(Pow pow, Variable diffVariable) {
        return new Add(
            new Multiply(
                pow.getExp(),
                new Pow(
                    pow.getBase(),
                    new Add(
                        pow.getExp(),
                        new Neg(new Num(1))
                    )
                ),
                derivative.differentiate(pow.getBase(), diffVariable)
            ),
            new Multiply(
                new Pow(
                    pow.getBase(),
                    pow.getExp()
                ),
                derivative.differentiate(pow.getExp(), diffVariable),
                new Ln(pow.getBase())
            )
        );
    }
}
