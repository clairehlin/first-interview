package com.first.interview.algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {

    int size;
    int average;
    Queue<Integer> q = new LinkedList<>();

    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        if (q.size() >= size) {
            q.poll();
        }
        q.offer(val);

        int qSize = q.size();
        int total = 0;
        Queue<Integer> tempQ = new LinkedList<>();

        for (int i = 0; i <= qSize; i++) {
            int head = q.poll();
            total = total + head;
            tempQ.offer(head);
        }

        q = tempQ;
        return average = total / q.size();
    }
}
