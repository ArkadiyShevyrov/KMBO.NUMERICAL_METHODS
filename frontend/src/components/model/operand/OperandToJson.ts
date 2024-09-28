import {Operand} from "./Operand";
import {Variable} from "./Variable";
import {Num} from "./Num";
import {Add} from "./Add";
import {Multiply} from "./Multiply";
import {Pow} from "./Pow";
import {Divide} from "./Divide";

export const operandToJson = (operand: Operand): any => {
    switch (operand.type) {
        case "Variable":
            return {type: "Variable", name: (operand as Variable).name};
        case "Num":
            return {type: "Num", num: (operand as Num).num};
        case "Add":
            return {
                type: "Add",
                operands: (operand as Add).operands.map(operandToJson),
            };
        case "Multiply":
            return {
                type: "Multiply",
                operands: (operand as Multiply).operands.map(operandToJson),
            };
        case "Pow":
            return {
                type: "Pow",
                base: operandToJson((operand as Pow).base),
                exp: operandToJson((operand as Pow).exp),
            };
        case "Divide":
            return {
                type: "Multiply",
                operands: [
                    operandToJson((operand as Divide).dividend),
                    {
                        type: "Pow",
                        base: operandToJson((operand as Divide).divisor),
                        exp: { type: "Num", num: -1 },
                    }
                ],
            };
        default:
            throw new Error(`Unknown operand type: ${(operand as Operand).type}`);
    }
};