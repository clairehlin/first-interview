package com.first.interview.algorithm;

public class RemoveDuplicatesSortedArray {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int count = 0;

        for (int i = 0; i < length - 1 - count; i++) {
            while (nums[i] == nums[i + 1]) {
                shiftArray(i + 1, nums);
                count++;
            }
        }
        return length - count;
    }

    private void shiftArray(int start, int[] nums) {
        while (start < nums.length - 1) {
            nums[start] = nums[start + 1];
            start++;
        }
        nums[nums.length - 1] = Integer.MAX_VALUE;
    }
}
