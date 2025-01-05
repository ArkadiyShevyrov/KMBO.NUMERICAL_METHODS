package ru.kmbo.numerical_methods.core.calculate.optimize.operand.strategy;

import ru.kmbo.numerical_methods.core.calculate.optimize.operand.OperandOptimizationStrategy;
import ru.kmbo.numerical_methods.core.calculate.optimize.operand.OperandOptimizer;
import ru.kmbo.numerical_methods.core.model.operand.Operand;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Multiply;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Neg;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Num;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MultiplyOptimizationStrategy extends OperandOptimizationStrategy {

    public MultiplyOptimizationStrategy(OperandOptimizer optimizer) {
        super(optimizer);
    }

    @Override
    public Operand optimize(Operand operand) {
        Multiply multiply = (Multiply) operand;
        return optimize(multiply);
    }

    private Operand optimize(Multiply multiply) {

        List<Operand> optimizeOperands = new ArrayList<>();
        for (Operand operand : multiply.getOperands()) {
            Operand optimize = optimizer.optimize(operand);
            if (optimize instanceof Multiply optimizeMultiply) {
                optimizeOperands.addAll(optimizeMultiply.getOperands());
            } else {
                optimizeOperands.add(optimize);
            }
        }

        List<Operand> resultOperands = new ArrayList<>();
        for (Operand operand : optimizeOperands) {
            if (operand instanceof Num num) {
                if (num.getNum() == 1.) {
                    continue;
                }
            }
            resultOperands.add(operand);
        }

        for (Operand operand : resultOperands) {
            if (operand instanceof Num) {
                if (((Num) operand).getNum() == 0) {
                    return new Num(0);
                }
            }
        }

        double d = 1;
        List<Operand> finalOperands1 = new ArrayList<>();
        for (Operand finalOperand : resultOperands) {
            if (finalOperand instanceof Num num) {
                d *= num.getNum();
            } else if (finalOperand instanceof Neg neg && neg.getOperand() instanceof Num num) {
                d *= -num.getNum();
            } else {
                finalOperands1.add(finalOperand);
            }
        }
        if (d == 1) {
            if (finalOperands1.isEmpty()) {
                finalOperands1.add(new Num(d));
            }
        } else if (d > 0) {
            finalOperands1.add(new Num(d));
        } else if (d < 0) {
            finalOperands1.add(new Neg(new Num(-d)));
        }

        if (finalOperands1.size() == 1) {
            return finalOperands1.getFirst();
        }

        return new Multiply(finalOperands1.stream()
            .sorted(Comparator.comparing(Operand::toString))
            .collect(Collectors.toList()));
    }
}