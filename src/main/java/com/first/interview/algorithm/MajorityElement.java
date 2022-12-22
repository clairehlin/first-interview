package com.first.interview.algorithm;
/*
https://leetcode.com/problems/majority-element/

create a Map
iterate entire array to populate map
create a count
loop through every entry in the map, if the value of the entry > count, assign the key value of the entry to result
 */

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int count = nums.length / 2;
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > count) {
                result = entry.getKey();
            }
        }

        return result;
    }
}
