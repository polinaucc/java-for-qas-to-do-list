package com.todo.list.exception;

public class CannotProcessOperationException extends RuntimeException {
    public CannotProcessOperationException(String message) {
        super(message);
    }
}
