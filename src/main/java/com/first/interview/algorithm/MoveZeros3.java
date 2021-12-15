package com.first.interview.algorithm;

import java.util.Arrays;

public class MoveZeros3 {
    public void apply(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            int posToSwap;
            if (nums[i] == 0) {
                posToSwap = i;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        swap(nums, posToSwap, j);
                        break;
                    }
                }
            }
        }
    }

    private void swap(int[] nums, int posToSwap, int pos) {
        int temp = nums[posToSwap];
        nums[posToSwap] = nums[pos];
        nums[pos] = temp;
    }

    public static void main(String[] args) {
        MoveZeros3 mz = new MoveZeros3();
        int[] input = {1, 0, 0, 3, 4};
        mz.apply(input);

        System.out.println(Arrays.toString(input));
    }
}
