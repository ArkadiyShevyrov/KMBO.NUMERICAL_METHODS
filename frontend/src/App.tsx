import React from 'react';
import {Container, Nav, Navbar} from 'react-bootstrap';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import CalculateSin from './components/lab_1/comp/CalculateSin';
import {MathRenderer} from "./components/MathRenderer";

const App: React.FC = () => {
    return (
        <Router>
            <Navbar bg="light">
                <Container>
                    <Navbar.Brand href="/">Математические функции</Navbar.Brand>
                    <Nav className="me-auto">
                        <Nav.Link href="/sin">
                            <MathRenderer mathContent={"sin(x)"}/>
                        </Nav.Link>
                        <Nav.Link href="/exp">
                            <MathRenderer mathContent={"e^x"}/>
                        </Nav.Link>
                        <Nav.Link href="/lg">
                            <MathRenderer mathContent={"lg(x)"}/>
                        </Nav.Link>
                        <Nav.Link href="/cos">
                            <MathRenderer mathContent={"cos(x)"}/>
                        </Nav.Link>
                        <Nav.Link href="/ln">
                            <MathRenderer mathContent={"ln(x)"}/>
                        </Nav.Link>
                        <Nav.Link href="/log_a">
                            <MathRenderer mathContent={"log_a(x)"}/>
                        </Nav.Link>
                    </Nav>
                </Container>
            </Navbar>
            <br/>
            <Routes>
                <Route path="/sin" element={<CalculateSin/>}/>
            </Routes>
        </Router>
    );
};

export default App;
