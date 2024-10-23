import {Operand} from "./Operand";
import {BaseOperand} from "./BaseOperand";

export interface Exp extends BaseOperand {
    type: "Exp";
    operand: Operand;
}