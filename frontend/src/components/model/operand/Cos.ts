import {Operand} from "./Operand";
import {BaseOperand} from "./BaseOperand";

export interface Cos extends BaseOperand {
    type: "Cos";
    operand: Operand;
}