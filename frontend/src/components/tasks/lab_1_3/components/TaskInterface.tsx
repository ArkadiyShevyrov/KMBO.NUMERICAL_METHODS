import {OperandFunction} from "../../../model/function/OperandFunction";

export interface TaskInterface {
    operandFunction: OperandFunction;
    X: number[];
    xStar: number;
}