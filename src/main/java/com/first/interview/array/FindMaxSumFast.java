package com.first.interview.array;

import static java.lang.Math.max;

public class FindMaxSumFast implements FindMaxSum {
    @Override
    public int apply(int[] input) {
        int currentElement;
        int gmax = input[0];
        int smax = input[0];
        for (int i = 1; i < input.length; i++) {
            currentElement = input[i];
            // compare the current element with previous value (previous element + total)
            // if current  element is bigger, start a new array
            smax = max(currentElement + smax, currentElement);

            gmax = max(gmax, smax);
        }
        return gmax;
    }
}
