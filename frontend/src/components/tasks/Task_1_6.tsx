import React, {useState} from 'react';
import {Col, Container, Row} from 'react-bootstrap';
import VariantTable from "./lab_1_6/VariantTable";
import NumericalIntegration from "./lab_1_6/NumericalIntegration";
import {NumericalIntegrationFunctionInterface} from "./lab_1_6/NumericalIntegrationInterface";

const Task_1_6: React.FC = () => {
    const [numericalIntegrationFunctionInterface, setNumericalIntegrationFunctionInterface] =
        useState<NumericalIntegrationFunctionInterface>({
            a: 0,
            b: 0,
            h: 0,
            operandFunction: {
                operand: {
                    type: "Num",
                    num: 0
                },
                variable: {
                    type: "Variable",
                    name: "x"
                }
            }
        });

    const numericalArray: NumericalIntegrationFunctionInterface[] = [
        {
            a: -1,
            b: 1,
            h: 0.5,
            operandFunction: {
                operand: {
                    type: "Divide",
                    dividend: {
                        type: "Variable",
                        name: "x"
                    },
                    divisor: {
                        type: "Add",
                        operands: [
                            {
                                type: "Multiply",
                                operands: [
                                    {
                                        type: "Num",
                                        num: 2
                                    },
                                    {
                                        type: "Variable",
                                        name: "x"
                                    }
                                ]
                            },
                            {
                                type: "Num",
                                num: 5
                            }
                        ]
                    }
                },
                variable: {
                    type: "Variable",
                    name: "x"
                }
            }
        },
        {
            a: 0,
            b: 4,
            h: 1.0,
            operandFunction: {
                operand: {
                    type: "Divide",
                    dividend: {
                        type: "Variable",
                        name: "x"
                    },
                    divisor: {
                        type: "Pow",
                        base: {
                            type: "Add",
                            operands: [
                                {
                                    type: "Multiply",
                                    operands: [
                                        {
                                            type: "Num",
                                            num: 3
                                        },
                                        {
                                            type: "Variable",
                                            name: "x"
                                        }
                                    ]
                                },
                                {
                                    type: "Num",
                                    num: 4
                                }
                            ]
                        },
                        exp: {
                            type: "Num",
                            num: 2
                        }
                    }
                },
                variable: {
                    type: "Variable",
                    name: "x"
                }
            }
        },
        {
            a: -1,
            b: 1,
            h: 0.5,
            operandFunction: {
                operand: {
                    type: "Divide",
                    dividend: {
                        type: "Variable",
                        name: "x"
                    },
                    divisor: {
                        type: "Pow",
                        base: {
                            type: "Add",
                            operands: [
                                {
                                    type: "Multiply",
                                    operands: [
                                        {
                                            type: "Num",
                                            num: 3
                                        },
                                        {
                                            type: "Variable",
                                            name: "x"
                                        }
                                    ]
                                },
                                {
                                    type: "Num",
                                    num: 4
                                }
                            ]
                        },
                        exp: {
                            type: "Num",
                            num: 3
                        }
                    }
                },
                variable: {
                    type: "Variable",
                    name: "x"
                }
            }
        },
        {
            a: -2,
            b: 2,
            h: 1.0,
            operandFunction: {
                operand: {
                    type: "Divide",
                    dividend: {
                        type: "Add",
                        operands: [
                            {
                                type: "Multiply",
                                operands: [
                                    {
                                        type: "Num",
                                        num: 3
                                    },
                                    {
                                        type: "Variable",
                                        name: "x"
                                    }
                                ]
                            },
                            {
                                type: "Num",
                                num: 4
                            }
                        ]
                    },
                    divisor: {
                        type: "Add",
                        operands: [
                            {
                                type: "Multiply",
                                operands: [
                                    {
                                        type: "Num",
                                        num: 2
                                    },
                                    {
                                        type: "Variable",
                                        name: "x"
                                    },
                                ]
                            },
                            {
                                type: "Num",
                                num: 7
                            }
                        ]
                    }
                },
                variable: {
                    type: "Variable",
                    name: "x"
                }
            }
        },
        {
            a: -2,
            b: 2,
            h: 1.0,
            operandFunction: {
                operand: {
                    type: "Divide",
                    dividend: {
                        type: "Num",
                        num: 1
                    },
                    divisor: {
                        type: "Add",
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
                                type: "Num",
                                num: 4
                            }
                        ]
                    }
                },
                variable: {
                    type: "Variable",
                    name: "x"
                }
            }
        },
        {
            a: -2,
            b: 2,
            h: 1.0,
            operandFunction: {
                operand: {
                    type: "Multiply",
                    operands: [
                        {
                            type: "Variable",
                            name: "x"
                        },
                        {
                            type: "Sqrt",
                            operand: {
                                type: "Add",
                                operands: [
                                    {
                                        type: "Num",
                                        num: 49
                                    },
                                    {
                                        type: "Neg",
                                        operand: {
                                            type: "Pow",
                                            base: {
                                                type: "Variable",
                                                name: "x"
                                            },
                                            exp: {
                                                type: "Num",
                                                num: 2
                                            }
                                        }
                                    }
                                ]
                            }
                        }
                    ]
                },
                variable: {
                    type: "Variable",
                    name: "x"
                }
            }
        }
    ];

    const handleVariantSelect = (variant: number) => {
        const selectedVariant = numericalArray[variant - 1];
        setNumericalIntegrationFunctionInterface(selectedVariant);
    };

    return (
        <Container>
            <Row className="justify-content-center">
                <Col md={6}>
                    <br/>
                    <Container>
                        <h1>Численное интегрирование</h1>
                    </Container>
                    <Container>
                        <VariantTable
                            numericalArray={numericalArray}
                            onSelectVariant={handleVariantSelect}
                        />
                    </Container>
                    <NumericalIntegration
                        numericalIntegrationFunctionInterface={numericalIntegrationFunctionInterface}/>
                </Col>
            </Row>
        </Container>
    );
};

export default Task_1_6;
