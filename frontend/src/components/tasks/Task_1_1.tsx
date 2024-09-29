import {MathRenderer} from "../MathRenderer";
import React from "react";
import CalculateSin from "./lab_1_1/CalculateSin";
import CustomTabs from "../custom/CustomTabs";
import CalculateExp from "./lab_1_1/CalculateExp";
import CalculateLg from "./lab_1_1/CalculateLg";
import CalculateCos from "./lab_1_1/CalculateCos";
import CalculateLn from "./lab_1_1/CalculateLn";
import CalculateLog from "./lab_1_1/CalculateLog";

const Task_1_1 = () => {
    const tabsData = [
        {
            title: <MathRenderer mathContent={"sin(x)"}/>,
            body: <CalculateSin/>,
        },
        {
            title: <MathRenderer mathContent={"e^x"}/>,
            body: <CalculateExp/>,
        },
        {
            title: <MathRenderer mathContent={"lg(x)"}/>,
            body: <CalculateLg/>,
        },
        {
            title: <MathRenderer mathContent={"cos(x)"}/>,
            body: <CalculateCos/>,
        },
        {
            title: <MathRenderer mathContent={"ln(x)"}/>,
            body: <CalculateLn/>,
        },
        {
            title: <MathRenderer mathContent={"log_a(x)"}/>,
            body: <CalculateLog/>,
        },
    ]
    return (
        <CustomTabs tabsData={tabsData}/>
    )
}

export default Task_1_1;