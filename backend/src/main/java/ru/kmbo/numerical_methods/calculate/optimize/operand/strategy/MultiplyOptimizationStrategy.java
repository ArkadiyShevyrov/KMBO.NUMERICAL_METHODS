package ru.kmbo.numerical_methods.calculate.optimize.operand.strategy;

import ru.kmbo.numerical_methods.calculate.optimize.operand.OperandOptimizer;
import ru.kmbo.numerical_methods.model.operand.Operand;
import ru.kmbo.numerical_methods.model.operand.implementation.Multiply;
import ru.kmbo.numerical_methods.model.operand.implementation.Num;
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

        if (resultOperands.size() == 1) {
            return resultOperands.getFirst();
        }

        return new Multiply(resultOperands.stream()
                .sorted(Comparator.comparing(Operand::toString))
                .collect(Collectors.toList()));
    }
}
