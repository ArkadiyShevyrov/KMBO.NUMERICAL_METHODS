import {Operand} from "./Operand";
import {BaseOperand} from "./BaseOperand";

export interface Neg extends BaseOperand {
    type: "Neg";
    operand: Operand;
}