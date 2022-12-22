package com.first.interview.sorting;

import java.util.Arrays;
// 1. break an input array into half, left half and right half
// 2. recursive calling sort() for the left half:
// 3. recursive calling sort() for the right half:
// 4. Merge the sorted left array and sorted right array:

/*
how to merge:
traverse left array and right array
if the first number of left array < the first number of the right array
replace the original first number in input array with first number of left array

if there is left array left, replace the rest of input array with rest of left array
if there is right array left, replace the rest of input array with rest of right array

 */

// O(nLogn)

public class MergeSort2 {
    public void sort(int[] input) {
        if (input.length > 1) {
            int mid = input.length / 2;
            int[] left = breakarray(0, mid, input);
            int[] right = breakarray(mid, input.length, input);

            sort(left);
            sort(right);
            merge(left, right, input);
        }
    }

    private int[] breakarray(int start, int end, int[] input) {
        return Arrays.copyOfRange(input, start, end);
    }

    private void merge(int[] left, int[] right, int[] input) {
        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                input[resultIndex] = left[leftIndex];
                leftIndex++;
            } else {
                input[resultIndex] = right[rightIndex];
                rightIndex++;
            }
            resultIndex++;
        }

        while (leftIndex < left.length) {
            input[resultIndex++] = left[leftIndex++];
        }

        while (rightIndex < right.length) {
            input[resultIndex++] = right[rightIndex++];
        }
    }
}
