package com.aurionpro.test;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayProduct {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the size of the array: ");
		int n = scanner.nextInt();

		int[] arr = new int[n];
		System.out.println("Enter " + n + " elements:");

		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}

		int[] prefix = new int[n];
		int[] suffix = new int[n];
		prefix[0] = 1;
		suffix[n - 1] = 1;

		for (int i = 1; i < n; i++) {
			prefix[i] = prefix[i - 1] * arr[i - 1];
		}

		for (int i = n - 2; i >= 0; i--) {
			suffix[i] = suffix[i + 1] * arr[i + 1];
		}

		int[] prod = new int[n];
		for (int i = 0; i < n; i++) {
			prod[i] = prefix[i] * suffix[i];
		}

		System.out.println("The product array is: " + Arrays.toString(prod));
	}
}
