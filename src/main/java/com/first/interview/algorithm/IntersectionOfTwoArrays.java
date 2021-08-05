package com.first.interview.algorithm;

import java.util.*;

public class IntersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = createMap(nums1);
        Map<Integer, Integer> map2 = createMap(nums2);
        ArrayList<Integer> arr = new ArrayList<>();

        for (Integer key : map1.keySet()) {
            if (map2.keySet().contains(key)) {
                arr.add(key);
            }
        }

        int[] res = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            res[i] = arr.get(i);
        }

        return res;
    }

    private Map<Integer, Integer> createMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        return map;
    }
}
