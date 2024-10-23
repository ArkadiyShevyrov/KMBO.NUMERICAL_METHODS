import React, {useState} from 'react';
import {Table} from "react-bootstrap";
import {MathRenderer} from "../../../MathRenderer";
import {TaskInterface} from "./TaskInterface";
import OperandMathRenderer from "../../../model/operand/OperandMathRenderer";

interface VariantTableProps {
    variantArray: TaskInterface[];
    onSelectVariant: (variant: number) => void;
}

const TaskVariantTable: React.FC<VariantTableProps> = ({variantArray, onSelectVariant}) => {
    const [selectedVariant, setSelectedVariant] = useState<number | null>(null);

    const handleRowClick = (variant: number) => {
        setSelectedVariant(variant);
        onSelectVariant(variant);
    };

    return (
        <div>
            <h4>Выберите вариант</h4>
            <Table striped bordered hover>
                <thead>
                <tr>
                    <th>N</th>
                    <th><MathRenderer mathContent={"f(x)"}/></th>
                    <th><MathRenderer mathContent={"x^*"}/></th>
                </tr>

                </thead>
                <tbody>
                {variantArray.map((row, index) => (
                    <tr
                        key={index}
                        onClick={() => handleRowClick(index + 1)}
                        style={{
                            cursor: 'pointer',
                        }}
                    >
                        <td>{index + 1}</td>
                        <td><OperandMathRenderer operand={row.operandFunction.operand}/></td>
                        <td>{row.xStar}</td>
                    </tr>
                ))}
                </tbody>
            </Table>
        </div>
    );
};

export default TaskVariantTable;
