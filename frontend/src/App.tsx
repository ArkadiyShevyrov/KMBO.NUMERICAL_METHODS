import React from 'react';
import {Container, Nav, Navbar, NavDropdown} from 'react-bootstrap';
import {BrowserRouter as Router, Link, Route, Routes} from 'react-router-dom';
import Task_1_1 from "./components/tasks/Task_1_1";
import Task_X_Y from "./components/tasks/Task_X_Y";
import Task_1_6 from "./components/tasks/Task_1_6";
import {Main} from "./Main";

const tasks = [
    {path: "/task_1_1", element: <Task_1_1/>},
    {path: "/task_1_2", element: <Task_X_Y/>},
    {path: "/task_1_3", element: <Task_X_Y/>},
    {path: "/task_1_4", element: <Task_X_Y/>},
    {path: "/task_1_5", element: <Task_X_Y/>},
    {path: "/task_1_6", element: <Task_1_6/>},
    {path: "/task_2_1", element: <Task_X_Y/>},
    {path: "/task_2_2", element: <Task_X_Y/>},
    {path: "/task_2_3", element: <Task_X_Y/>},
    {path: "/task_2_4", element: <Task_X_Y/>},
    {path: "/task_2_5", element: <Task_X_Y/>},
    {path: "/task_2_6", element: <Task_X_Y/>},
    {path: "/task_3_1", element: <Task_X_Y/>},
    {path: "/task_3_2", element: <Task_X_Y/>},
    {path: "/task_3_3", element: <Task_X_Y/>},
    {path: "/task_3_4", element: <Task_X_Y/>},
    {path: "/task_3_5", element: <Task_X_Y/>},
    {path: "/task_3_6", element: <Task_X_Y/>},
    {path: "/task_4_1", element: <Task_X_Y/>},
    {path: "/task_4_2", element: <Task_X_Y/>},
    {path: "/task_4_3", element: <Task_X_Y/>},
    {path: "/task_4_4", element: <Task_X_Y/>},
    {path: "/task_4_5", element: <Task_X_Y/>},
    {path: "/task_4_6", element: <Task_X_Y/>}
];

const App: React.FC = () => {
    return (
        <Router>
            <Navbar bg="dark" variant="dark" expand="sm" sticky="top">
                <Container fluid>
                    <Navbar.Brand as={Link} to="/">Задания</Navbar.Brand>
                    <Navbar.Toggle aria-controls="basic-navbar-nav"/>
                    <Navbar.Collapse id="basic-navbar-nav">
                        <Nav className="me-auto my-2 my-lg-0" navbarScroll>
                            {['1', '2', '3', '4'].map(part => (
                                <NavDropdown key={part} title={`Задания №${part}.1-6`}
                                             id={`navbarScrollingDropdown${part}`}>
                                    {Array.from({length: 6}, (_, index) => (
                                        <NavDropdown.Item key={index} as={Link} to={`/task_${part}_${index + 1}`}>
                                            Задача №{part}.{index + 1}
                                        </NavDropdown.Item>
                                    ))}
                                </NavDropdown>
                            ))}
                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>

            <Container className="mt-4">
                <Routes>
                    <Route path="/" element={<Main/>}/>
                    {tasks.map((task, index) => (
                        <Route key={index} path={task.path} element={task.element}/>
                    ))}
                </Routes>
            </Container>
        </Router>
    );
};

export default App;
