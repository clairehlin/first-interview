package com.first.interview.algorithm;

public class SingleNumber {
    public int singleNumber(int[] nums){
        int a = 0;

        for (int i : nums) {
            a ^= i;
        }
        return a;
    }
}
