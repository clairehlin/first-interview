package com.first.interview.solution.based;
/*
https://leetcode.com/problems/remove-element/

two pointers, slow and fast
count record keeps track of the number of elements equals input
if fast pointing to the value the same as input, increase count by 1, move fast pointing
if fast pinting to the value does not equal input, assign fast pointer value to slow pointer, move slow and fast pointer

repeat the process until fast pointer reaches the end of array

return input array length - total count
 */

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        int slow = 0;

        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] == val) {
                count++;
            } else {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return nums.length - count;
    }
}
