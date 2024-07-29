package com.aurionpro.test;
import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows and columns of the matrices:");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        int[][] a = new int[rows][cols];
        int[][] b = new int[rows][cols];

        System.out.println("Enter elements of first matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                a[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter elements of second matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                b[i][j] = scanner.nextInt();
            }
        }

        int[][] c = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                c[i][j] = 0;
                for (int k = 0; k < cols; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
