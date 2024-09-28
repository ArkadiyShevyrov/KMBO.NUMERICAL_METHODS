import React, {useState} from 'react';
import {Alert, Button, Container, Form} from 'react-bootstrap';
import axios from 'axios';
import {NumericalIntegrationInterface} from "./NumericalIntegrationInterface";
import CopyableResult from "../../CopyableResult";

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
                numericalIntegrationInterface.numericalIntegrationFunctionInterface.operandFunction, {
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
                <Button variant="primary" type="submit">Вычислить</Button>
            </Form>
            {error && <Alert variant="danger" className="mt-3">{error}</Alert>}
            {result && <CopyableResult result={result}/>}
        </Container>
    );
};

export default NumericalIntegration;
