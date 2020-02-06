package com.epam.izh.rd.online.exception;

public class NotCorrectPasswordException extends RuntimeException {
    public NotCorrectPasswordException(String message) {
        super(message);
    }
}
