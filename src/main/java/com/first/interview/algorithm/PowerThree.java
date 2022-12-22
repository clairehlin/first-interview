package com.first.interview.algorithm;
/*
https://leetcode.com/problems/power-of-three/solution/

keep dividing the input number into 3, if the remainder is 0, keep looping
the new input number will be (input / 3).
if the final input number is 1, returns true.
 */
public class PowerThree {
    public boolean isPowerOfThree (int n) {
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }
}
