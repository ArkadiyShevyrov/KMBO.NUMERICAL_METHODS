import React, { useState } from 'react';
import { Table } from 'react-bootstrap';
import { MathRenderer } from '../../MathRenderer';
import OperandMathRenderer, {OperandToLatex} from "../../model/operand/OperandMathRenderer";

interface VariantTableProps {
    numericalArray: any[]; // Adjust type as needed
    onSelectVariant: (variant: number) => void;
}

const VariantTable: React.FC<VariantTableProps> = ({ numericalArray, onSelectVariant }) => {
    const [selectedVariant, setSelectedVariant] = useState<number | null>(null);

    const handleRowClick = (variant: number) => {
        setSelectedVariant(variant);
        onSelectVariant(variant); // Call the parent function to set the selected variant
    };

    return (
        <div>
            <h3>Выберите вариант для интегрирования</h3>
            <Table striped bordered hover>
                <thead>
                <tr>
                    <th>Вариант</th>
                    <th>Функция f(x)</th>
                    <th>a</th>
                    <th>b</th>
                    <th>h</th>
                </tr>
                </thead>
                <tbody>
                {numericalArray.map((row, index) => (
                    <tr
                        key={index}
                        onClick={() => handleRowClick(index+1)}
                        style={{
                            cursor: 'pointer',
                            backgroundColor: selectedVariant === row.variant ? '#a3e8b4' : '#1fc949',
                        }}
                    >
                        <td>{index+1}</td>
                        <td><MathRenderer mathContent={"y="+OperandToLatex(row.operandFunction.operand)}/></td>
                        <td>{row.a}</td>
                        <td>{row.b}</td>
                        <td>{row.h}</td>
                    </tr>
                ))}
                </tbody>
            </Table>

            {selectedVariant && (
                <div className="mt-3">
                    <h4>Выбранный вариант: {selectedVariant}</h4>
                </div>
            )}
        </div>
    );
};

export default VariantTable;
