package com.first.interview.algorithm;

import java.util.*;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
//            map.merge(num, 1, Integer::sum);
//            map.compute(num, (k, v) -> v == null ? 1 : v + 1);
//            map.put(num, map.getOrDefault(num, 0) + 1);
           if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                int value = map.get(num);
                map.put(num, value + 1);
            }
        }

        int majorityRate = nums.length / 2;
        int result = 0;

        for (int num : nums) {
            int current = map.get(num);
            if (current > majorityRate) {
                result = num;
            }
        }
        return result;
    }
}
