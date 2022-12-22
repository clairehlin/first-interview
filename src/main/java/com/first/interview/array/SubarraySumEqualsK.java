package com.first.interview.array;
/*
https://leetcode.com/problems/subarray-sum-equals-k/

Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.



Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2

nums[i] can be negative

use a hashmap to keep track of the sum-so-far and keep count how many times this "sum-so-far" appears
if the current "sum-so-far" - k = "sum-so-far" (found in a map), it means we found 1 count


*/

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int count = 0;
        int sum_so_far = 0;

        // base case
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum_so_far += nums[i];

            if (map.containsKey(sum_so_far - k)) {
                count += map.get(sum_so_far - k);
            }
            map.put(sum_so_far, map.getOrDefault(sum_so_far, 0) + 1);
        }
        return count;
    }
}
