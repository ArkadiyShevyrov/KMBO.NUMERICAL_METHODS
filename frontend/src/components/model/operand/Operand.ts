import {Variable} from "./Variable";
import {Num} from "./Num";
import {Add} from "./Add";
import {Multiply} from "./Multiply";
import {Pow} from "./Pow";
import {Divide} from "./Divide";
import {Sqrt} from "./Sqrt";
import {Neg} from "./Neg";
import {Sin} from "./Sin";
import {Cos} from "./Cos";
import {Exp} from "./Exp";

export type Operand =
    | Variable
    | Num
    | Add
    | Multiply
    | Pow
    | Divide
    | Sqrt
    | Neg
    | Sin
    | Cos
    | Exp;