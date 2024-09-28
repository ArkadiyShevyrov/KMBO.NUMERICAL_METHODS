import {Operand} from "./Operand";
import {BaseOperand} from "./BaseOperand";

export interface Divide extends BaseOperand {
    type: "Divide";
    dividend: Operand;
    divisor: Operand;
}