package com.first.interview.algorithm;
/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array/
iterate array
two pointers i , j

if value at pointer i is not equal to value at pointer j, i moves 1 position, replace value at i with value at j, j moves 1 position
assign j value to i value

if value at pointer i equals value at pointer j, i stays position, j moves 1 position

 */
public class RemoveDuplicatsSortedArray2 {
    public int remove(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 2};
        int res = new RemoveDuplicatsSortedArray2().remove(nums);
        System.out.println(res);
    }
}
