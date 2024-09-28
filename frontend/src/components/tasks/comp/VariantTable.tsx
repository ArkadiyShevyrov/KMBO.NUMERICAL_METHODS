import React, {useState} from 'react';
import {Table} from 'react-bootstrap';
import {MathRenderer} from '../../MathRenderer';

const VariantTable: React.FC = () => {
    const [selectedVariant, setSelectedVariant] = useState<number | null>(null);

    const handleRowClick = (variant: number) => {
        setSelectedVariant(variant);
    };

    const rows = [
        {
            variant: 1,
            content: <MathRenderer mathContent={"y=\\frac{x}{2x+5}"}/>,
            a: -1,
            b: 1,
            h: -0.5,
        },
        {
            variant: 2,
            content: <MathRenderer mathContent={"y=\\frac{x}{(3x+4)^2}"}/>,
            a: 0,
            b: 4,
            h: 1.0,
        },
        {
            variant: 3,
            content: <MathRenderer mathContent={"y=\\frac{x}{(3x+4)^3}"}/>,
            a: -1,
            b: 1,
            h: 0.5,
        },
        {
            variant: 4,
            content: <MathRenderer mathContent={"y=\\frac{3x+4}{2x+7}"}/>,
            a: -2,
            b: 2,
            h: 1.0,
        },
        {
            variant: 5,
            content: <MathRenderer mathContent={"y=\\frac{1}{x^2+4}"}/>,
            a: -2,
            b: 2,
            h: 1.0,
        },
        {
            variant: 6,
            content: <MathRenderer mathContent={"y=x\\sqrt{49-x^2}"}/>,
            a: -2,
            b: 2,
            h: 1.0,
        }
    ];

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
                {rows.map((row) => (
                    <tr
                        key={row.variant}
                        onClick={() => handleRowClick(row.variant)}
                        style={{
                            cursor: 'pointer',
                            backgroundColor: selectedVariant === row.variant ? '#a3e8b4' : '#1fc949',
                        }}
                    >
                        <td>{row.variant}</td>
                        <td>{row.content}</td>
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
