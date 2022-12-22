package com.first.interview.solution.based;
// leetcode 703

// Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
//
//Implement KthLargest class:
//
//KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
//int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.

import java.util.PriorityQueue;

public class KthLargest {
    private static int queueSize;
    private static PriorityQueue<Integer> heap;

    public KthLargest(int k, int[] nums) {
        queueSize = k;
        heap = new PriorityQueue<>();

        for (int num : nums) {
            heap.offer(num);
        }

        while (heap.size() > k) {
            heap.poll();
        }
    }

    public int add(int val) {
        heap.offer(val);

        if (heap.size() > queueSize) {
            heap.poll();
        }

        return heap.peek();
    }
}
