package org.example.movieservice.response;

import java.time.LocalDateTime;

public class ResponseStatus<T> {

    private boolean success;
    private String message;
    private T data;
    private LocalDateTime timestamp;

    public ResponseStatus(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.timestamp = LocalDateTime.now();
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}