import React from 'react';
import Plot from 'react-plotly.js';
import * as Plotly from "plotly.js";

const GraphComponent: React.FC = () => {
    const xValues = Array.from({ length: 100 }, (_, i) => i / 10 - 5); // Генерируем значения x от -5 до 5
    const sineValues = xValues.map(x => Math.sin(x));
    const cosineValues = xValues.map(x => Math.cos(x));
    const parabolaValues = xValues.map(x => x ** 2);

    const data: Plotly.Data[] = [
        {
            x: xValues,
            y: sineValues,
            type: 'scatter',
            mode: 'lines',
            name: 'Sine',
            line: { color: 'blue' },
        },
        {
            x: xValues,
            y: cosineValues,
            type: 'scatter',
            mode: 'lines',
            name: 'Cosine',
            line: { color: 'red' },
        },
        {
            x: xValues,
            y: parabolaValues,
            type: 'scatter',
            mode: 'lines',
            name: 'Parabola',
            line: { color: 'green' },
        },
    ];

    const layout = {
        title: 'Mathematical Functions',
        xaxis: { title: 'X-axis' },
        yaxis: { title: 'Y-axis' },
        showlegend: true,
    };

    return (
        <Plot
            data={data}
            layout={layout}
            config={{
                displaylogo: false,
            }}
            style={{ width: '100%', height: '400px' }}
        />
    );
};

export default GraphComponent;
