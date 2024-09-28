import {Operand} from "./Operand";
import {BaseOperand} from "./BaseOperand";

export interface Multiply extends BaseOperand {
    type: "Multiply";
    operands: Operand[];
}