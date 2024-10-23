import {Operand} from "./Operand";
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

export const OperandToJson = (operand: Operand): any => {
    switch (operand.type) {
        case "Variable":
            return {type: "Variable", name: (operand as Variable).name};
        case "Num":
            return {type: "Num", num: (operand as Num).num};
        case "Add":
            return {
                type: "Add",
                operands: (operand as Add).operands.map(OperandToJson),
            };
        case "Multiply":
            return {
                type: "Multiply",
                operands: (operand as Multiply).operands.map(OperandToJson),
            };
        case "Pow":
            return {
                type: "Pow",
                base: OperandToJson((operand as Pow).base),
                exp: OperandToJson((operand as Pow).exp),
            };
        case "Divide":
            return {
                type: "Multiply",
                operands: [
                    OperandToJson((operand as Divide).dividend),
                    {
                        type: "Pow",
                        base: OperandToJson((operand as Divide).divisor),
                        exp: { type: "Num", num: -1 },
                    }
                ],
            };
        case "Sqrt":
            return {
                type: "Pow",
                base: OperandToJson((operand as Sqrt).operand),
                exp: { type: "Num", num: 0.5 },
            };
        case "Neg":
            return {
                type: "Neg",
                operand: OperandToJson((operand as Neg).operand)
            };
        case "Sin":
            return {
                type: "Sin",
                operand: OperandToJson((operand as Sin).operand)
            }
        case "Cos":
            return {
                type: "Cos",
                operand: OperandToJson((operand as Cos).operand)
            }
        case "Exp":
            return {
                type: "Sin",
                operand: OperandToJson((operand as Exp).operand)
            }
        default:
            throw new Error(`Unknown operand type: ${(operand as Operand).type}`);
    }
};