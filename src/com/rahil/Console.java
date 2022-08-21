package com.rahil;

import java.util.Scanner;

public class Console {
    public static double enterNumber(
            String prompt,
            int min,
            int max){
        Scanner scanner = new Scanner(System.in);
        double value = 0;

        while (true) {
            System.out.println(prompt + ": ");
            value = scanner.nextFloat();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a number between " + min + " and " + max);
        }
        return value;
    }
}
