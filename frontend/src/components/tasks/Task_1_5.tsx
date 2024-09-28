import React from 'react';
import {Container} from 'react-bootstrap';
import OperandMathRenderer from "../model/operand/OperandMathRenderer";
import {Operand} from "../model/operand/Operand";

const Task_1_5: React.FC = () => {
    const exampleOperand: Operand = {
        type: "Multiply",
        operands: [
            {
                type: "Variable",
                name: "x"
            },
            {
                type: "Pow",
                base: {
                    type: "Add",
                    operands: [
                        {
                            type: "Multiply",
                            operands: [
                                { type: "Num", num: 2.0 },
                                { type: "Variable", name: "x" }
                            ]
                        },
                        { type: "Num", num: 5.0 }
                    ]
                },
                exp: { type: "Num", num: -1.0 }
            }
        ]
    };
    return (
        <Container>
            <br/>
            <OperandMathRenderer operand={exampleOperand}/>
        </Container>
    );
};

export default Task_1_5;
