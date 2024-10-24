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
                    <th
                        style={{
                            borderLeft: '4px inset black',
                            borderRight: '2px inset black'
                        }}
                    >
                        i
                    </th>
                    {variantArray[0].X.map((key, index) => (
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
                        <td><OperandMathRenderer operand={row.operandFunction.operand}/></td>
                        <td
                            style={{
                                borderLeft: '4px inset black',
                                borderRight: '2px inset black'
                            }}
                        >
                            <MathRenderer mathContent={"x_i"}/>
                        </td>
                        {/*@ts-ignore*/}
                        {Array.from(row.X).map(value => (
                            <td>

                                {typeof value === "number" ? (
                                    <span>{value}</span>
                                ) : (
                                    <OperandMathRenderer operand={value}/>
                                )}
                            </td>
                        ))}
                        <td
                            style={{
                                borderLeft: '4px inset black'
                            }}
                        >{
                            typeof row.xStar === "number" ? (
                                <span>{row.xStar}</span>
                            ) : (
                                <OperandMathRenderer operand={row.xStar}/>
                            )
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
