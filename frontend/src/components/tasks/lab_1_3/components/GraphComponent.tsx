import React from 'react';
import Plot from 'react-plotly.js';
import * as Plotly from "plotly.js";

const GraphComponent: React.FC = () => {
    // Параметры масштаба
    const xMin = -100; // Минимальное значение по оси x
    const xMax = 100;  // Максимальное значение по оси x
    const numPoints = 1000; // Количество точек

    // Генерируем значения x в зависимости от масштаба
    const xValues = Array.from({ length: numPoints }, (_, i) => {
        return xMin + (xMax - xMin) * (i / (numPoints - 1));
    });

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
            style={{ width: '100%', height: '400px' }}
        />
    );
};

export default GraphComponent;
