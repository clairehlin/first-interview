package com.first.interview.algorithm;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate2 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> store = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!store.contains(nums[i])) {
                store.add(nums[i]);
            } else {
                return true;
            }
        }
        return false;
    }
}
