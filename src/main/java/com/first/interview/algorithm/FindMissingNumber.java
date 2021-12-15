package com.first.interview.algorithm;

// find a missing number in a given int[]{1...n}
public class FindMissingNumber {
    int find(int[] nums) {
        int count = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != count) {
                break;
            } else {
                count++;
            }
        }

        return count;
    }
}
