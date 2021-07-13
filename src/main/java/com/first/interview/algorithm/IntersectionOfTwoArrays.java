package com.first.interview.algorithm;

import java.util.*;

public class IntersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = populate(nums1);
        Map<Integer, Integer> map2 = populate(nums2);
        ArrayList<Integer> arr = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            int count1 = map1.get(nums1[i]);
            int count2 = 0;
            if (!visited.contains(nums1[i]) && map2.containsKey(nums1[i])) {
                count2 = map2.get(nums1[i]);
                visited.add(nums1[i]);
            }
            int min = Math.min(count1, count2);


            while (min > 0) {
                arr.add(nums1[i]);
                min--;
            }
        }

        int length = arr.size();
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            result[i] = arr.get(i);
        }

        return result;
    }

    private Map<Integer, Integer> populate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                int count = map.get(nums[i]);
                map.put(nums[i], ++count);
            }
        }

        return map;
    }
}
