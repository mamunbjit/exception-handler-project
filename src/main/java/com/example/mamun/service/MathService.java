package com.example.mamun.service;


import com.example.mamun.ExceptionHandlerDemoApplication;
import com.example.mamun.exception.ZeroDivisorException;
import com.example.mamun.exception.NotMyNameException;
import com.example.mamun.exception.OutOfArrayException;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;

@Service
public class MathService {

    public double divide(int dividend, int divisor) {
        return dividend / divisor;
    }

    public static void main(String[] args) {
        SpringApplication.run(ExceptionHandlerDemoApplication.class, args);

        int dividend = 10;
        int divisor = 0;

//        double result = myDiv(dividend, divisor);
//        System.out.println("Result: " + result);


        int[] myArray={1,2,3,4,5};
        int length = myArray.length;

        int index =8;
        if(index < 0 || index >= length){
            throw new OutOfArrayException("Position is outside the Array");
        }else {
            System.out.println("Array value is: " + myArray[index]);
        }





        String myName = "Al Mamun Abdullah";
//        (myName.getClass().getName() == "java.lang.String")

        if( myName != "Al Mamun"){
            throw new NotMyNameException("NotMyNameException: This is not my name");
        }else {
            System.out.println("My name is: " + myName);
        }
    }


    public static double myDiv(int dividend, int divisor) {
        if (divisor == 0) {

            throw new ZeroDivisorException("Division by zero is not allowed");
        }

        return (double) dividend / divisor;
    }

    public  void myDiv(){
        int dividend = 10;
        int divisor = 0;

        if (divisor == 0) {

            throw new ZeroDivisorException("Division by zero is not allowed");
        }

        int result = dividend / divisor;
    }


}
