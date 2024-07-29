package com.aurionpro.test;

import java.util.Arrays;

public class SortedSquares {	
	public static void main(String[] args) {
		int[] nums = {-4, -2, 0, 3, 10};
		int[] result = sortedSquares(nums);
		System.out.println(Arrays.toString(result));
	}
	

    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0, right = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[i] = nums[left] * nums[left];
                left++;
            } else {
                result[i] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }
}
