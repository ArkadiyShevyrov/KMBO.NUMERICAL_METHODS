import React from "react";
import {Button, Card, Col, Container, Row} from "react-bootstrap";

export const Main: React.FC = () => {
    return (
        <Container className="mt-4">
            <header className="text-center mb-4">
                <h1>Численные методы</h1>
                <p className="lead">5-8 семестр</p>
            </header>
            <Row className="justify-content-center mb-4">
                <Col xs="auto">
                    <a href="/chislennye_metody.pdf" download>
                        <Button variant="primary">
                            Скачать PDF файл с заданиями
                        </Button>
                    </a>
                </Col>
            </Row>
            <Row className="justify-content-center mb-4">
                <Col xs="auto">
                    <Card className="my-4 text-left">
                        <Card.Body>
                            <Card.Title>№1. Аппроксимация функций. Численное интегрирование и
                                дифференцирование</Card.Title>
                            <Card.Text>
                                <Card className="my-3">
                                    <Card.Body>
                                        <Card.Title>№1.1 Приближенное вычисление элементарных функций</Card.Title>
                                        <Card.Text>
                                        </Card.Text>
                                    </Card.Body>
                                </Card>
                                <Card className="my-3">
                                    <Card.Body>
                                        <Card.Title>№1.2 Численное дифференцирование</Card.Title>
                                        <Card.Text>
                                        </Card.Text>
                                    </Card.Body>
                                </Card>
                                <Card className="my-3">
                                    <Card.Body>
                                        <Card.Title>№1.3 Интерполяционные многочлены Лагранжа и Ньютона</Card.Title>
                                        <Card.Text>
                                        </Card.Text>
                                    </Card.Body>
                                </Card>
                                <Card className="my-3">
                                    <Card.Body>
                                        <Card.Title>№1.4 Интерполяция сплайнами</Card.Title>
                                        <Card.Text>
                                        </Card.Text>
                                    </Card.Body>
                                </Card>
                                <Card className="my-3">
                                    <Card.Body>
                                        <Card.Title>№1.5 Метод наименьших квадратов</Card.Title>
                                        <Card.Text>
                                        </Card.Text>
                                    </Card.Body>
                                </Card>
                                <Card className="my-3">
                                    <Card.Body>
                                        <Card.Title>№1.6 Численное интегрирование</Card.Title>
                                        <Card.Text>
                                        </Card.Text>
                                    </Card.Body>
                                </Card>
                            </Card.Text>
                        </Card.Body>
                    </Card>
                </Col>
            </Row>
        </Container>
    );
};
