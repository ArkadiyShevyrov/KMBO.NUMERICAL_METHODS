import {OperandFunction} from "../../model/function/OperandFunction";

export enum TypeMethod {
    RECTANGLE_LEFT_METHOD = "RECTANGLE_LEFT_METHOD",
    RECTANGLE_MEDIAN_METHOD = "RECTANGLE_MEDIAN_METHOD",
    RECTANGLE_RIGHT_METHOD = "RECTANGLE_RIGHT_METHOD",
    TRAPEZOID_METHOD = "TRAPEZOID_METHOD",
    SIMPSON_METHOD = "SIMPSON_METHOD"
}

export interface NumericalIntegrationFunctionInterface {
    a: number;
    b: number;
    h: number;
    operandFunction: OperandFunction;
}

export interface NumericalIntegrationInterface {
    typeMethod: TypeMethod;
    numericalIntegrationFunctionInterface: NumericalIntegrationFunctionInterface;
}