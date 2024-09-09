import {Tabs, Tab} from 'react-bootstrap';
import './MyTabs.css';
import React from "react";

interface TabsData {
    title: React.ReactNode;
    body: React.ReactNode
}

interface CustomTabsProps {
    tabsData: TabsData[]
}

const CustomTabs: React.FC<CustomTabsProps> = (props) => {
    return (
        <Tabs
            variant="pills"
            fill
            justify
            defaultActiveKey="1"
            id="tabs-example"
            className="custom-tab mb-3">
            {props.tabsData.map((value, index) => (
                <Tab key={index} eventKey={index + 1} title={value.title}>
                    {value.body}
                </Tab>
            ))}
        </Tabs>

    )
};

export default CustomTabs;
