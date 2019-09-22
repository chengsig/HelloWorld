package com.helloworld;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.awt.*;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

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

        //prime characteristic
        byte x = 1;
        byte y = x;
        // x and y are independent of each other memory wise so changing x will not change y
        x = 2;
        System.out.println(y);
        //reference types memory is the address of reference, not the actual value
        // point1 and point2 are reference the same address that pointing to Point(1, 1)
        // they are not independent of each other
        Point point1 = new Point(1, 1);
        Point point2 = point1;
        point1.x = 2;
        System.out.println(point2);

        // java strings are immutable; any method that modifies a string will return a new object
        String message = "Hello World!" + "!!";
        System.out.println(message.toLowerCase());
        System.out.println(message.replace("!!", "*"));
        System.out.println("     hello world    ".trim()); // trim deosn't trim the one space in between words

        String msg = "hello \"John\"";
        System.out.println(msg);

        String sysMsg = "c:\\Windows\\...";
        System.out.println(sysMsg);
        String newLine = "c:\nWindows\\...";
        System.out.println(newLine);

        //arrays
        int[] numbers = new int[5]; //specify size of the array
        numbers[0] = 1;
        numbers[1] = 2;
        //numbers[10] = 3; // Exception: java raised errors
        //System.out.println(numbers); //[I@15aeb7ab will print the location in memory of this array
        System.out.println(Arrays.toString(numbers)); //[1, 2, 0, 0, 0] default to 0 for unassigned
        int[] nums = {2, 3, 5, 1, 4}; // java arrays have a fixed size
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        int[][] matrix = new int[2][3];
        //or
        int[][] m = {{1, 2, 3}, {4, 5, 6}};
        matrix[0][0] = 1;
        System.out.println(Arrays.deepToString(matrix));
        System.out.println(Arrays.deepToString(m));

        //keep a number const, use final. should use all cap
        final float PI = 3.14F;

        //arithmetic expressions
        double result = (double) 10 / (double) 3;
        System.out.println(10/3); // 3
        System.out.println(result); // 3.333333

        int v = 1;
        v++; // same as post fix ++v
        int z = v++; // x will first be copied to y, then x will be incremented to 2
        // print x, y will be 2, 1
        // but if prefix y = ++x;
        //print x, y will be 2, 2
        System.out.println(z);

        // implicit casting and type conversion - happens when data will not be lost
        short s = 1;
        int r = s + 2;
        System.out.println(r); //3. short byte: 2, int byte 4.
        // java implicit casting (automatic conversion) byte > short > int > long
        double dou = 1.1;
        double res = dou + 2; // 3.1: double + integer (less precise so will be auto casted to 2.0)
        int get3 = (int) dou + 2; // 3
        String str = "1";
        get3 = Integer.parseInt(str) + 2; // Integer is the wrapper class
        // if Integer.parseInt(float string "1.1") will get Exception error => Double.parseDouble("1.1")

        Math.round(1.1F); // int 1. round returns a long not an int
        //Math.round(); returns a double 0-1
        int roundRandomRes = (int) Math.round(Math.random() * 100); // int 0-100

        // abstract class can't create a new instance with the new instead use factory method below
        NumberFormat currency = NumberFormat.getCurrencyInstance(); //.getPercentInstance()
        String resCurrency = currency.format(12345.891); // string rep in currency
        System.out.println(resCurrency); //$12,345.89
        //method chaining
        String perc = NumberFormat.getPercentInstance().format(0.1);
        System.out.println(perc); // 10%

//        Scanner scanner = new Scanner(System.in); // can type number in terminal and see result
//        System.out.print("enter age: "); // can only enter integer
        //byte ageScan = scanner.nextByte();
        //System.out.println("You are " + ageScan); // implicit casting/conversion
//        System.out.print("enter your name: ");
//        String yourName = scanner.nextLine().trim();
//        System.out.println("my name is " + yourName);

        //Mortgage calculator
        final byte MONTH_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: "); // if enter non int will crash the program, use conditional logic later
        int principal = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        float annualInterest = scanner.nextFloat(); // interest rate is small enough don't need double
        float monthlyInterest = annualInterest / PERCENT / MONTH_IN_YEAR;

        System.out.print("Period (Years): ");
        byte years = scanner.nextByte();
        int numberOfPayments = years * MONTH_IN_YEAR;

        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                                    / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        String mortgageFormated = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormated);
    }

}
