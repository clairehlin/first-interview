package com.first.interview.algorithm;
/*
35. Search Insert Position
Easy

9448

460

Add to List

Share
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4
 */
/*
https://leetcode.com/problems/search-insert-position/
binary search algorithm

compare value in the middle.
if the same, found.
if the target value is smaller than middle, continue to search left. Right becomes pivot - 1
if the target value is bigger than middle, continue to search right. Left becomes pivot + 1

if not found, while (left < right), return left
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] == target) {
                return pivot;
            } else if (nums[pivot] < target) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return left;
    }
}
