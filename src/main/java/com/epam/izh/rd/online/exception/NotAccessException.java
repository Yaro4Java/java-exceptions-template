package com.epam.izh.rd.online.exception;

public class NotAccessException extends RuntimeException {
    public NotAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
