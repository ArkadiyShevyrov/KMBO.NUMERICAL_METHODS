import katex from 'katex';
import 'katex/dist/katex.min.css';
import React from "react";

export const MathRenderer: React.FC<{ mathContent: string }> = ({mathContent}) => {

    const renderedContent = katex.renderToString(mathContent, {
        throwOnError: false,
        // output: 'mathml'
    });

    const style = {
        fontSize: '1em',
    };

    return <span style={style} dangerouslySetInnerHTML={{__html: renderedContent}}/>;
};