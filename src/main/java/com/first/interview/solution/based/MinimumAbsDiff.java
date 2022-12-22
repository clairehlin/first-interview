package com.first.interview.solution.based;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// leetcode 1200. find the minimum absolute difference
public class MinimumAbsDiff {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minAbsDiff = Integer.MAX_VALUE;
        int currAbsDiff = 0;

        List<List<Integer>> res = new LinkedList<>();

        for (int i = 0; i < arr.length - 1; i++) {
            currAbsDiff = arr[i + 1] - arr[i];

            if (currAbsDiff < minAbsDiff) {
                minAbsDiff = currAbsDiff;
                res.clear();
                res.add(Arrays.asList(arr[i], arr[i + 1]));
            } else if (currAbsDiff == minAbsDiff) {
                res.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }
        return res;
    }
}
