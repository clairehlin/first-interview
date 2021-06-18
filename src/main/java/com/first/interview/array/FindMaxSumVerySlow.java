package com.first.interview.array;

public class FindMaxSumVerySlow implements FindMaxSum {
    @Override
    public int apply(int[] input) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < input.length; i++) {
            for (int j = i; j < input.length; j++) {
                int sum = sum(input, i, j);
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    // sum the values from input array at position start to position end
    // for example, if input is [1, 7, 8, -1, 12], then
    // sum(input, 1, 3) = 14
    // sum(input, 1, 1) = 7
    private int sum(int[] input, int start, int end) {
        if (start == end) {
            return input[start]; // input[start] and input[end] return the same value
        } else {
            int sum = input[start];
            for (int i = start + 1; i < end + 1; i++) {
                sum += input[i];
            }
            return sum;
        }
    }
}
