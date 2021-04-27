package com.first.interview.sorting;

import org.apache.commons.lang3.Validate;

import static org.apache.commons.lang3.ArrayUtils.swap;

public class QuickSort implements Sort {

    @Override
    public void apply(Integer[] values) {
        Validate.notNull(values, "input cannot be null");
        int low = 0;
        int high = values.length - 1;
        quickSort(values, low, high);
    }

    private void quickSort(Integer[] values, int low, int high) {
        if (low >= high) {
            return;
        }

        int newMiddle = partition(values, low, high);

        quickSort(values, low, newMiddle - 1);
        quickSort(values, newMiddle + 1, high);
    }

    private int partition(Integer[] values, int low, int high) {
        Integer pivotValue = values[high];
        int nextSpotToFill = low - 1;

        for (int i = low; i < high; i++) {
            if (values[i] < pivotValue) {
                swap(values, ++nextSpotToFill, i);
            }
        }

        // now put the pivot element in the correct position. The pivot position will never change from now.
        swap(values, ++nextSpotToFill, high);
        return nextSpotToFill; //this is the index for the pivot and is the correct position in the array forever from now
    }

}
