/*
Given an integer array nums, return the third distinct maximum number in this array.
If the third maximum does not exist, return the maximum number.

Time complexity should be O(n). It means it cannot sort input array.

solution:
convert input array into a set to remove duplicates
then get the third maximum
 */
package com.first.interview.solution.based;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ThirdMaximumNum {
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int max = Integer.MIN_VALUE;
        int count = 2;

        if (set.size() == 1) {
            return set.iterator().next();
        } else if (set.size() == 2) {
            return set.stream().max(Integer::compare).get();
        } else {
            while (count > 0) {
                delMax(set);
                count--;
            }
        }
        Optional<Integer> res = set.stream().max(Integer::compare);
        return res.get();
    }

    private void delMax(Set<Integer> set) {
        Optional<Integer> max = set.stream().max(Integer::compare);
        set.remove(max.get());
    }
}
