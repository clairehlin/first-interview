package com.first.interview.algorithm;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement3 {
    public int apply(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();

        for (Integer num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int res = 0;
        for (Integer key : map.keySet()){
            if (map.get(key) > (nums.length / 2)){
                res = key;
            }
        }
        return res;
    }
}
