package com.example.customexception;

import java.time.LocalDateTime;

public class ErrorResponse {
	private String message;
    private LocalDateTime timestamp;
    private int status;

    // Constructor, getters, and setters

    public ErrorResponse(String message, int status) {
        this.message = message;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }

    // Getters and setters
}
