package com.first.interview.algorithm;

import java.util.*;

public class MergeSortedArrays {
    int[] merge(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length + nums2.length];
        int count = 0;

        for (int i : nums1) {
            res[count++] = nums1[i];
        }

        for (int i : nums2) {
            res[count++] = nums2[i];
        }

        Arrays.sort(res);
        return res;
    }

    int[] merge2(int[] nums1, int[] nums2){
        int[] res = new int[nums1.length + nums2.length];

        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();

        for (int j : nums1) {
            queue1.offer(j);
        }

        for (int j : nums2) {
            queue2.offer(j);
        }

        int count = 0;

        int iterationNum = Math.min(nums1.length, nums2.length);

        while (!queue1.isEmpty() && !queue2.isEmpty()){
            if (queue1.peek() <= queue2.peek()) {
                res[count++] = queue1.poll();
            } else {
                res[count++] = queue2.poll();
            }
        }

        if (!queue1.isEmpty()) {
            while(!queue1.isEmpty()){
                res[count++] = queue1.poll();
            }
        } else {
            while(!queue2.isEmpty()) {
                res[count++] = queue2.poll();
            }
        }

        return res;
    }
}
