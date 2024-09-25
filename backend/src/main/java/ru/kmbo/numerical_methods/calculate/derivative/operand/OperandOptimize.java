package ru.kmbo.numerical_methods.calculate.derivative.operand;

import lombok.experimental.UtilityClass;
import ru.kmbo.numerical_methods.model.operand.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class OperandOptimize {

    public Operand optimize(Operand operand) {
        return switch (operand) {
            case Add add -> optimizeAdd(add);
            case Multiply multiply -> optimizeMultiply(multiply);
            case Pow pow -> optimizePow(pow);
            case Num num -> num;
            case Variable variable -> variable;
            case Sin sin -> sin;
            case Cos cos -> cos;
            case Neg neg -> optimizeNeg(neg);
            case null -> null;
            default -> throw new RuntimeException("Need add new types:" + operand.getClass().getTypeName());
        };
    }

    private static Operand optimizeNeg(Neg neg) {
        return new Neg(optimize(neg.getOperand()));
    }

    private Operand optimizeAdd(Add add) {
        List<Operand> optimizeOperands = new ArrayList<>();
        for (Operand operand : add.getOperands()) {
            Operand optimize = optimize(operand);
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

    private Operand optimizeMultiply(Multiply multiply) {

        List<Operand> optimizeOperands = new ArrayList<>();
        for (Operand operand : multiply.getOperands()) {
            Operand optimize = optimize(operand);
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

    private Operand optimizePow(Pow pow) {
        Operand optimizeBase = optimize(pow.getBase());
        Operand optimizeExp = optimize(pow.getExp());
        if (optimizeExp instanceof Num num) {
            if (num.getNum() == 0) {
                return new Num(1.);
            }
        }
        return new Pow(optimizeBase, optimizeExp);
    }
}
