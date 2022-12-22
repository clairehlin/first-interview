package com.first.interview.algorithm;
/*
https://leetcode.com/problems/sqrtx/
69. Sqrt(x)
Easy

4718

3508

Add to List

Share
Given a non-negative integer x, compute and return the square root of x.

Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.

Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.



Example 1:

Input: x = 4
Output: 2
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.

if input < 2, return input

starting from low = 2 and high = input/2, pivot = low + (high - low) / 2
looping while low <= high
if pivot * pivot > input, high = pivot -1, otherwise, low = pivot + 1
 */
public class Sqrt {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int low = 2;
        int high = x / 2;
        while (low <= high) {
            int pivot = low + (high - low) / 2;
            int num = pivot * pivot;
            if (num > x) {
                high = pivot - 1;
            } else if (num < x) {
                low = pivot + 1;
            } else return pivot;
        }
        return high;
    }

    public int mySqrt2(int x) {
        if (x < 2) {
            return x;
        }

        int low = 2;
        int high = x / 2;

        while (low <= high) {
            int pivot = low + (high - low) / 2;
            long sum = (long)pivot * pivot;
            if (sum == x) {
                return pivot;
            } else if (sum < x) {
                low = pivot + 1;
            } else {
                high = pivot - 1;
            }
        }
        return high;
    }
}
