import React, {useState} from 'react';
import {Col, Container, Row} from 'react-bootstrap';
import {NumericalDerivativeInterface} from "./components/NumericalDerivativeInterface";
import VariantTable from "./components/VariantTable";
import NumericalDerivative from "./components/NumericalDerivative";

const Task_X_Y: React.FC = () => {

    const [numericalDerivativeFunctionInterface, setNumericalDerivativeFunctionInterface] =
        useState<NumericalDerivativeInterface>({
            x: 0,
            tabularFunctionInterface: {
                nodes: new Map<number, number>([])
            }
        });

    const numericalArray: NumericalDerivativeInterface[] = [
        {
            x: 1.0,
            tabularFunctionInterface: {
                nodes: new Map<number, number>([
                    [-1.0, -0.5],
                    [0.0, 0.0],
                    [1.0, 0.5],
                    [2.0, 0.86603],
                    [3.0, 1.0]
                ])
            }
        },
        {
            x: 2.0,
            tabularFunctionInterface: {
                nodes: new Map<number, number>([
                    [1.0, 0.0],
                    [1.5, 0.40547],
                    [2.0, 0.69315],
                    [2.5, 0.91629],
                    [3.0, 1.0986]
                ])
            }
        }, {
            x: 0.2,
            tabularFunctionInterface: {
                nodes: new Map<number, number>([
                    [0.0, 1.0],
                    [0.1, 1.1052],
                    [0.2, 1.2214],
                    [0.3, 1.3499],
                    [0.4, 1.4918]
                ])
            }
        }, {
            x: 2.0,
            tabularFunctionInterface: {
                nodes: new Map<number, number>([
                    [0.0, 0.0],
                    [1.0, 1.0],
                    [2.0, 1.4142],
                    [3.0, 1.7321],
                    [4.0, 2.0]
                ])
            }
        }, {
            x: 0.2,
            tabularFunctionInterface: {
                nodes: new Map<number, number>([
                    [-0.2, -0.20136],
                    [0.0, 0.0],
                    [0.2, 0.20136],
                    [0.4, 0.41152],
                    [0.6, 0.6435]
                ])
            }
        }, {
            x: 0.2,
            tabularFunctionInterface: {
                nodes: new Map<number, number>([
                    [-0.2, 1.7722],
                    [0.0, 1.5708],
                    [0.2, 1.3694],
                    [0.4, 1.1593],
                    [0.6, 0.9273]
                ])
            }
        }
    ];

    const handleVariantSelect = (variant: number) => {
        const selectedVariant = numericalArray[variant - 1];
        setNumericalDerivativeFunctionInterface(selectedVariant);
    };

    return (
        <Container>
            <Row className="justify-content-center">
                <Col md={6}>
                    <br/>
                    <h1>Численное дифференцирование</h1>
                    <Container>
                        <VariantTable
                            numericalArray={numericalArray}
                            onSelectVariant={handleVariantSelect}
                        />
                    </Container>
                    <NumericalDerivative
                        numericalDerivativeInterface={numericalDerivativeFunctionInterface}/>
                </Col>
            </Row>
        </Container>
    );
};

export default Task_X_Y;
