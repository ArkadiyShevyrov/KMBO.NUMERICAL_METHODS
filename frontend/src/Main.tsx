import React from "react";
import { Button, Card, Col, Container, Row } from "react-bootstrap";

// Данные о заданиях
const sections = [
    {
        title: "№1. Аппроксимация функций. Численное интегрирование и дифференцирование",
        tasks: [
            "№1.1 Приближенное вычисление элементарных функций",
            "№1.2 Численное дифференцирование",
            "№1.3 Интерполяционные многочлены Лагранжа и Ньютона",
            "№1.4 Интерполяция сплайнами",
            "№1.5 Метод наименьших квадратов",
            "№1.6 Численное интегрирование"
        ]
    },
    {
        title: "№2. Численные методы алгебры",
        tasks: [
            "№2.1 Метод Гаусса",
            "№2.2 Метод прогонки",
            "№2.3 Итерационные методы решения СЛАУ",
            "№2.4 Решение нелинейных уравнений",
            "№2.5 Решение систем нелинейных уравнений",
            "№2.6 Метод вращения Якоби"
        ]
    },
    {
        title: "№3. Численные методы решения дифференциальных уравнений",
        tasks: [
            "№3.1 Метод Эйлера и Эйлера-Коши",
            "№3.2 Метод Рунге-Кутты",
            "№3.3 Метод Адамса",
            "№3.4 Решение задачи Коши для ОДУ второго и более высоких порядков",
            "№3.5 Метод стрельбы",
            "№3.6 Конечно-разностный метод"
        ]
    },
    {
        title: "№4. Численные методы решения уравнений в частных производных",
        tasks: [
            "№4.1 Уравнения параболического типа",
            "№4.2 Уравнения гиперболического типа",
            "№4.3 Уравнения эллиптического типа",
            "№4.4 Метод переменных направлений",
            "№4.5 Метод дробных шагов",
            "№4.6 Решение интегральных уравнений"
        ]
    }
];

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
            {sections.map((section, index) => (
                <Row key={index} className="justify-content-center mb-4">
                    <Col xs="auto">
                        <Card className="my-4 text-left">
                            <Card.Body>
                                <Card.Title>{section.title}</Card.Title>
                                <Card.Text>
                                    {section.tasks.map((task, taskIndex) => (
                                        <Card key={taskIndex} className="my-3">
                                            <Card.Body>
                                                <Card.Title>{task}</Card.Title>
                                                <Card.Text>
                                                </Card.Text>
                                            </Card.Body>
                                        </Card>
                                    ))}
                                </Card.Text>
                            </Card.Body>
                        </Card>
                    </Col>
                </Row>
            ))}
        </Container>
    );
};
