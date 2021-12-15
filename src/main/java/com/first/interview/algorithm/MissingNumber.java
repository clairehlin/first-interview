package com.first.interview.algorithm;

import java.util.NoSuchElementException;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int[] temp = new int[nums.length + 1];

        int count = 0;
        for (int i : nums) {
            if (i == 0) {
               count = 1;
            }

            if (i < nums.length) {
                temp[i] = i;
            }
        }

        if (count != 1) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != i) {
                res = i;
                break;
            }
        }
        return res;
    }
}
