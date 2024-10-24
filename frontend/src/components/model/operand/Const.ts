import {BaseOperand} from "./BaseOperand";

export enum ConstType {
    PI
}

export interface Const extends BaseOperand {
    type: "Const";
    const: ConstType;
}