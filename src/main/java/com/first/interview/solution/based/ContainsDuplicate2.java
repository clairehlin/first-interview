package com.first.interview.solution.based;
/*
Leetcode 219

Given an integer array nums and an integer k, return true if there are two distinct
indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

use Binary search tree and sliding window
if an element is found in a tree, return tree
else add the current element
if tree size is greater than x, remove the oldest element
 */

import java.util.TreeSet;

public class ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) {
            return false;
        }

        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (treeSet.contains(nums[i])) {
                return true;
            } else if (treeSet.size() < k) {
                treeSet.add(nums[i]);
            } else {
                treeSet.remove(nums[i - k]);
                treeSet.add(nums[i]);
            }
        }
        return false;
    }
}
