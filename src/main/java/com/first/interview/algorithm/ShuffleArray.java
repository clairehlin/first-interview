// leetcode 1470
package com.first.interview.algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class ShuffleArray {
    public int[] shuffle(int[] nums, int n){
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i <= n - 1; i++) {
            queue.add(nums[i]);
            queue.add(nums[i + n]);
        }

        int[] res = new int[nums.length];
        int count = 0;

        while (count < nums.length) {
            res[count] = queue.remove();
            count++;
        }
        return res;
    }
}
