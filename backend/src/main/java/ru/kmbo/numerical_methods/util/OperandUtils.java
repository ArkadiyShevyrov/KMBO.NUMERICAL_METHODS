package ru.kmbo.numerical_methods.util;

import lombok.experimental.UtilityClass;
import ru.kmbo.numerical_methods.model.operand.*;
import ru.kmbo.numerical_methods.model.operand.implementation.*;
import java.util.List;

@UtilityClass
public class OperandUtils {

    public void setOperand(Variable variable, Operand operand, Double value) {
        switch (operand) {
            case Add add -> setAdd(variable, add, value);
            case Cos cos -> setCos(variable, cos, value);
            case Exp exp -> setExp(variable, exp, value);
            case Multiply multiply -> setMultiply(variable, multiply, value);
            case Neg neg -> setNeg(variable, neg, value);
            case Num ignored -> {
            }
            case Pow pow -> setPow(variable, pow, value);
            case Sin sin -> setSin(variable, sin, value);
            case Variable var -> setVariable(variable, var, value);
            case Ln ln -> setLn(variable, ln, value);
            case null, default -> throw new RuntimeException(operand.getClass().getTypeName());
        }
    }

    private static void setLn(Variable variable, Ln ln, Double value) {
        Operand operand = ln.getOperand();
        setOperand(variable, operand, value);
    }

    private static void setVariable(Variable variable, Variable var, Double value) {
        if (var.getName().equals(variable.getName())) {
            var.setVar(value);
        }
    }

    private static void setSin(Variable variable, Sin sin, Double value) {
        Operand operand = sin.getOperand();
        setOperand(variable, operand, value);
    }


    private static void setPow(Variable variable, Pow pow, Double value) {
        Operand base = pow.getBase();
        setOperand(variable, base, value);
        Operand exp = pow.getExp();
        setOperand(variable, exp, value);
    }

    private static void setNeg(Variable variable, Neg neg, Double value) {
        Operand operand = neg.getOperand();
        setOperand(variable, operand, value);
    }

    private static void setMultiply(Variable variable, Multiply multiply, Double value) {
        List<Operand> operands = multiply.getOperands();
        for (Operand operand : operands) {
            setOperand(variable, operand, value);
        }
    }

    private static void setExp(Variable variable, Exp exp, Double value) {
        Operand operand = exp.getOperand();
        setOperand(variable, operand, value);
    }

    private static void setCos(Variable variable, Cos cos, Double value) {
        Operand operand = cos.getOperand();
        setOperand(variable, operand, value);
    }

    private void setAdd(Variable variable, Add add, Double value) {
        List<Operand> operands = add.getOperands();
        for (Operand operand : operands) {
            setOperand(variable, operand, value);
        }
    }
}
