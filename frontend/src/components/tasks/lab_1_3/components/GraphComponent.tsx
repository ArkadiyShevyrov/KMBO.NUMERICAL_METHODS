import React from 'react';
import Plot from 'react-plotly.js';
import * as Plotly from "plotly.js";
import {LayoutAxis} from "plotly.js";

const GraphComponent: React.FC = () => {
    const xValues = Array.from({ length: 100 }, (_, i) => i / 10 - 10); // Генерируем значения x от -5 до 5
    const sineValues = xValues.map(x => Math.sin(x));
    const cosineValues = xValues.map(x => Math.cos(x));

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
        }
    ];

    const layout: Partial<Plotly.Layout> = {
        title: 'Mathematical Functions',
        xaxis: {
            title: 'X-axis',
            nticks: 10,
        },
        yaxis: {
            title: 'Y-axis',
            scaleanchor: 'x', // Привязываем масштаб оси y к оси x
            nticks: 10,
        },
        showlegend: true,
        width: 500, // Устанавливаем ширину графика
        height: 500, // Устанавливаем высоту графика
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
