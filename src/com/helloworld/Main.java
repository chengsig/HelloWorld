package com.helloworld;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        //primitive types don't need new to be declared
        byte age = 30;
        long viewsCount = 3_123_456_789L; //same as 3123456789 but without L it will think the number is too large
        float price = 10.99F; //java sees 10.99 as double without F
        char letter = 'A'; //single char with single quote
        boolean isEligible = true; //
        // a new instance of the class Date
        Date now = new Date(); //declaring Reference type need a new to allocate memory
        System.out.println(now); // short-cut: sout + tab
    }

}
