import React from 'react';
import {Container, Nav, Navbar} from 'react-bootstrap';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import {MathRenderer} from "./components/MathRenderer";
import Task_1 from "./components/tasks/Task_1";

const App: React.FC = () => {
    return (
        <Router>
            <Navbar bg="light">
                <Container>
                    <Navbar.Brand href="/">Задания: </Navbar.Brand>
                    <Nav className="me-auto">
                        <Nav.Link href="/task_1">
                            <MathRenderer mathContent={"Задача №1"}/>
                        </Nav.Link>
                        <Nav.Link href="/task_2">
                            <MathRenderer mathContent={"Задача №2"}/>
                        </Nav.Link>
                        <Nav.Link href="/task_3">
                            <MathRenderer mathContent={"Задача №3"}/>
                        </Nav.Link>
                        <Nav.Link href="/task_4">
                            <MathRenderer mathContent={"Задача №4"}/>
                        </Nav.Link>
                        <Nav.Link href="/task_5">
                            <MathRenderer mathContent={"Задача №5"}/>
                        </Nav.Link>
                        <Nav.Link href="/task_6">
                            <MathRenderer mathContent={"Задача №6"}/>
                        </Nav.Link>
                    </Nav>
                </Container>
            </Navbar>
            <Routes>
                <Route path="/task_1" element={<Task_1/>}/>
            </Routes>
        </Router>
    );
};

export default App;
