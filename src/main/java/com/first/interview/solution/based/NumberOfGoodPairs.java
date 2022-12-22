package com.first.interview.solution.based;

import java.util.HashMap;
import java.util.Map;

public class NumberOfGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int numOfIdenticalPairs = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            if (count > 1) {
                numOfIdenticalPairs = numOfIdenticalPairs + (count - 1) * count / 2;
            }
        }

        return numOfIdenticalPairs;
    }
}
