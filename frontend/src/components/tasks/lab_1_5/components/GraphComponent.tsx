import React from 'react';
import Plot from 'react-plotly.js';
import * as Plotly from "plotly.js";
import {TabularFunctionInterface} from "./TaskInterface";

interface GraphComponentProps {
    X: number[]
    Y: number[]
    x: number
    y: number
    tabularFunction: TabularFunctionInterface
}

const GraphComponent: React.FC<GraphComponentProps> = ({X, Y, x, y, tabularFunction}) => {
    // Параметры масштаба
    const xMin = X[0] - 1;
    const xMax = X[X.length - 1] + 1;


    const data: Plotly.Data[] = [
        {
            x: Array.from(tabularFunction.nodes.keys()),
            y: Array.from(tabularFunction.nodes.values()),
            type: 'scatter',
            mode: 'lines+markers',
            name: 'Operand',
            line: {color: 'blue'},
        },
        {
            x: X,
            y: Y,
            type: 'scatter',
            mode: 'lines',
            name: 'Operand',
            line: {color: 'red'},
        },
        {
            x: [x],
            y: [y],
            type: 'scatter',
            mode: 'markers',
            name: `Point`,
            marker: {color: 'green', size: 10},
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
