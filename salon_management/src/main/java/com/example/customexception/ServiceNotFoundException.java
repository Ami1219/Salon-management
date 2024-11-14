package com.example.customexception;

public class ServiceNotFoundException extends RuntimeException {
    public ServiceNotFoundException(String message) {
        super(message); // Pass the error message to the parent RuntimeException class
    }
}