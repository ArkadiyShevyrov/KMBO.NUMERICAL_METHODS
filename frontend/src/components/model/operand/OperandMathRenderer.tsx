import React from 'react';
import {MathRenderer} from "../../MathRenderer";
import {Operand} from "./Operand";

const OperandToLatex = (operand: Operand): string => {
    switch (operand.type) {
        case 'Variable':
            return operand.name;
        case 'Num':
            return operand.num.toString();
        case 'Add':
            return operand.operands.map(OperandToLatex).join(' + ');
        case 'Multiply':
            return operand.operands.map(OperandToLatex).join(' \\cdot ');
        case 'Pow':
            return `(${OperandToLatex(operand.base)})^{${OperandToLatex(operand.exp)}}`;
        case "Divide":
            return `\\frac{${OperandToLatex(operand.dividend)}}{${OperandToLatex(operand.divisor)}}`
        default:
            return '';
    }
};

const OperandMathRenderer: React.FC<{ operand: Operand }> = ({operand}) => {
    const latex = OperandToLatex(operand);
    return <MathRenderer mathContent={latex}/>;
};

export default OperandMathRenderer;
