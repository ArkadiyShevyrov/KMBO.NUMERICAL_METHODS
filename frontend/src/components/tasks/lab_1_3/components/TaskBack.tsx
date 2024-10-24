import React, {useEffect, useState} from 'react';
import {TaskInterface} from "./TaskInterface";
import axios from "axios";
import {Alert, Button, Container, Form} from "react-bootstrap";
import CopyableResult from "../../../CopyableResult";
import {OperandFunction} from "../../../model/function/OperandFunction";
import {Operand} from "../../../model/operand/Operand";
import {OperandCalculate} from "../../../model/operand/OperandCalculate";
import OperandMathRenderer from "../../../model/operand/OperandMathRenderer";
import GraphComponent from "./GraphComponent";

enum Type {
    LAGRANGE_INTERPOLATION = "lagrange-interpolation",
    NEWTON_INTERPOLATION = "newton-interpolation",
}

interface TaskBackProps {
    taskInterface: TaskInterface;
}

const TaskBack: React.FC<TaskBackProps> = ({taskInterface}) => {
    const [type, setType] =
        useState<Type>(Type.LAGRANGE_INTERPOLATION);
    const [operandFunction, setOperandFunction] =
        useState<OperandFunction>(taskInterface.operandFunction);
    const [X, setX] = useState<number[]>(
        Array.isArray(taskInterface.X) && taskInterface.X.length > 0 && typeof taskInterface.X[0] !== 'number'
            ? (taskInterface.X as Operand[]).map(OperandCalculate)
            : taskInterface.X as number[]
    );
    const [xStar, setXStar] =
        useState<number>(OperandCalculate(taskInterface.xStar));
    const [result, setResult] =
        useState<number | null>(null);
    const [error, setError] =
        useState<string | null>(null);
    const [Y, setY] =
        useState<number[]>([])

    useEffect(() => {
        setOperandFunction(taskInterface.operandFunction)
        if (Array.isArray(taskInterface.X) && taskInterface.X.length > 0) {
            if (typeof taskInterface.X[0] !== 'number') {
                const calculatedX = (taskInterface.X as Operand[]).map(OperandCalculate);
                setX(calculatedX);
            } else {
                setX(taskInterface.X as number[]);
            }
        }
        setXStar(OperandCalculate(taskInterface.xStar));
    }, [taskInterface]);

    const createNodes = (X: number[] | Operand[], operandFunction: OperandFunction): Map<number, number> => {
        const nodes = new Map<number, number>();

        X.forEach(item => {
            let x;
            if (typeof item === 'number') {
                x = item;
            } else {
                x = OperandCalculate(item)
            }
            let y = OperandCalculate(operandFunction.operand, x)
            nodes.set(x, y);
        });

        return nodes;
    };

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        try {
            const [response] = await Promise.all([
                    axios.post('http://localhost:8080/lab_1_3/' + type,
                        {
                            nodes: Object.fromEntries(createNodes(X, operandFunction))
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

        try {
            // Создаем массив запросов для каждого значения из X
            const requests = X.map(async (x) => {
                // Отправляем POST-запрос для каждого xValue
                const response = await axios.post(`http://localhost:8080/lab_1_3/${type}`,
                    {
                        nodes: Object.fromEntries(createNodes([x], operandFunction))
                    },
                    {
                        params: { x }, // Передаем x в параметры запроса
                        headers: { 'Content-Type': 'application/json' }
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
    };
    return (
        <Container>
            <Form onSubmit={handleSubmit}>
                <Form.Group controlId="formMethod">
                    <Form.Label>Метод интегрирования</Form.Label>
                    <Form.Control
                        as="select"
                        value={type}
                        onChange={(e) => setType(e.target.value as Type)}>
                        <option value={Type.LAGRANGE_INTERPOLATION}>Интерполяционный полином Лагранжа</option>
                        <option value={Type.NEWTON_INTERPOLATION}>Интерполяционный полином Ньютона</option>
                    </Form.Control>
                </Form.Group>
                <Form.Group controlId="formFunc">
                    <Form.Label>Функция f(x)</Form.Label>
                    <br/>
                    <Form.Text>
                            <OperandMathRenderer operand={operandFunction.operand}/>
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
            {result && <GraphComponent operand={operandFunction.operand} X={X} Y={Y} x={xStar} y={result}/>}
        </Container>
    );
};

export default TaskBack;
