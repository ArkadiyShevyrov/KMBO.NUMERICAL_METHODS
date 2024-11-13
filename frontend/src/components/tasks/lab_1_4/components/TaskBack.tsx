import React, {useEffect, useState} from 'react';
import {TaskInterface} from "./TaskInterface";
import axios from "axios";
import {Alert, Button, Container, Form, Table} from "react-bootstrap";
import CopyableResult from "../../../CopyableResult";
import {OperandCalculate} from "../../../model/operand/OperandCalculate";
import {TabularFunctionInterface} from "../../lab_1_2/components/NumericalDerivativeInterface";
import {MathRenderer} from "../../../MathRenderer";

interface TaskBackProps {
    taskInterface: TaskInterface;
}

const TaskBack: React.FC<TaskBackProps> = ({taskInterface}) => {
    const [tabularFunction, setTabularFunction] =
        useState<TabularFunctionInterface>(taskInterface.tabularFunctionInterface);
    const [xStar, setXStar] =
        useState<number>(OperandCalculate(taskInterface.xStar));
    const [result, setResult] =
        useState<number | null>(null);
    const [error, setError] =
        useState<string | null>(null);

    useEffect(() => {
        setTabularFunction(taskInterface.tabularFunctionInterface)
        setXStar(taskInterface.xStar);
    }, [taskInterface]);


    async function extracted() {
        try {
            const [response] = await Promise.all([
                    axios.post('http://localhost:8080/lab_1_4/cubic-spline-interpolation',
                        {
                            nodes: Object.fromEntries(tabularFunction.nodes)
                        },
                        {
                            params: {
                                x: xStar,
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
    }

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();


        await extracted();
    };
    return (
        <Container>
            <Form onSubmit={handleSubmit}>
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
                        value={xStar}
                        onChange={(e) => {
                            const value = parseFloat(e.target.value);
                            if (!isNaN(value)) {
                                setXStar(value);
                            }
                        }}
                        placeholder="Введите x"
                        required
                        step={0.1}
                    />
                </Form.Group>
                <Button variant="primary" type="submit">Вычислить</Button>
            </Form>
            {error && <Alert variant="danger" className="mt-3">{error}</Alert>}
            {result != null && <CopyableResult result={result.toString()}/>}
        </Container>
    );
};

export default TaskBack;
