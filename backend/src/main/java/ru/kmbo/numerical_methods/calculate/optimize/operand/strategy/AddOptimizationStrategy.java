package ru.kmbo.numerical_methods.calculate.optimize.operand.strategy;

import ru.kmbo.numerical_methods.calculate.optimize.operand.OperandOptimizer;
import ru.kmbo.numerical_methods.model.operand.Operand;
import ru.kmbo.numerical_methods.model.operand.implementation.Add;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AddOptimizationStrategy extends OperandOptimizationStrategy {

    public AddOptimizationStrategy(OperandOptimizer optimizer) {
        super(optimizer);
    }

    @Override
    public Operand optimize(Operand operand) {
        Add add = (Add) operand;
        return optimize(add);
    }

    private Operand optimize(Add add) {
        List<Operand> optimizeOperands1 = new ArrayList<>();
        for (Operand operand : add.getOperands()) {
            optimizeOperands1.add(optimizer.optimize(operand));
        }

        List<Operand> optimizeOperands2 = new ArrayList<>();
        for (Operand optimizeOperand : optimizeOperands1) {
            if (optimizeOperand instanceof Add optimizeAdd) {
                optimizeOperands2.addAll(optimizeAdd.getOperands());
            } else {
                optimizeOperands2.add(optimizeOperand);
            }
        }

        optimizeOperands2 = optimizeOperands2.stream()
                .sorted(Comparator.comparing(Operand::toString))
                .toList();


        if (optimizeOperands2.size() == 1) {
            return optimizeOperands2.getFirst();
        }

        return new Add(optimizeOperands2.stream()
                .sorted(Comparator.comparing(Operand::toString))
                .toList());
    }
}
