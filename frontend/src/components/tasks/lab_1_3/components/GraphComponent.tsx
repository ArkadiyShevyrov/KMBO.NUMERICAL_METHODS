import React from 'react';
import Plot from 'react-plotly.js';
import * as Plotly from "plotly.js";
import {Operand} from "../../../model/operand/Operand";
import {OperandCalculate} from "../../../model/operand/OperandCalculate";

interface GraphComponentProps {
    operand: Operand;
    X: number[]
    Y: number[]
    x: number
    y: number
}

const GraphComponent: React.FC<GraphComponentProps> = ({operand, X, Y, x, y}) => {
    // Параметры масштаба
    const xMin = X[0]-1; // Минимальное значение по оси x
    const xMax = X[X.length-1]+1;  // Максимальное значение по оси x
    const numPoints = 1000; // Количество точек

    // Генерируем значения x в зависимости от масштаба
    const xValues = Array.from({length: numPoints}, (_, i) => {
        return xMin + (xMax - xMin) * (i / (numPoints - 1));
    });

    const operandValues = xValues.map(x => OperandCalculate(operand, x));

    const data: Plotly.Data[] = [
        {
            x: xValues,
            y: operandValues,
            type: 'scatter',
            mode: 'lines',
            name: 'Sine',
            line: {color: 'blue'},
        },
        {
            x: X,
            y: Y,
            type: 'scatter',
            mode: 'lines',
            name: 'operand',
            line: {color: 'red'},
        },
    ];

    const layout: Partial<Plotly.Layout> = {
        title: 'Mathematical Functions',
        xaxis: {
            title: 'X-axis',
            range: [xMin, xMax],
            nticks: 12,
        },
        yaxis: {
            title: 'Y-axis',
            range: [-1, 1],
            scaleanchor: 'x',
            nticks: 12,
        },
        showlegend: true,
        width: 500,
        height: 500,
    };

    return (
        <Plot
            data={data}
            // @ts-ignore
            layout={layout}
            config={{
                displaylogo: false,
            }}
            style={{width: '100%', height: '400px'}}
        />
    );
};

export default GraphComponent;
