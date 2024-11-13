import React, {useState} from 'react';
import {TaskInterface} from "./components/TaskInterface";
import {Col, Container, Row} from "react-bootstrap";
import TaskVariantTable from "./components/TaskVariantTable";
import TaskBack from "./components/TaskBack";


const Task_1_5: React.FC = () => {
    const [taskInterface, setTaskInterface] =
        useState<TaskInterface>(
            {
                tabularFunctionInterface: {
                    nodes: new Map<number, number>([])
                }
            }
        );

    const numericalArray: TaskInterface[] = [
        {
            tabularFunctionInterface: {
                nodes: new Map<number, number>([
                    [-1.0, -0.5],
                    [0.0, 0.0],
                    [1.0, 0.5],
                    [2.0, 0.86603],
                    [3.0, 1.0],
                    [4.0, 0.86603]
                ])
            }
        },
        {
            tabularFunctionInterface: {
                nodes: new Map<number, number>([
                    [-1.0, 0.86603],
                    [0.0, 1.0],
                    [1.0, 0.86603],
                    [2.0, 0.50],
                    [3.0, 0.0],
                    [4.0, -0.50]
                ])
            }
        },
        {
            tabularFunctionInterface: {
                nodes: new Map<number, number>([
                    [-0.9, -0.36892],
                    [0.0, 0.0],
                    [0.9, 0.36892],
                    [1.8, 0.85408],
                    [2.7, 1.7856],
                    [3.6, 6.3138]
                ])
            }
        },
        {
            tabularFunctionInterface: {
                nodes: new Map<number, number>([
                    [1.0, 2.4142],
                    [1.9, 1.0818],
                    [2.8, 0.50953],
                    [3.7, 0.11836],
                    [4.6, -0.24008],
                    [5.5, -0.66818]
                ])
            }
        },
        {
            tabularFunctionInterface: {
                nodes: new Map<number, number>([
                    [0.1, -2.3026],
                    [0.5, -0.69315],
                    [0.9, -0.10536],
                    [1.3, 0.26236],
                    [1.7, 0.53063],
                    [2.1, 0.74194]
                ])
            }
        },
        {
            tabularFunctionInterface: {
                nodes: new Map<number, number>([
                    [-3.0, 0.04979],
                    [-2.0, 0.13534],
                    [-1.0, 0.36788],
                    [0.0, 1.0],
                    [1.0, 2.7183],
                    [2.0, 7.3891]
                ])
            }
        }
    ];


    const handleVariantSelect = (variant: number) => {
        const selectedVariant = numericalArray[variant - 1];
        setTaskInterface(selectedVariant);
    };

    return (
        <Container>
            <Row className="justify-content-center">
                <Col md={6}>
                    <br/>
                    <h1>Метод наименьших квадратов</h1>
                    <Container>
                        <TaskVariantTable
                            variantArray={numericalArray}
                            onSelectVariant={handleVariantSelect}
                        />
                    </Container>
                    <TaskBack
                        taskInterface={taskInterface}/>
                </Col>
            </Row>
        </Container>
    );
};

export default Task_1_5;
