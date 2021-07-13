package com.first.interview.algorithm;

public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        int soFarMax = nums[0];
        int globalMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            soFarMax = Math.max(soFarMax + nums[i], nums[i]);
            globalMax = Math.max(globalMax, soFarMax);
        }

        return globalMax;
    }
}
