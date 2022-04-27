package com.example.spring.exceptions;

public class ProjectAlreadyExistsException extends IllegalStateException {

    public ProjectAlreadyExistsException(String s) {
        super(s);
    }
}
