package com.first.interview.algorithm;

import java.util.Arrays;
/*
https://leetcode.com/problems/plus-one/submissions/
66. Plus One
Easy

5169

4422

Add to List

Share
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.



Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].
Example 3:

Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].
----------------------------------------------
keep track of the value on the 10th position of sum, for example, sum = 9 + 1 = 10, keep track of 1 (carry = 1)
take value on last position of the array, plus 1
if sum >= 10, keep track of (sum % 10)
replace the last int in the array with 0
if sum < 10, replace the last in  the array with sum

iterate array from the 2nd to the last position
calculate the total value in each position with the tracked value

new tracked value = sum % 10
replace value in each position = total / 10

if the final carry is not equal to 0, create a new int array
assign the first position of the new int array = carry
copy the rest of the digits array into the new int array, starting from 2nd position of the new int array


 */
public class PlusOne2 {
    public int[] apply(int[] digits) {
        int carry = 0;
        int length = digits.length;
        int num = digits[length - 1] + 1 + carry;
        if (num == 10) {
            digits[length - 1] = 0;
            carry = 1;
        } else {
            digits[length - 1] = num;
        }

        for (int i = length - 2; i >= 0; i--) {
            int temp = digits[i];
            digits[i] = (temp + carry) % 10;
            carry = (temp + carry) / 10;
        }

        if (carry != 0) {
            int[] res = new int[length + 1];
            System.arraycopy(digits, 0, res, 1, length);
            res[0] = carry;
            return res;
        } else {
            return digits;
        }
    }

    public static void main(String[] args) {
        int[] input = {4, 3, 2, 1};
        PlusOne2 plusOne2 = new PlusOne2();
        System.out.println(Arrays.toString(plusOne2.apply(input)));
    }
}

