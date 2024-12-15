package ru.kmbo.numerical_methods.calculate.optimize.operand.strategy;

import ru.kmbo.numerical_methods.calculate.optimize.operand.OperandOptimizer;
import ru.kmbo.numerical_methods.model.operand.Operand;
import ru.kmbo.numerical_methods.model.operand.implementation.Add;
import ru.kmbo.numerical_methods.model.operand.implementation.Num;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


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
        List<Operand> optimizeOperands = new ArrayList<>();
        for (Operand operand : add.getOperands()) {
            Operand optimize = optimizer.optimize(operand);
            if (optimize instanceof Add optimizeAdd) {
                optimizeOperands.addAll(optimizeAdd.getOperands());
            } else {
                optimizeOperands.add(optimize);
            }
        }

        List<Operand> resultOperands = new ArrayList<>();
        for (Operand operand : optimizeOperands) {
            if (operand instanceof Num num) {
                if (num.getNum() == 0) {
                    continue;
                }
            }
            resultOperands.add(operand);
        }

        if (resultOperands.size() == 1) {
            return resultOperands.getFirst();
        }

        return new Add(resultOperands.stream()
                .sorted(Comparator.comparing(Operand::toString))
                .collect(Collectors.toList()));
    }
}
