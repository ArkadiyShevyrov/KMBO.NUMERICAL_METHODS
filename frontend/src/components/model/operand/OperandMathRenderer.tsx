import React from 'react';
import {MathRenderer} from "../../MathRenderer";
import {Operand} from "./Operand";

export const OperandToLatex = (operand: Operand): string => {
    switch (operand.type) {
        case 'Variable':
            return operand.name;
        case 'Num':
            return operand.num.toString();
        case 'Add':
            return operand.operands.map(OperandToLatex).map((latex, index) => {
                const nextOperand = operand.operands[index];
                if (nextOperand.type === 'Neg') {
                    return latex;
                } else if (index === 0) {
                    return latex;
                }
                return ` + ${latex}`;
            }).join('');
        case 'Multiply':
            return operand.operands.map(OperandToLatex).map((latex, index) => {
                const nextOperand = operand.operands[index];
                if (nextOperand.type === 'Variable') {
                    return latex;
                } else if (index === 0) {
                    return latex;
                }
                return `\\cdot ${latex}`;
            }).join('');
        case 'Pow':
            const baseLatex = (operand.base.type === 'Variable' || operand.base.type === 'Num')
                ? OperandToLatex(operand.base)
                : `(${OperandToLatex(operand.base)})`;
            const expLatex = (operand.exp.type === 'Variable' || operand.exp.type === 'Num')
                ? OperandToLatex(operand.exp)
                : `(${OperandToLatex(operand.exp)})`;
            return `${baseLatex}^{${expLatex}}`;
        case "Divide":
            return `\\frac{${OperandToLatex(operand.dividend)}}{${OperandToLatex(operand.divisor)}}`
        case "Sqrt":
            return `\\sqrt{${OperandToLatex(operand.operand)}}`
        case 'Neg':
            const negOperandLatex = (operand.operand.type === 'Variable' || operand.operand.type === 'Num' || operand.operand.type === 'Pow')
                ? OperandToLatex(operand.operand)
                : `(${OperandToLatex(operand.operand)})`;
            return `-${negOperandLatex}`;
        default:
            return '';
    }
};

const OperandMathRenderer: React.FC<{ operand: Operand }> = ({operand}) => {
    if (!operand || !operand.type) {
        return <>Error: Invalid operand</>;
    }
    const latex = OperandToLatex(operand);
    return <MathRenderer mathContent={latex}/>;
};


export default OperandMathRenderer;
