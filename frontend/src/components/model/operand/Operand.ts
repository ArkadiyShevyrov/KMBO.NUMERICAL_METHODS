import {Variable} from "./Variable";
import {Num} from "./Num";
import {Add} from "./Add";
import {Multiply} from "./Multiply";
import {Pow} from "./Pow";
import {Divide} from "./Divide";

export type Operand =
    | Variable
    | Num
    | Add
    | Multiply
    | Pow
    | Divide;