package com.first.interview.array;
/*
https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/

 */

import java.util.Arrays;

public class MakeArrayZero {
    public int minimumOperations(int[] nums) {
        if (nums.length == 1 && nums[0] != 0) {
            return 1;
        } else {
            int count = 0;

            Arrays.sort(nums);


            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i + 1] != nums[i]) {
                    count++;
                }
            }
            return count;
        }
    }
}

/*
1, 2, 3, 5

0.1.2.4
0.0.1.3
0,0,0,2
0,0,0,0

 */