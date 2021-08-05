package com.first.interview.algorithm;

public class Sqrt {
    public int mySqrt2(int x) {
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

    public int mySqrt(int x) {
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
