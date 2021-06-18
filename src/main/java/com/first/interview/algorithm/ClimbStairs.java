package com.first.interview.algorithm;

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
