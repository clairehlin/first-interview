package com.first.interview.algorithm;

public class DecompressEncoded {

    public int[] decompressRLElist(int[] nums) {
        int arraySize = 0;
        for (int i = 0; 2 * i < nums.length; i++) {
            arraySize += nums[2 * i];
        }

        int[] result = new int[arraySize];
        int k = 0;

        for(int i = 0; 2 * i < nums.length; i++) {
            int frequency = nums[2 * i];

            for (int j = 0; j < frequency; j++) {
                result[k] = nums[2 * i + 1];
                k++;
            }
        }
        return result;
    }
}
