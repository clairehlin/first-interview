package com.first.interview.algorithm;
/*
https://leetcode.com/problems/contains-duplicate/

create a set
iterate the array
if an element exists in a set, find duplicate
 */
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateFast implements ContainsDuplicate {

    @Override
    public boolean apply(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int element : nums) {
            if (set.contains(element)) {
                return true;
            } else {
                set.add(element);
            }
        }
        return false;
    }
}
