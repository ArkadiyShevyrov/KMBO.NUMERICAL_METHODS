import React from 'react';
import {Container, Nav, Navbar, NavDropdown} from 'react-bootstrap';
import {BrowserRouter as Router, Link, Route, Routes} from 'react-router-dom';
import Task_1_1 from "./components/tasks/Task_1_1";
import Task_1_5 from "./components/tasks/Task_1_5";
import Task_1_6 from "./components/tasks/Task_1_6";
import {Main} from "./Main";

const App: React.FC = () => {
    return (
        <Router>
            <Navbar bg="dark" variant="dark" expand="sm" sticky="top">
                <Container fluid>
                    <Navbar.Brand as={Link} to="/">Задания</Navbar.Brand>
                    <Navbar.Toggle aria-controls="basic-navbar-nav" />
                    <Navbar.Collapse id="basic-navbar-nav">
                        <Nav className="me-auto my-2 my-lg-0" navbarScroll>
                            {['1', '2', '3', '4'].map(part => (
                                <NavDropdown key={part} title={`Задания №${part}.1-6`} id={`navbarScrollingDropdown${part}`}>
                                    {Array.from({ length: 6 }, (_, index) => (
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
                    <Route path="/task_1_1" element={<Task_1_1/>}/>
                    <Route path="/task_1_5" element={<Task_1_5/>}/>
                    <Route path="/task_1_6" element={<Task_1_6/>}/>
                </Routes>
            </Container>
        </Router>
    );
};

export default App;
