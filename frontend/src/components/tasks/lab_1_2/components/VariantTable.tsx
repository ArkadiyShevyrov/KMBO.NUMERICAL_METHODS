import React, {useState} from 'react';
import {Table} from 'react-bootstrap';
import {MathRenderer} from '../../../MathRenderer';

interface VariantTableProps {
    numericalArray: any[];
    onSelectVariant: (variant: number) => void;
}

const VariantTable: React.FC<VariantTableProps> = ({numericalArray, onSelectVariant}) => {
    const [selectedVariant, setSelectedVariant] = useState<number | null>(null);

    const handleRowClick = (variant: number) => {
        setSelectedVariant(variant);
        onSelectVariant(variant);
    };

    return (
        <div>
            <h4>Выберите вариант для дифференцирования</h4>
            <Table striped bordered hover>
                <thead>
                <tr>
                    <th>N</th>
                    <th
                        style={{
                            borderRight: '4px inset black' // Добавляем полоску справа
                        }}
                    >
                        i
                    </th>
                    {Array.from(numericalArray[0].tabularFunctionInterface.nodes.keys()).map((key, index) => (
                        <th key={index}>{index + 1}</th>
                    ))}
                    <th><MathRenderer mathContent={"x^*"}/></th>
                </tr>
                </thead>
                <tbody>
                {numericalArray.map((row, index) => (
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
                                borderRight: '4px inset black' // Полоска в теле таблицы для разделения
                            }}
                        >
                            <MathRenderer mathContent={"x_i"}/>
                            <br/>
                            <MathRenderer mathContent={"y_i"}/>
                        </td>
                        {/*@ts-ignore*/}
                        {Array.from(row.tabularFunctionInterface.nodes.entries()).map(([key, value], index2) => (
                            <td key={index2}>
                                {key}
                                <br/>
                                {value}
                            </td>
                        ))}
                        <td>{row.x}</td>
                    </tr>
                ))}
                </tbody>
            </Table>
        </div>
    );
};

export default VariantTable;
