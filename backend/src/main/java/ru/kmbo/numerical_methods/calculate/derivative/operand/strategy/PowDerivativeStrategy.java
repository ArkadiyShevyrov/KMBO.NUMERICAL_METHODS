package ru.kmbo.numerical_methods.calculate.derivative.operand.strategy;

import ru.kmbo.numerical_methods.calculate.derivative.operand.OperandDerivative;
import ru.kmbo.numerical_methods.calculate.derivative.operand.OperandDerivativeStrategy;
import ru.kmbo.numerical_methods.model.operand.Operand;
import ru.kmbo.numerical_methods.model.operand.implementation.*;

public class PowDerivativeStrategy extends OperandDerivativeStrategy {

    public PowDerivativeStrategy(OperandDerivative derivative) {
        super(derivative);
    }

    @Override
    public Operand differentiate(Operand operand, Variable deffierintiationVariable) {
        Pow pow = (Pow) operand;
        return differentiate(pow, deffierintiationVariable);
    }

    private Operand differentiate(Pow pow, Variable deffierintiationVariable) {
        return new Add(
                new Multiply(
                        pow.getExp(),
                        new Pow(
                                pow.getBase(),
                                new Add(
                                        pow.getExp(),
                                        new Neg(new Num(-1))
                                )
                        ),
                        derivative.differentiate(pow.getBase(), deffierintiationVariable)
                ),
                new Multiply(
                        new Pow(
                                pow.getBase(),
                                pow.getExp()
                        ),
                        derivative.differentiate(pow.getExp(), deffierintiationVariable),
                        new Ln(pow.getBase())
                )
        );
    }
}
