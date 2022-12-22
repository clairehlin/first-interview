package com.first.interview.algorithm;
/*
https://leetcode.com/problems/climbing-stairs/
70. Climbing Stairs
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?



Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

------------------------------
recursive question
break problems into smaller problems
if there is one step, result is 1
if there are two steps, result is 2.
anything else, recursively call itself with one step less + two steps less
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        int result = 0;
        if (n == 1) {
            result = 1;
        } else if (n == 2) {
            result = 2;
        } else {
            result = climbStairs(n -1) + climbStairs(n -2);
        }

        return result;
    }
}
