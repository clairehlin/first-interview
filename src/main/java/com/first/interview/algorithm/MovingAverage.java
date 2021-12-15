package com.first.interview.algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    private static int size;
    private Queue<Integer> queue = new LinkedList<>();

    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {

        if (queue.size() >= size) {
            queue.poll();
        }
        queue.add(val);

        int total = 0;

        for (int i = 0; i < queue.size(); i++) {
            int temp = queue.poll();
            total += temp;
            queue.add(temp);
        }

        return total * 1.0 / queue.size();
    }
}
