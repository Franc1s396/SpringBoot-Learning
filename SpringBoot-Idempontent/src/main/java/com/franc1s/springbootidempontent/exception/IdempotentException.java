package com.franc1s.springbootidempontent.exception;


public class IdempotentException extends Exception {
    public IdempotentException(String message) {
        super(message);
    }
}
