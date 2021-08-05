/*
You are given a sorted unique integer array nums.

Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums
is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
 */
package com.first.interview.algorithm;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();

        for (int start = 0, end = 0; end < nums.length; end++) {
            if (end + 1 < nums.length && nums[end + 1] - nums[end] == 1) {
                continue;
            } else {
                if (start == end) {
                    list.add("" + nums[start]);
                } else {
                    list.add(nums[start] + "->" + nums[end]);
                }
                start = end + 1;
            }
        }

        return list;
    }
}
