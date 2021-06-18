package com.first.interview.array;

public class FindMaxSumSlow implements FindMaxSum {
    @Override
    public int apply(int[] input) {
        int greater = 0;
        int start = 0;

        while (start < input.length) {
            int sum = 0;

            for (int i = start; i < input.length; i++) {
                sum = sum + input[i];
                if (sum > greater) {
                    greater = sum;
                }
            }
            start++;
        }
        return greater;
    }
}
