package org.example.movieservice.exception;

import org.example.movieservice.response.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<ResponseStatus<Void>> handleMovieNotFound(
            MovieNotFoundException exception) {

        ResponseStatus<Void> response = new ResponseStatus<>(
                false,
                exception.getMessage(),
                null
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseStatus<Void>> handleGenericException(
            Exception exception) {

        ResponseStatus<Void> response = new ResponseStatus<>(
                false,
                "Something went wrong. Please try again later...",
                null
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }
}