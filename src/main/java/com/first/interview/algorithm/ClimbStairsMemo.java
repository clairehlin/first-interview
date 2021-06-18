package com.first.interview.algorithm;

public class ClimbStairsMemo {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            int[] storage = new int[n];
            storage[0] = 1;
            storage[1] = 2;
            return build(n, storage);
        }
    }

    private int build(int n, int[] storage) {
        if (storage[n - 1] == 0) { // if location is zero, it has not been calculated
            storage[n - 1] = build(n - 1, storage) + build(n - 2, storage);
        }
        return storage[n - 1];
    }
}
