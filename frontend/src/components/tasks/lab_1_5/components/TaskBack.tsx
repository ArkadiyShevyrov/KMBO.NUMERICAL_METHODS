import React, {useEffect, useState} from 'react';
import {TaskInterface} from "./TaskInterface";
import axios from "axios";
import {Alert, Button, Container, Form, Table} from "react-bootstrap";
import CopyableResult from "../../../CopyableResult";
import GraphComponent from "./GraphComponent";
import {TabularFunctionInterface} from "../../lab_1_2/components/NumericalDerivativeInterface";
import {MathRenderer} from "../../../MathRenderer";

interface TaskBackProps {
    taskInterface: TaskInterface;
}

const TaskBack: React.FC<TaskBackProps> = ({taskInterface}) => {
    const [tabularFunction, setTabularFunction] =
        useState<TabularFunctionInterface>(taskInterface.tabularFunctionInterface);
    const [xStar, setXStar] =
        useState<number>(0);
    const [degree, setDegree] =
        useState<number>(1);
    const [result, setResult] =
        useState<number | null>(null);
    const [error, setError] =
        useState<string | null>(null);
    const [X, setX] = useState<number[]>([]);
    const [Y, setY] = useState<number[]>([]);


    useEffect(() => {
        setTabularFunction(taskInterface.tabularFunctionInterface)
        let numbers = Array.from(tabularFunction.nodes.keys());
        let start = numbers[0];
        let end = numbers[numbers.length-1];

        const step = 0.5;
        const newX = Array.from(
            {length: Math.floor((end - start) / step) + 1},
            (_, i) => start + i * step
        );

        setX(newX);

    }, [taskInterface]);

    async function extracted() {
        try {
            const [response] = await Promise.all([
                    axios.post('http://localhost:8080/lab_1_5/least-squares-method',
                        {
                            nodes: Object.fromEntries(tabularFunction.nodes)
                        },
                        {
                            params: {
                                x: xStar,
                                degree: degree
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

        try {
            // Создаем массив запросов для каждого значения из X
            const requests = X.map(async (x) => {
                // Отправляем POST-запрос для каждого xValue
                const response = await axios.post(`http://localhost:8080/lab_1_5/least-squares-method`,
                    {
                        nodes: Object.fromEntries(tabularFunction.nodes)
                    },
                    {
                        params: {
                            x: x,
                            degree: degree
                        },
                        headers: {'Content-Type': 'application/json'}
                    }
                );
                return response.data; // Возвращаем результат
            });

            // Ждем выполнения всех запросов
            const results = await Promise.all(requests);

            // Заполняем массив Y результатами
            setY(results);
            setError(null);
        } catch (err: any) {
            if (err.response && err.response.data) {
                setError(err.response.data);
            } else {
                setError(err.message);
            }
            setY([]);
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
                                extracted()
                            }
                        }}
                        placeholder="Введите x"
                        required
                        step={0.1}
                    />
                </Form.Group>
                <Form.Group controlId="formDegree">
                    <Form.Label>degree</Form.Label>
                    <Form.Control
                        type="number"
                        value={degree}
                        onChange={(e) => {
                            const value = parseFloat(e.target.value);
                            if (!isNaN(value)) {
                                setDegree(value);
                            }
                        }}
                        placeholder="Введите degree"
                        required
                        step={1}
                    />
                </Form.Group>
                <Button variant="primary" type="submit">Вычислить</Button>
            </Form>
            {error && <Alert variant="danger" className="mt-3">{error}</Alert>}
            {result != null && <CopyableResult result={X.toString()}/>}
            {result != null && <GraphComponent X={X} Y={Y} x={xStar} y={result} tabularFunction={tabularFunction}/>}
        </Container>
    );
};

export default TaskBack;
