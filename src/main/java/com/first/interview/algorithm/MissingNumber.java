package com.first.interview.algorithm;
/*
https://leetcode.com/problems/missing-number/solution/

bit manipulation
iterate integer array
take XOR bit operation on all numbers, numbers position, number length to find missing number
array length ^ array position ^ array value = missing number
for example, [0, 1, 3], corresponding position is 0, 1, 2
array length = 3
3 ^ (0 ^ 0) ^ (1 ^ 1) ^ (2 ^ 3) = (3 ^ 3) ^ (0 ^ 0) ^ (1 ^ 1) ^ 2

 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
    /*
    public int missingNumber(int[] nums) {
        int[] temp = new int[nums.length + 1];

        int count = 0;
        for (int i : nums) {
            if (i == 0) {
                count = 1;
            }

            if (i < nums.length) {
                temp[i] = i;
            }
        }

        if (count != 1) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != i) {
                res = i;
                break;
            }
        }
        return res;
    }

     */
}
