package com.first.interview.algorithm;
/*
https://leetcode.com/problems/single-number/solution/

use bitwise operation
a ^ 0 = a
a ^ a = 0

iterate entire array, ^ all bits together to find the unique number
for example 1 ^ 4 ^ 1 = (1 ^ 1) ^ 4 = 0 ^ 4 = 4
 */
public class SingleNumber {
    public int singleNumber(int[] nums){
        int a = 0;

        for (int i : nums) {
            a ^= i;
        }
        return a;
    }
}
