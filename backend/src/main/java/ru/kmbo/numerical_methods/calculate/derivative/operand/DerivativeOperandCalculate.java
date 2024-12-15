package ru.kmbo.numerical_methods.calculate.derivative.operand;

import lombok.experimental.UtilityClass;
import ru.kmbo.numerical_methods.calculate.optimize.operand.DefaultOperandOptimizer;
import ru.kmbo.numerical_methods.model.function.implementation.OperandFunction;
import ru.kmbo.numerical_methods.model.operand.*;
import ru.kmbo.numerical_methods.model.operand.implementation.*;
import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class DerivativeOperandCalculate {
    private final DefaultOperandOptimizer defaultOperandOptimizer = new DefaultOperandOptimizer();

    public OperandFunction derivative(OperandFunction operandFunction) {
        return new OperandFunction(defaultOperandOptimizer.optimize(derivative(operandFunction.getOperand())), operandFunction.getVariable());
    }

    public Operand derivative(Operand operand) {
        return switch (operand) {
            case Variable ignored -> derivativeVariable();
            case Num ignored -> derivativeNum();
            case Add add -> derivativeAdd(add);
            case Multiply multiply -> derivativeMultiply(multiply);
            case Pow pow -> derivativePow(pow);
            case Sin sin -> derivativeSin(sin);
            case Cos cos -> derivativeCos(cos);
            case Neg neg -> derivativeNeg(neg);
            case null -> null;
            default -> throw new RuntimeException("Need add new types:" + operand.getClass().getTypeName());
        };
    }

    private static Operand derivativeNeg(Neg neg) {
        return new Neg(derivative(neg.getOperand()));
    }

    private static Operand derivativeCos(Cos cos) {
        return new Neg(
                new Multiply(
                        new Sin(cos.getOperand()),
                        derivative(cos.getOperand())
                )
        );
    }

    private static Operand derivativeSin(Sin sin) {
        return new Multiply(
                new Cos(sin.getOperand()),
                derivative(sin.getOperand())
        );
    }

    private static Operand derivativeVariable() {
        return new Num(1.);
    }

    private static Operand derivativeNum() {
        return new Num(0.);
    }

    private static Operand derivativeAdd(Add add) {
        List<Operand> derivativeOperands = new ArrayList<>();
        for (Operand operand : add.getOperands()) {
            derivativeOperands.add(derivative(operand));
        }
        return new Add(derivativeOperands);
    }

    private static Operand derivativeMultiply(Multiply multiply) {
        List<Operand> operands = multiply.getOperands(); // Получаем массив операндов
        Operand result = null;

        for (int i = 0; i < operands.size(); i++) {
            List<Operand> productTerms = new ArrayList<>();

            for (int j = 0; j < operands.size(); j++) {
                if (i == j) {
                    productTerms.add(derivative(operands.get(j))); // Дифференцируем i-ый операнд
                } else {
                    productTerms.add(operands.get(j)); // Остальные операнды остаются неизменными
                }
            }

            Operand product = new Multiply(productTerms); // Создаем произведение всех операндов
            result = (result == null) ? product : new Add(result, product); // Складываем частные производные
        }

        return result;
    }

    private static Operand derivativePow(Pow pow) {
        return new Multiply(
                pow.getExp(),
                new Pow(pow.getBase(),
                        (int) (pow.getExp().getResult() - 1)),
                derivative(pow.getBase())
        );
    }
}
