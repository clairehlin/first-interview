package com.first.interview.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOfTwoArrays2 {
    public int[] intersection(int[] nums1, int[] nums2){
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            if(!set.contains(nums1[i])) {
                set.add(nums1[i]);
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i]) && !list.contains(nums2[i])) {
                list.add(nums2[i]);
            }
        }

        int[] res = new int[list.size()];
        int count = 0;

        while(count < list.size()){
            res[count] = list.get(count);
            count++;
        }
        return res;
    }
}
