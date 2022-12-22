package com.first.interview.solution.based;

public class PermutationArray {
    public int[] buildArray(int[] nums) {
        int[] res = new int[nums.length];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            res[count] = nums[nums[i]];
            count++;
        }

        return res;
    }
}
