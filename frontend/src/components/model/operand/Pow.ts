import {Operand} from "./Operand";
import {BaseOperand} from "./BaseOperand";

export interface Pow extends BaseOperand {
    type: "Pow";
    base: Operand;
    exp: Operand;
}