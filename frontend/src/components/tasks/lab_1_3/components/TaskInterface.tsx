import {OperandFunction} from "../../../model/function/OperandFunction";
import {Operand} from "../../../model/operand/Operand";

export interface TaskInterface {
    operandFunction: OperandFunction;
    X: number[] | Operand[];
    xStar: number | Operand;
}