package com.first.interview.sorting;

import org.apache.commons.lang3.Validate;

public class SelectionSort implements Sort {

    @Override
    public void apply(Integer[] values) {
        Validate.notNull(values, "input cannot be null");
        if (values.length == 0 || values.length == 1) {
            return;
        }
        int maxIndex = values.length - 1;

        selectionSort(values, maxIndex);

    }

    private void selectionSort(Integer[] values, int maxPos) {
        for (int startingPos = 0; startingPos != maxPos; startingPos++) {
            int currentMinValue = Integer.MAX_VALUE;
            int minIndex = startingPos;
            for (int currentPos = startingPos; currentPos <= maxPos; currentPos++) {
                if (values[currentPos] < currentMinValue) {
                    minIndex = currentPos;
                    currentMinValue = values[currentPos];
                }
            }
            swap(values, startingPos, minIndex);
        }
    }

    private void swap(Integer[] values, int startingPos, int minIndex) {
        Integer temp = values[startingPos];
        values[startingPos] = values[minIndex];
        values[minIndex] = temp;
    }
}
