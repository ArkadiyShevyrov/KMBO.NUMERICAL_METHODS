import React from 'react';
import {Table} from "react-bootstrap";
import {MathRenderer} from "../../../MathRenderer";
import {TaskInterface} from "./TaskInterface";
import OperandMathRenderer from "../../../model/operand/OperandMathRenderer";

interface VariantTableProps {
    variantArray: TaskInterface[];
    onSelectVariant: (variant: number) => void;
}

const TaskVariantTable: React.FC<VariantTableProps> = ({variantArray, onSelectVariant}) => {

    const handleRowClick = (variant: number) => {
        onSelectVariant(variant);
    };

    return (
        <div>
            <h4>Выберите вариант</h4>
            <Table striped bordered hover>
                <thead>
                <tr>
                    <th>N</th>
                    <th
                        style={{
                            borderLeft: '4px inset black',
                            borderRight: '2px inset black'
                        }}
                    >
                        i
                    </th>
                    {Array.from(variantArray[0].tabularFunctionInterface.nodes.keys()).map((key, index) => (
                        <th key={index}>{index + 1}</th>
                    ))}
                    <th
                        style={{
                            borderLeft: '4px inset black'
                        }}
                    ><MathRenderer mathContent={"x^*"}/></th>
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
                        <td
                            style={{
                                borderLeft: '4px inset black',
                                borderRight: '2px inset black'
                            }}
                        >
                            <MathRenderer mathContent={"x_i"}/>
                            <br/>
                            <MathRenderer mathContent={"y_i"}/>
                        </td>
                        {Array.from(row.tabularFunctionInterface.nodes.entries()).map(([key, value], index2) => (
                            <td key={index2} style={{ fontSize: '0.8em' }}>
                                {key}
                                <br/>
                                {value}
                            </td>
                        ))}
                        <td
                            style={{
                                borderLeft: '4px inset black'
                            }}
                        >{
                            row.xStar
                        }
                        </td>
                    </tr>
                ))}
                </tbody>
            </Table>
        </div>
    );
};

export default TaskVariantTable;
