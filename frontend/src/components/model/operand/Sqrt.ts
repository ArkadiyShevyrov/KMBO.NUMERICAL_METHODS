import {Operand} from "./Operand";
import {BaseOperand} from "./BaseOperand";

export interface Sqrt extends BaseOperand {
    type: "Sqrt";
    operand: Operand;
}