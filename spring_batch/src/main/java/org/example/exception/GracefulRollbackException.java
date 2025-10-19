package org.example.exception;

public class GracefulRollbackException extends RuntimeException {
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this; // disable stack trace
    }

    public GracefulRollbackException(String message) {
        super(message);
    }
}
