import React, {useEffect, useState} from 'react';
import {Alert, Button, Container, Form, Table} from 'react-bootstrap';
import {NumericalDerivativeInterface, TabularFunctionInterface} from "./NumericalDerivativeInterface";
import CopyableResult from "../../../CopyableResult";
import axios from "axios";
import {MathRenderer} from "../../../MathRenderer";

enum Type {
    FIRST_DERIVATIVE = "FIRST_DERIVATIVE",
    SECOND_DERIVATIVE = "SECOND_DERIVATIVE",
}

interface NumericalDerivativeProps {
    numericalDerivativeInterface: NumericalDerivativeInterface;
}

const NumericalDerivative: React.FC<NumericalDerivativeProps> = ({numericalDerivativeInterface}) => {
    const [typeDerivative, setTypeDerivative] =
        useState<Type>(Type.FIRST_DERIVATIVE);
    const [tabularFunction, setTabularFunction] =
        useState<TabularFunctionInterface>(numericalDerivativeInterface.tabularFunctionInterface);
    const [x, setX] =
        useState<number>(numericalDerivativeInterface.x);
    const [result, setResult] =
        useState<string | null>(null);
    const [error, setError] =
        useState<string | null>(null);

    useEffect(() => {
        setTabularFunction(numericalDerivativeInterface.tabularFunctionInterface)
        setX(numericalDerivativeInterface.x);
    }, [numericalDerivativeInterface]);

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        console.log(tabularFunction)
        try {
            const [response] = await Promise.all([
                    axios.post('http://localhost:8080/lab_1_2/first-derivative',
                        {
                            nodes: Object.fromEntries(tabularFunction.nodes)
                        },
                        {
                            params: {
                                xStar: x,
                            },
                            headers: {
                                'Content-Type': 'application/json'
                            }
                        })
                ])
            ;
            setResult(response.data);
            setError(null);

        } catch (err: any) {
            if (err.response && err.response.data) {
                setError(err.response.data);
                setResult(null);
            } else {
                setError(err.message);
                setResult(null);
            }
        }
    };
    return (
        <Container>
            <Form onSubmit={handleSubmit}>
                <Form.Group controlId="formMethod">
                    <Form.Label>Метод интегрирования</Form.Label>
                    <Form.Control
                        as="select"
                        value={typeDerivative}
                        onChange={(e) => setTypeDerivative(e.target.value as Type)}>
                        <option value={Type.FIRST_DERIVATIVE}>Первая производная</option>
                        <option value={Type.SECOND_DERIVATIVE}>Вторая производная</option>
                    </Form.Control>
                </Form.Group>
                <Form.Group controlId="formFunc">
                    <Form.Label>Функция f(x)</Form.Label>
                    <br/>
                    <Form.Text style={{fontSize: '1.5rem'}}>
                        <div style={{
                            border: '1px solid #ced4da',
                            borderRadius: '0.375rem',
                            padding: '0.375rem 0.75rem',
                            fontSize: '0.75rem',
                            backgroundColor: '#fff'
                        }}>
                            <Table striped bordered hover>
                                <thead>
                                <tr>
                                    <th
                                        style={{
                                            borderRight: '4px inset black' // Добавляем полоску справа
                                        }}
                                    >
                                        i
                                    </th>
                                    {Array.from(tabularFunction.nodes.keys()).map((key, index) => (
                                        <th key={index}>{index + 1}</th>
                                    ))}
                                </tr>
                                </thead>
                                <tbody>
                                <tr
                                    style={{
                                        cursor: 'pointer',
                                    }}
                                >
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
                                    {Array.from(tabularFunction.nodes.entries()).map(([key, value], index2) => (
                                        <td key={index2}>
                                            {key}
                                            <br/>
                                            {value}
                                        </td>
                                    ))}
                                </tr>
                                </tbody>
                            </Table>
                        </div>
                    </Form.Text>
                </Form.Group>
                <Form.Group controlId="formX">
                    <Form.Label>Предел x</Form.Label>
                    <Form.Control
                        type="number"
                        value={x}
                        onChange={(e) => {
                            const value = parseFloat(e.target.value);
                            if (!isNaN(value)) {
                                setX(value);
                            }
                        }}
                        placeholder="Введите x"
                        required
                    />
                </Form.Group>
                <Button variant="primary" type="submit">Вычислить</Button>
            </Form>
            {error && <Alert variant="danger" className="mt-3">{error}</Alert>}
            {result != null && <CopyableResult result={result}/>}
        </Container>
    );
};

export default NumericalDerivative;
