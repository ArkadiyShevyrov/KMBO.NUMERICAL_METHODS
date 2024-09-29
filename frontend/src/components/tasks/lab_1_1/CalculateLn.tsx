import React, {useState} from 'react';
import {Alert, Button, Col, Container, Form, Row} from 'react-bootstrap';
import axios from 'axios';
import CopyableResult from '../../CopyableResult';
import {MathRenderer} from "../../MathRenderer";

const CalculateLn: React.FC = () => {
    const [x, setX] = useState<string>('');
    const [precision, setPrecision] = useState<string>('1e-10');
    const [result, setResult] = useState<string | null>(null);
    const [error, setError] = useState<string | null>(null);

    const handleCalculate = async (e: React.FormEvent) => {
        e.preventDefault();
        try {
            const response = await axios.get('http://localhost:8080/lab_1_1/ln', {
                params: {x: String(x), predication: String(precision)},
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
                    <h2>Вычисление <MathRenderer mathContent={"ln(x)"}/></h2>
                    <Form onSubmit={handleCalculate}>
                        <Form.Group controlId="formX">
                            <Form.Label>Введите значение x</Form.Label>
                            <Form.Control
                                type="text"
                                value={x}
                                onChange={(e) => setX(e.target.value)}
                                placeholder="Например, 1.570796"
                            />
                        </Form.Group>
                        <Form.Group controlId="formPrecision">
                            <Form.Label>Точность</Form.Label>
                            <Form.Control
                                type="text"
                                value={precision}
                                onChange={(e) => setPrecision(e.target.value)}
                                placeholder="Например, 1e-10"
                            />
                        </Form.Group>
                        <Button variant="primary" type="submit">
                            Вычислить
                        </Button>
                    </Form>
                    {error && <Alert variant="danger">{error}</Alert>}
                    {result && <CopyableResult result={result}/>}
                </Col>
            </Row>
        </Container>
    );
};

export default CalculateLn;
