package com.aurionpro.test;

import java.util.Scanner;

public class ATMSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = 1000.00;
        int option=-1;

        while (option != 4) {
            System.out.println("ATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Please choose an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Your current balance is: $" + balance);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    balance += depositAmount;
                    System.out.println("You have deposited $" + depositAmount + ". Your new balance is $" + balance);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (withdrawAmount <= balance) {
                        balance -= withdrawAmount;
                        System.out.println("You have withdrawn $" + withdrawAmount + ". Your new balance is $" + balance);
                    } else {
                        System.out.println("Insufficient funds. Your balance is $" + balance);
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid input. Please select correct option");
                    break;
            }
        }
    }
}