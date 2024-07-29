package com.aurionpro.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	System.out.print("Numbner of lines: ");
        int numLines = scanner.nextInt();
     
        
        generatePrimePattern(numLines);
    }

    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void generatePrimePattern(int numLines) {
        List<Integer> primes = new ArrayList<>();
        int num = 2;
        int outputNumbers= 0;
        for(int i =0;i<=numLines;i++) {
        	outputNumbers+=i;
        }
        
        while (primes.size() < outputNumbers) {
            if (isPrime(num)) {
                primes.add(num);
            }
            num++;
        }
        
        int k=0;
        for (int i = 0; i < numLines; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(primes.get(k) + "\t");
                k++;
            }
            System.out.println();
        }
    }
}