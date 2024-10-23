import {Operand} from "./Operand";
import {BaseOperand} from "./BaseOperand";

export interface Sin extends BaseOperand {
    type: "Sin";
    operand: Operand;
}