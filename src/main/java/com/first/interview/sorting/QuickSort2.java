package com.first.interview.sorting;

import static org.apache.commons.lang3.ArrayUtils.swap;
/*
 partition array
 quick sort (Array, 0, pivot) - sort left
 quick sort (Array, pivot, n - 1) - sort right

 how to partition array:
 iterate the entire array
 assume the pivot is at the last position
 pointer starts at the first position of the array
 if the pointer pointing at the number smaller than pivot, pointer keeps moving
 last, swap the number between the pivot and the pointer
  sort array - move smaller number to the left, move bigger number to the right


O(nLog(n))
 */


public class QuickSort2 {
    public void apply(int[] input) {
        int low = 0;
        int high = input.length - 1;

        quicksort(input, low, high);
    }

    private void quicksort(int[] input, int low, int high) {
        if (low < high) {
            int partitionPos = partition(input, low, high);
            quicksort(input, 0, partitionPos - 1);
            quicksort(input, partitionPos + 1, high);
        }
    }

    // find the pivot
    // when it is final, items on left are smaller than pivot. items on right are larger than pivot.
    // pick the last item, locating at (n - 1), as pivot
    // traverse entire array, swap bigger item to the right, smaller item to the left
    private int partition(int[] input, int low, int high) {
        int pivot = input[high];
        int greaterElementPointer = low;

        for (int i = low; i < high; i++) {
            if (input[i] < pivot) {
                swap(input, greaterElementPointer, i);
                greaterElementPointer++;
            }
        }
        swap(input, greaterElementPointer, high);
        return greaterElementPointer;
    }
}
