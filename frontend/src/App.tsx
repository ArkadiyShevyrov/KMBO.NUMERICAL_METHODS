import React from 'react';
import {Nav, Navbar} from 'react-bootstrap';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import Task_1_1 from "./components/tasks/Task_1_1";
import Task_1_6 from "./components/tasks/Task_1_6";

const App: React.FC = () => {
    return (
        <Router>
            <Navbar bg="light">
                <Navbar.Brand href="/">Задания: </Navbar.Brand>
                <Nav className="me-auto">
                    <Nav.Link href="/task_1_1">
                        Задача №1.1
                    </Nav.Link>
                    <Nav.Link href="/task_1_2">
                        Задача №1.2
                    </Nav.Link>
                    <Nav.Link href="/task_1_3">
                        Задача №1.3
                    </Nav.Link>
                    <Nav.Link href="/task_1_4">
                        Задача №1.4
                    </Nav.Link>
                    <Nav.Link href="/task_1_5">
                        Задача №1.5
                    </Nav.Link>
                    <Nav.Link href="/task_1_6">
                        Задача №1.6
                    </Nav.Link>
                </Nav>
            </Navbar>
            <Routes>
                <Route path="/task_1_1" element={<Task_1_1/>}/>
                <Route path="/task_1_6" element={<Task_1_6/>}/>
            </Routes>
        </Router>
    );
};

export default App;
