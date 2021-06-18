package com.first.interview.algorithm;
/*
Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

Return the running sum of nums.

leetcode 1480
*/


public class RunningSum {
    public int[] runningSum(int[] nums) {
        int sum = 0;
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result[i] = sum;
        }

        return result;
    }
}
