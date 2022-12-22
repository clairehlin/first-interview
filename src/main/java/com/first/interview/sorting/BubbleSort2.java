package com.first.interview.sorting;

import static org.apache.commons.lang3.ArrayUtils.swap;

// compare with neighbour
// o(n*n)
public class BubbleSort2 {
    public void bubbleSort(int[] input) {
        for (int j = input.length - 1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                if (input[i] > input[i + 1]) {
                    swap(input, i, i + 1);
                }
            }
        }
    }
}
