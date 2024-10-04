import {MathRenderer} from "../../MathRenderer";
import React from "react";
import CalculateSin from "./component/CalculateSin";
import CustomTabs from "../../custom/CustomTabs";
import CalculateExp from "./component/CalculateExp";
import CalculateLg from "./component/CalculateLg";
import CalculateCos from "./component/CalculateCos";
import CalculateLn from "./component/CalculateLn";
import CalculateLog from "./component/CalculateLog";

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