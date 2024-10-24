import { Operand } from "./Operand";
import { ConstType } from "./Const";

export const OperandCalculate = (operand: Operand | number, x?: number): number => {
    if (typeof  operand == "number") return operand;
    switch (operand.type) {
        case 'Variable':
            if (x !== undefined && x !== null) {
                return x;
            } else {
                throw new Error("Cannot calculate value for a variable.");  // Иначе выбрасываем исключение
            }
        case 'Num':
            return operand.num;
        case 'Add':
            return operand.operands.reduce((sum, op) => sum + OperandCalculate(op, x), 0);
        case 'Multiply':
            return operand.operands.reduce((product, op) => product * OperandCalculate(op, x), 1);
        case 'Pow':
            return Math.pow(OperandCalculate(operand.base, x), OperandCalculate(operand.exp, x));
        case 'Divide':
            return OperandCalculate(operand.dividend, x) / OperandCalculate(operand.divisor, x);
        case 'Sqrt':
            return Math.sqrt(OperandCalculate(operand.operand, x));
        case 'Neg':
            return -OperandCalculate(operand.operand, x);
        case 'Sin':
            return Math.sin(OperandCalculate(operand.operand, x));
        case 'Cos':
            return Math.cos(OperandCalculate(operand.operand, x));
        case 'Exp':
            return Math.exp(OperandCalculate(operand.operand, x));
        case 'Const':
            switch (operand.const) {
                case ConstType.PI:
                    return Math.PI;
                default:
                    throw new Error("Unknown constant type.");
            }
        default:
            throw new Error(`Unknown operand type: ${operand}`);
    }
};
