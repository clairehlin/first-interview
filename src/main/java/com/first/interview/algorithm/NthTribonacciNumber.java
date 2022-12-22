package com.first.interview.algorithm;
/*
https://leetcode.com/problems/n-th-tribonacci-number/
1137. N-th Tribonacci Number
Easy

2272

125

Add to List

Share
The Tribonacci sequence Tn is defined as follows:

T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

Given n, return the value of Tn.



Example 1:

Input: n = 4
Output: 4
Explanation:
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4
Example 2:

Input: n = 25
Output: 1389537

base case is the first 3 numbers are known. Initialize the first three numbers, x =0, y = z = 1
and proceed to the loop of n - 2 steps.
Replace x by y
replace y by z
replace z by x + y + z
 */
public class NthTribonacciNumber {
}
