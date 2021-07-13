package com.first.interview.algorithm;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement2 {
    public int apply(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int majorityRate = nums.length / 2;
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > majorityRate) {
                result = entry.getKey();
            }
        }

        return result;
    }
}
