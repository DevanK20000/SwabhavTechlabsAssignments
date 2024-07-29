package com.aurionpro.test;
import java.util.Scanner;

public class CurrencyApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter withdrawal amount: ");
        int amount = scanner.nextInt();

        if (amount > 50000) {
            System.out.println("Amount exceeds withdrawal limit of 50000");
        } else if (amount % 100 != 0) {
            System.out.println("Amount should be in multiples of 100");
        } else {
            int num2000 = amount / 2000;
            amount %= 2000;
            int num500 = amount / 500;
            amount %= 500;
            int num200 = amount / 200;
            amount %= 200;
            int num100 = amount / 100;

            System.out.println("Two Thousand: " + num2000);
            System.out.println("Five Hundred: " + num500);
            System.out.println("Two Hundred: " + num200);
            System.out.println("Hundred: " + num100);
        }

        scanner.close();
    }
}
