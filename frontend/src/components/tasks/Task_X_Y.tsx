import React from 'react';
import { Container, Row, Col, Card } from 'react-bootstrap';

const Task_X_Y: React.FC = () => {
    return (
        <Container fluid className="d-flex align-items-center justify-content-center">
            <Row>
                <Col xs={12} sm={12} md={8} lg={8} className="mx-auto">
                    <Card className="text-center shadow-lg">
                        <Card.Body>
                            <Card.Title className="display-4">TODO</Card.Title>
                            <Card.Text className="lead mt-4 mb-4">
                                Эта страница будет доступна в следующих семестрах или по готовности.<br/> Следите за обновлениями!
                            </Card.Text>
                        </Card.Body>
                    </Card>
                </Col>
            </Row>
        </Container>
    );
};

export default Task_X_Y;
