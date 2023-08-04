package com.example.users.users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserControllerHandler {

    @ExceptionHandler(UserInputInvalidException.class)
    public ResponseEntity<ErrorResponse> invalid(UserInputInvalidException e){
        ErrorResponse errorResponse = new ErrorResponse(400, e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.OK);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> invalid(UserNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse(4567, e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.OK);
    }
}
