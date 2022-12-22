package com.first.interview.sorting;

import static java.util.Objects.requireNonNull;
/*
look for the smallest element
iterate entire array
swap the element in current position with the smallest element

O (n * n)
 */
public class SelectionSort2 {
    public void selectionSort(int[] input) {
        requireNonNull(input, "cannot operate on null array");
        int pos = 0;

        while (pos < input.length - 1) {
            swap(pos, minPos(pos, input), input);
            pos++;
        }
    }

    //swap the values between pos (current position) and the minPos (minimum position)
    private void swap(int pos, int minPos, int[] input) {
        int temp = input[pos];
        input[pos] = input[minPos];
        input[minPos] = temp;
    }

    // look for position of the minimum value
    private int minPos(int start, int[] input) {
        int minPosition = start;
        int min = input[start];

        for (int i = start; i < input.length; i++) {
            if (input[i] <= min) {
                minPosition = i;
                min = input[i];
            }
        }
        return minPosition;
    }
}
