package ru.kmbo.numerical_methods.core.calculate.optimize.operand.strategy;

import ru.kmbo.numerical_methods.core.calculate.optimize.operand.OperandOptimizationStrategy;
import ru.kmbo.numerical_methods.core.calculate.optimize.operand.OperandOptimizer;
import ru.kmbo.numerical_methods.core.model.operand.Operand;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Add;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Multiply;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Neg;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Num;
import java.util.*;

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
        List<Operand> optimizedOperands = new ArrayList<>();
        Map<Operand, Double> coefficientMap = new HashMap<>();

        for (Operand operand : add.getOperands()) {
            Operand optimized = optimizer.optimize(operand);
            if (optimized instanceof Add nestedAdd) {
                optimizedOperands.addAll(nestedAdd.getOperands());
            } else {
                optimizedOperands.add(optimized);
            }
        }

        optimizedOperands = op(optimizedOperands);

        double sum = 0;

        for (Operand optimizedOperand : optimizedOperands) {
            if (optimizedOperand instanceof Num num) {
                sum += num.getNum();
            } else {
                if (!coefficientMap.containsKey(optimizedOperand)) {
                    coefficientMap.put(optimizedOperand, 0.0);
                }
                coefficientMap.merge(optimizedOperand, 1.0, Double::sum);
            }
        }

        List<Operand> finalOperands = new ArrayList<>();
        for (Operand operand : coefficientMap.keySet()) {
            Double v = coefficientMap.get(operand);
            finalOperands.add(optimizer.optimize(
                    new Multiply(
                        v,
                        operand
                    )
                )
            );
        }

        if (sum != 0) {
            finalOperands.add(new Num(sum));
        }

        finalOperands.sort(Comparator.comparing(Operand::toString));

        double d = 0;
        List<Operand> finalOperands1 = new ArrayList<>();
        for (Operand finalOperand : finalOperands) {
            if (finalOperand instanceof Num num) {
                d += num.getNum();
            } else if (finalOperand instanceof Neg neg && neg.getOperand() instanceof Num num) {
                d -= num.getNum();
            } else {
                finalOperands1.add(finalOperand);
            }
        }
        if (d > 0) {
            finalOperands1.add(new Num(d));
        } else if (d < 0) {
            finalOperands1.add(new Neg(new Num(-d)));
        }

        if (finalOperands1.size() == 1) {
            return finalOperands1.getFirst();
        } else if (finalOperands1.isEmpty()) {
            return new Num(0);
        }
        return new Add(finalOperands1);
    }

    private List<Operand> op(List<Operand> operands) {
        List<Operand> newOperands = new ArrayList<>();
        for (Operand operand : operands) {
            if (operand instanceof Num num) {
                if (!(num.getNum() == 0.)) {
                    newOperands.add(num);
                }
            } else {
                newOperands.add(operand);
            }
        }
        return newOperands;
    }
}
