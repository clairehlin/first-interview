package com.first.interview.algorithm;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateSlow implements ContainsDuplicate {

    @Override
    public boolean apply(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int element : nums) {
            map.put(element, map.getOrDefault(element, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 2) {
                return true;

            }
        }
        return false;
    }
}
