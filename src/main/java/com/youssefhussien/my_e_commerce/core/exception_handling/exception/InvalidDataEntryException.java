package com.youssefhussien.my_e_commerce.core.exception_handling.exception;

public class InvalidDataEntryException extends RuntimeException{

    public InvalidDataEntryException() {
        super();
    }

    public InvalidDataEntryException(String message) {
        super(message);
    }
}
