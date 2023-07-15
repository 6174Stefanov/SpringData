package com.softuni.game_store.exceptions;

public class ValidationException extends RuntimeException{
    public ValidationException(String reason) {
        super(reason);
    }
}
