package com.example.mamun.controller;


import com.example.mamun.service.MathService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.mamun.exception.NotMyNameException;
import com.example.mamun.exception.OutOfArrayException;
import com.example.mamun.exception.ZeroDivisorException;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final MathService mathService;

    public DemoController(MathService mathService) {
        this.mathService = mathService;
    }


    @GetMapping("/get-array-element")
    public ResponseEntity<String> getArrayElement(@RequestParam int[] array, @RequestParam int index) {

        if (index < 0 || index >= array.length) {
            throw new OutOfArrayException("OutOfArrayException: Index is out of bounds for -> " + index);
        }

        int element = array[index];
        return ResponseEntity.ok("Array element at index " + index + ": " + element);
    }


    @GetMapping("/check-name")
    public ResponseEntity<String> checkName(@RequestParam String name) {
        if ("Al Mamun".equals(name)) {
            return ResponseEntity.ok("My name is: Al Mamun");
        } else {
            throw new NotMyNameException("NotMyNameException: This is not my name");
        }
    }


    @GetMapping("/zero-divisor")
    public ResponseEntity<String> zerodivisor(@RequestParam int dividend, @RequestParam int divisor) {
        if (divisor == 0) {
            throw new ZeroDivisorException("ZeroDivisorException: Division by zero is not allowed");
        }

        double result = (double) dividend / divisor;
        return ResponseEntity.ok("Result: " + result);
    }


//    @GetMapping("/divide/{dividend}/{divisor}")
//    public ResponseEntity<String> divide(@PathVariable int dividend, @PathVariable int divisor) {
//        try {
//            double result = mathService.divide(dividend, divisor);
//            return ResponseEntity.ok("Result: " + result);
//        } catch (ArithmeticException ex) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                    .body("Arithmetic exception occurred: " + ex.getMessage());
//        }
//    }


}
