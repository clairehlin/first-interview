package com.first.interview.array;

import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.Map;

public class FindMaxSumSlow2 implements FindMaxSum {

    private final Map<Pair<Integer, Integer>, Integer> sumMap = new HashMap<>();

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

    private int sum(int[] input, int i, int j) {
        Pair<Integer, Integer> previous = Pair.of(i, j - 1);
        if (sumMap.containsKey(previous)) {
            int newSum = input[j] + sumMap.get(previous);
            sumMap.put(Pair.of(i, j), newSum);
            return newSum;
        } else {
            sumMap.put(Pair.of(i, j), input[i]);
            return input[i];
        }
    }
}
