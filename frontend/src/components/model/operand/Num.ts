import {BaseOperand} from "./BaseOperand";

export interface Num extends BaseOperand {
    type: "Num";
    num: number;
}