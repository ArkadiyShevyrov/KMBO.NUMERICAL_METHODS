import React, { useState } from 'react';
import { Col, Container, Row } from 'react-bootstrap';
import VariantTable from "./comp/VariantTable";
import NumericalIntegration from "./lab_1_6/NumericalIntegration";
import {
    NumericalIntegrationFunctionInterface,
    NumericalIntegrationInterface,
    TypeMethod
} from "./lab_1_6/NumericalIntegrationInterface";
import { OperandFunction } from "../model/function/OperandFunction";

const Task_1_6: React.FC = () => {
    const [numericalIntegrationFunctionInterface, setNumericalIntegrationFunctionInterface] =
        useState<NumericalIntegrationFunctionInterface>({
            a: 0,
            b: 0,
            h: 0,
            operandFunction: {} as OperandFunction // Set a proper initial value
        });

    const [numericalIntegrationI, setNumericalIntegrationI] =
        useState<NumericalIntegrationInterface>({
            typeMethod: TypeMethod.RECTANGLE_LEFT_METHOD,
            numericalIntegrationFunctionInterface
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
        }
    ];

    const handleVariantSelect = (variant: number) => {
        const selectedVariant = numericalArray[variant - 1]; // Adjust for 0-indexed array

        setNumericalIntegrationFunctionInterface(selectedVariant);
        setNumericalIntegrationI(prev => ({
            ...prev,
            numericalIntegrationFunctionInterface: selectedVariant
        }));
    };

    return (
        <Container>
            <Row className="justify-content-center">
                <Col md={6}>
                    <Container>
                        <h1>Численное интегрирование</h1>
                    </Container>
                    <Container>
                        <VariantTable
                            numericalArray={numericalArray}
                            onSelectVariant={handleVariantSelect}
                        />
                    </Container>
                    <NumericalIntegration numericalIntegrationInterface={numericalIntegrationI} />
                </Col>
            </Row>
        </Container>
    );
};

export default Task_1_6;
