import React, {useState} from 'react';
import {TaskInterface} from "./components/TaskInterface";
import {Col, Container, Row} from "react-bootstrap";
import TaskVariantTable from "./components/TaskVariantTable";
import {MathRenderer} from "../../MathRenderer";
import TaskBack from "./components/TaskBack";
import GraphComponent from "./components/GraphComponent";


const Task_1_3: React.FC = () => {
    const PI = 3.14159265359

    const [taskInterface, setTaskInterface] =
        useState<TaskInterface>(
            {
                operandFunction: {
                    operand: {
                        type: "Num",
                        num: 0
                    },
                    variable: {
                        type: "Variable",
                        name: "x"
                    }
                },
                X: [],
                xStar: 0
            }
        );

    const numericalArray: TaskInterface[] = [
        {
            operandFunction: {
                operand: {
                    type: "Sin",
                    operand: {
                        type: "Variable",
                        name: "x"
                    }
                },
                variable: {
                    type: "Variable",
                    name: "x"
                }
            },
            X: [0.1 * PI, 0.2 * PI, 0.3 * PI, 0.4 * PI],
            xStar: PI / 4
        },
        {
            operandFunction: {
                operand: {
                    type: "Cos",
                    operand: {
                        type: "Variable",
                        name: "x"
                    }
                },
                variable: {
                    type: "Variable",
                    name: "x"
                }
            },
            X: [0, PI / 6, 2 * PI / 6, 3 * PI / 6],
            xStar: PI / 4
        },
        {
            operandFunction: {
                operand: {
                    type: "Exp",
                    operand: {
                        type: "Variable",
                        name: "x"
                    }
                },
                variable: {
                    type: "Variable",
                    name: "x"
                }
            },
            X: [-2, -1, 0, 1],
            xStar: -0.5
        },
        {
            operandFunction: {
                operand: {
                    type: "Sqrt",
                    operand: {
                        type: "Variable",
                        name: "x"
                    }
                },
                variable: {
                    type: "Variable",
                    name: "x"
                }
            },
            X: [0, 1.7, 3.4, 5.1],
            xStar: 3.0
        },
        {
            operandFunction: {
                operand: {
                    type: "Multiply",
                    operands: [
                        {
                            type: "Variable",
                            name: "x"
                        },
                        {
                            type: "Sin",
                            operand: {
                                type: "Variable",
                                name: "x"
                            }
                        }
                    ]
                },
                variable: {
                    type: "Variable",
                    name: "x"
                }
            },
            X: [0, PI / 6, 2 * PI / 6, 3 * PI / 6],
            xStar: PI / 4
        },
        {
            operandFunction: {
                operand: {
                    type: "Multiply",
                    operands: [
                        {
                            type: "Pow",
                            base: {
                                type: "Variable",
                                name: "x"
                            },
                            exp: {
                                type: "Num",
                                num: 2
                            }
                        },
                        {
                            type: "Exp",
                            operand: {
                                type: "Variable",
                                name: "x"
                            }
                        }
                    ]
                },
                variable: {
                    type: "Variable",
                    name: "x"
                }
            },
            X: [-1.2, -0.7, -0.2, 0.3],
            xStar: -0.5
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
                    <h1>Интерполяционные многочлены Лагранжа и Ньютона</h1>
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

            <GraphComponent/>
            <br/>
            <br/>
            <br/>
            Ньютон
            <br/>
            <MathRenderer mathContent={
                "P_n(x)=\\sum_{k=0}^{n}(f(x_0, ..., x_k) \\cdot \\prod_{i=0}^{k-1} (x-x_i))"
            }/>
            <br/>
            <MathRenderer mathContent={
                "f(x_0,...,x_k)=\\sum_{i=0}^{k} (\\frac{f(x_i)}{\\prod_{j=0, j\\ne i}^{k} (x_i-x_j)})"
            }/>
            <br/>
            Лаграндж
            <br/>
            <MathRenderer mathContent={
                "L(x)=\\sum_{i=0}^n (f(x_i) \\cdot \\prod_{j=0, j\\ne i}^{n} (\\frac{x-x_j}{x_i-x_j}))"
            }/>
        </Container>
    );
};

export default Task_1_3;
