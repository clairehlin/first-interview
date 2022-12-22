package com.first.interview.algorithm;
/*
https://leetcode.com/problems/move-zeroes/solution/

move all non-zero elements to the front of the array
two pointers approach
pointer "lastNonZeroFoundAt" pointer records the position of last non-zero element
the current pointer points to the current position, if the current element is non-zero,
moves it to ("lastNonZeroFoundAt" + 1) position

once the above step is finished, fill up the rest of the array with zero
 */

public class MoveZeros2 {
    public void moveZeros(int[] nums) {
        int lastNonZeroFoundAt = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt++] = nums[i];
            }
        }

        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
