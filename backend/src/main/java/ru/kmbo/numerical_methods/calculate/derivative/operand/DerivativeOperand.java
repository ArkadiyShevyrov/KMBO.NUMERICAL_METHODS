package ru.kmbo.numerical_methods.calculate.derivative.operand;

import ru.kmbo.numerical_methods.model.operand.Operand;

public interface DerivativeOperand {
    Operand derivative(Operand operand);
}
