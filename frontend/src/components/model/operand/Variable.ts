import {BaseOperand} from "./BaseOperand";

export interface Variable extends BaseOperand {
    type: "Variable";
    name: string;
}