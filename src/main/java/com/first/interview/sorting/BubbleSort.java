package com.first.interview.sorting;

import org.apache.commons.lang3.Validate;

// O(n*n) n square

public class BubbleSort implements Sort{
    @Override
    public void apply(Integer[] values) {
        Validate.notNull(values, "input cannot be null");
        boolean bubbled = true;

        while (bubbled) {
            bubbled = false;
            for (int i = 0; i < values.length - 1; i++) {
                if (values[i] > values[i + 1]) {
                    swap(values, i, i + 1);
                    bubbled = true;
                }
            }
        }
    }

    private void swap(Integer[] values, int i, int j) {
        Integer temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }
}
