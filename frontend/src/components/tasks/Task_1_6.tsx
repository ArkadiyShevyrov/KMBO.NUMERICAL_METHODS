import React, {useState} from 'react';
import {Alert, Button, Col, Container, Form, ListGroup, ListGroupItem, Row} from 'react-bootstrap';
import axios from 'axios';
import CopyableResult from '../CopyableResult';
import {MathRenderer} from "../MathRenderer";
import VariantTable from "./comp/VariantTable";

const Task_1_6: React.FC = () => {
    const [typeMethod, setTypeMethod] = useState<string>("RECTANGLE_LEFT_METHOD");
    const [a, setA] = useState<string>('');
    const [b, setB] = useState<string>('');
    const [h, setH] = useState<string>('');
    const [result, setResult] = useState<string | null>(null);
    const [error, setError] = useState<string | null>(null);

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        try {
            const operandFunction = {
                type: "OperandFunction",
                operand: {
                    type: "Multiply",
                    operands: [
                        {type: "Variable", name: "x"},
                        {
                            type: "Pow",
                            base: {
                                type: "Add",
                                operands: [
                                    {
                                        type: "Multiply",
                                        operands: [
                                            {type: "Num", num: 2.0},
                                            {type: "Variable", name: "x"}
                                        ]
                                    },
                                    {type: "Num", num: 5.0}
                                ]
                            },
                            exp: {type: "Num", num: -1.0}
                        }
                    ]
                },
                variable: {type: "Variable", name: "x"}
            };

            const response = await axios.post('http://localhost:8080/lab_1_6/integrate', operandFunction, {
                params: {
                    typeMethod: typeMethod,
                    a: a,
                    b: b,
                    h: h
                },
                headers: {
                    'Content-Type': 'application/json'
                }
            });
            setResult(response.data);
            setError(null);
        } catch (err: any) {
            if (err.response && err.response.data) {
                setError(err.response.data);
            } else {
                setError(err.message);
            }
            setResult(null);
        }
    };

    return (
        <Container>
            <Row className="justify-content-center">
                <Col md={6}>
                    <Container>
                        <h1>Численное интегрирование</h1>
                    </Container>
                    <Container>
                        <VariantTable/>
                    </Container>
                    <Container>
                        <Form onSubmit={handleSubmit}>
                            <Form.Group controlId="formMethod">
                                <Form.Label>Метод интегрирования</Form.Label>
                                <Form.Control as="select" value={typeMethod}
                                              onChange={(e) => setTypeMethod(e.target.value)}>
                                    <option value="RECTANGLE_LEFT_METHOD">Прямоугольник (левый)</option>
                                    <option value="RECTANGLE_MEDIAN_METHOD">Прямоугольник (средний)</option>
                                    <option value="RECTANGLE_RIGHT_METHOD">Прямоугольник (правый)</option>
                                    <option value="TRAPEZOID_METHOD">Трапеция</option>
                                    <option value="SIMPSON_METHOD">Симпсон</option>
                                </Form.Control>
                            </Form.Group>
                            <Form.Group controlId="formA">
                                <Form.Label>Предел a</Form.Label>
                                <Form.Control
                                    type="number"
                                    value={a}
                                    onChange={(e) => setA(e.target.value)}
                                    placeholder="Введите a"
                                    required
                                />
                            </Form.Group>
                            <Form.Group controlId="formB">
                                <Form.Label>Предел b</Form.Label>
                                <Form.Control
                                    type="number"
                                    value={b}
                                    onChange={(e) => setB(e.target.value)}
                                    placeholder="Введите b"
                                    required
                                />
                            </Form.Group>
                            <Form.Group controlId="formH">
                                <Form.Label>Шаг h</Form.Label>
                                <Form.Control
                                    type="number"
                                    value={h}
                                    onChange={(e) => setH(e.target.value)}
                                    placeholder="Введите h"
                                    step="0.1"
                                    required
                                />
                            </Form.Group>
                            <Button variant="primary" type="submit">Вычислить</Button>
                        </Form>
                        {error && <Alert variant="danger" className="mt-3">{error}</Alert>}
                        {result && <CopyableResult result={result}/>}
                    </Container>
                </Col>
            </Row>
        </Container>
    );
};

export default Task_1_6;
