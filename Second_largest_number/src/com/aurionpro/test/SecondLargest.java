package com.aurionpro.test;

import java.util.Scanner;

public class SecondLargest {
	public static void main(String[] args) {
		
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
		
		
		int secondMax = secondLargest(nums);
		if(secondMax!=Integer.MIN_VALUE)
			System.out.println("The second largest number is " + secondMax);
		else
			System.out.println("No second largest number");
	}
	
	
    public static int secondLargest(int[] nums) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax && num < max) {
                secondMax = num;
            }
        }

        return secondMax;
        
    }

}
