package com.example.mamun.controller;



import com.example.mamun.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.example.mamun.exception.ZeroDivisorException;
import com.example.mamun.exception.OutOfArrayException;
import com.example.mamun.exception.NotMyNameException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@ControllerAdvice


public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({Exception.class})
    public String handleException() {
        return "Exception";
    }

    @ExceptionHandler({ArithmeticException.class})
    public ResponseEntity<?> handleArithmeticException() {
        return new ResponseEntity<>(new CustomException().getMessage(), HttpStatus.BAD_REQUEST);
    }


//    @ExceptionHandler(ZeroDivisorException.class)
//    public ResponseEntity<Object> handleNotFoundException(ZeroDivisorException ex) {
//        // Create a custom error response
//        // You can also log the error here
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource not found");
//    }

    @ExceptionHandler(OutOfArrayException.class)
    public ResponseEntity<String> handleOutOfArrayException(OutOfArrayException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage()); // Return the custom message
    }

    @ExceptionHandler(NotMyNameException.class)
    public ResponseEntity<String> handleNotMyNameException(NotMyNameException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage()); // Return the custom message
    }

    @ExceptionHandler(ZeroDivisorException.class)
    public ResponseEntity<String> handleZeroDivisorException(ZeroDivisorException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}

