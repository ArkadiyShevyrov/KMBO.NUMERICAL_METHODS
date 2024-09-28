import {Variable} from "../operand/Variable";
import {Operand} from "../operand/Operand";
import {OperandToJson} from "../operand/OperandToJson";

export const OperandFunctionToJson = (operandFunction: OperandFunction): any => {
    return {
        operand: OperandToJson(operandFunction.operand),
        variable: {
            type: operandFunction.variable.type,
            name: operandFunction.variable.name
        }
    };
};

export interface OperandFunction {
    operand: Operand;
    variable: Variable;
}