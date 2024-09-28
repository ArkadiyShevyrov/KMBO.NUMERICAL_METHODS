import {Variable} from "../operand/Variable";
import {Operand} from "../operand/Operand";

export interface OperandFunction {
    operand: Operand;
    variable: Variable;
}