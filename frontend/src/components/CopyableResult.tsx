import React, {useState} from 'react';
import {Alert, Button} from 'react-bootstrap';

const CopyableResult = ({result}: { result: string }) => {
    const [copied, setCopied] = useState(false);

    const handleCopy = () => {
        navigator.clipboard.writeText(result);
        setCopied(true);
        setTimeout(() => setCopied(false), 2000); // Сброс сообщения через 2 секунды
    };

    return (
        <Alert
            variant="success"
            style={{
                position: 'relative',
                display: 'flex',
                flexDirection: 'column',
                alignItems: 'center',
                justifyContent: 'center',
                paddingBottom: '0'
            }}
        >
            <div
                style={{
                    alignSelf: 'flex-start',
                    textAlign: 'left',
                }}
            >
                <b>Результат:</b>
            </div>
            <hr style={{
                width: '100%',
                margin: '1px'
            }}/>
            <div
                style={{
                    flex: 1,
                    display: 'flex',
                    justifyContent: 'center',
                    alignItems: 'center',
                    width: '100%',
                }}
            >
                {result}
            </div>
            <hr style={{
                width: '100%',
                margin: '1px'
            }}/>
            <div
                style={{
                    alignSelf: 'flex-end',
                    textAlign: 'right',
                }}
            >
                {!copied && (
                    <Button
                        variant="outline-secondary"
                        size="sm"
                        onClick={handleCopy}
                        style={{
                            fontSize: '0.75rem',
                            padding: '0.25rem 0.5rem',
                            marginTop: '5px',
                            marginBottom: '5px',
                        }}
                    >
                        Копировать результат
                    </Button>
                )}
                {copied && (
                    <Button
                        variant="outline-secondary"
                        size="sm"
                        style={{
                            fontSize: '0.75rem',
                            padding: '0.25rem 0.5rem',
                            marginTop: '5px',
                            marginBottom: '5px',
                            color: 'green',
                        }}
                    >
                        Скопировано!
                    </Button>
                )}
            </div>
        </Alert>
    );
};

export default CopyableResult;
