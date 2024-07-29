package com.aurionpro.test;

import java.util.Scanner;

public class DistanceCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter x1 y1 x2 y2:");
        Integer x1 = scanner.nextInt();
        Integer y1 = scanner.nextInt();
        Integer x2 = scanner.nextInt();
        Integer y2 = scanner.nextInt();

        Double distance =  Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));;

        System.out.println("The distance between the points is: "+distance);
    }
}
