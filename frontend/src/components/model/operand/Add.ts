import {Operand} from "./Operand";
import {BaseOperand} from "./BaseOperand";

export interface Add extends BaseOperand {
    type: "Add";
    operands: Operand[];
}