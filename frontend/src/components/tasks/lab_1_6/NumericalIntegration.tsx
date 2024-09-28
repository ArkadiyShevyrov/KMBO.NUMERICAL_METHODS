import React, {useState} from 'react';
import {Alert, Button, Container, Form} from 'react-bootstrap';
import axios from 'axios';
import {NumericalIntegrationInterface, TypeMethod} from "./NumericalIntegrationInterface";
import CopyableResult from "../../CopyableResult";
import {OperandFunctionToJson} from "../../model/function/OperandFunction";
import OperandMathRenderer from "../../model/operand/OperandMathRenderer";
import {MathRenderer} from "../../MathRenderer";

interface NumericalIntegrationProps {
    numericalIntegrationInterface: NumericalIntegrationInterface;
}

const NumericalIntegration: React.FC<NumericalIntegrationProps> = ({numericalIntegrationInterface}) => {
    const [result, setResult] = useState<string | null>(null);
    const [error, setError] = useState<string | null>(null);

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/lab_1_6/integrate',
                OperandFunctionToJson(numericalIntegrationInterface.numericalIntegrationFunctionInterface.operandFunction), {
                    params: {
                        typeMethod: numericalIntegrationInterface.typeMethod,
                        a: numericalIntegrationInterface.numericalIntegrationFunctionInterface.a,
                        b: numericalIntegrationInterface.numericalIntegrationFunctionInterface.b,
                        h: numericalIntegrationInterface.numericalIntegrationFunctionInterface.h
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
            <Form onSubmit={handleSubmit}>
                <Form.Group controlId="formMethod">
                    <Form.Label>Метод интегрирования</Form.Label>
                    <Form.Control
                        as="select"
                        value={numericalIntegrationInterface.typeMethod}
                        onChange={(e) => numericalIntegrationInterface.typeMethod = e.target.value as TypeMethod}>
                        <option value={TypeMethod.RECTANGLE_LEFT_METHOD}>Прямоугольник (левый)</option>
                        <option value={TypeMethod.RECTANGLE_MEDIAN_METHOD}>Прямоугольник (средний)</option>
                        <option value={TypeMethod.RECTANGLE_RIGHT_METHOD}>Прямоугольник (правый)</option>
                        <option value={TypeMethod.TRAPEZOID_METHOD}>Трапеция</option>
                        <option value={TypeMethod.SIMPSON_METHOD}>Симпсон</option>
                    </Form.Control>
                </Form.Group>
                <Form.Group controlId="formFunc">
                    <Form.Label>Функция f(x)</Form.Label>
                    <br/>
                    <Form.Text style={{ fontSize: '1.5rem' }}>
                        <MathRenderer mathContent={"y="}/>
                        <OperandMathRenderer operand={numericalIntegrationInterface.numericalIntegrationFunctionInterface.operandFunction.operand}/>
                    </Form.Text>
                </Form.Group>
                <Form.Group controlId="formA">
                    <Form.Label>Предел a</Form.Label>
                    <Form.Control
                        type="number"
                        value={numericalIntegrationInterface.numericalIntegrationFunctionInterface.a}
                        placeholder="Введите a"
                        required
                    />
                </Form.Group>
                <Form.Group controlId="formB">
                    <Form.Label>Предел b</Form.Label>
                    <Form.Control
                        type="number"
                        value={numericalIntegrationInterface.numericalIntegrationFunctionInterface.b}
                        placeholder="Введите b"
                        required
                    />
                </Form.Group>
                <Form.Group controlId="formH">
                    <Form.Label>Шаг h</Form.Label>
                    <Form.Control
                        type="number"
                        value={numericalIntegrationInterface.numericalIntegrationFunctionInterface.h}
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
    );
};

export default NumericalIntegration;
