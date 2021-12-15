package com.first.interview.algorithm;

import java.util.Arrays;

public class SquaresSortedArray {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);

        return nums;
    }
}
