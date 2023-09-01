package com.example.mamun.exception;

public class CustomException extends Exception {

    private static final String MESSAGE = "Arithmetic Exception";

    public CustomException() {
        super(MESSAGE);
    }
}