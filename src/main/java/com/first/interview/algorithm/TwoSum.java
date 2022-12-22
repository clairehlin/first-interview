package com.first.interview.algorithm;
/*
https://leetcode.com/problems/two-sum/


 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int searchingNum = 0;
        int[] res = new int[2];

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (target - numbers[i] == numbers[j]) {
                    res[0] = i + 1;
                    res[1] = j + 1;
                    break;
                }
            }
        }

        return res;
    }

    public int[] fastTwoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        int[] res = new int[2];

        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                res[0] = start;
                res[1] = end;
                break;
            } else if (numbers[start] + numbers[end] < target) {
                start++;
            } else {
                end--;
            }
        }

        return res;
    }
}
