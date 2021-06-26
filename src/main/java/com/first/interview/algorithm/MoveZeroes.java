package com.first.interview.algorithm;

public class MoveZeroes {
    public void apply(int[] nums) {
        int count = 0; // count the number of zero

        for (int i = 0; i < nums.length - count - 1; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length - count; j++) {
                    swap(nums, j);
                }
                // if the ith element is still zero, starts all over again
                // for example {0, 0, 1} would need the below if() to work
                if (nums[i] == 0) {
                    i--;
                }
                count++;
            }
        }
    }

    private void swap(int[] nums, int j) {
        int temp = nums[j - 1];
        nums[j - 1] = nums[j];
        nums[j] = temp;
    }
}
