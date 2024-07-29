package com.aurionpro.test;

import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        playGame(scanner);
        scanner.close();
    }

    public static void playGame(Scanner scanner) {
        int targetNumber = (int) (Math.random() * 100) + 1;
        int tries = 0;

        while (true) {
            System.out.print("Guess the number (between 1 and 100): ");
            int userGuess;
            try {
                userGuess = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();
                continue;
            }

            tries++;

            if (userGuess == targetNumber) {
                System.out.println("Congratulations! You guessed the correct number " + targetNumber + " in " + tries + " tries.");
                break;
            } else if (userGuess < targetNumber) {
                System.out.println("Sorry, Too Low.");
            } else {
                System.out.println("Sorry, Too High.");
            }
        }

        System.out.print("Do you want to play again? (y/n): ");
        String playAgain = scanner.next().toLowerCase();
        if (playAgain.equals("y")) {
            playGame(scanner);
        } else {
            System.out.println("Thanks for playing! Goodbye.");
        }
    }
}

