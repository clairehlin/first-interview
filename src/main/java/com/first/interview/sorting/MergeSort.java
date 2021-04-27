package com.first.interview.sorting;

import org.apache.commons.lang3.Validate;

public class MergeSort implements Sort {
    @Override
    public void apply(Integer[] values) {
        Validate.notNull(values, "input cannot be null");
        sort(values);
    }

    private BrokenArray breakArray(Integer[] values) {
            int firstArrLength = values.length / 2;
            int secondArrLength = values.length - firstArrLength;
            Integer[] firstArr = new Integer[firstArrLength];
            Integer[] secondArr = new Integer[secondArrLength];
            System.arraycopy(values, 0, firstArr, 0, firstArrLength);
            System.arraycopy(values, firstArrLength, secondArr, 0, secondArrLength);
            BrokenArray brokenArray = new BrokenArray();
            brokenArray.leftArray = firstArr;
            brokenArray.rightArray = secondArr;
            return brokenArray;
    }

    private void sort(Integer[] values) {
        if (values.length == 0 || values.length == 1) {
            return;
        }
        BrokenArray brokenArray = breakArray(values);
        sort(brokenArray.leftArray);
        sort(brokenArray.rightArray);
        merge(values, brokenArray.leftArray, brokenArray.rightArray);
    }

    private void merge(Integer[] mergeArray, Integer[] leftArray, Integer[] rightArray) {
        int leftArrayIndex = 0;
        int rightArrayIndex = 0;
        int mergeArrayIndex = 0;
        while (leftArrayIndex < leftArray.length && rightArrayIndex < rightArray.length) {
            if (leftArray[leftArrayIndex] <= rightArray[rightArrayIndex]) {
                mergeArray[mergeArrayIndex] = leftArray[leftArrayIndex];
                leftArrayIndex++;
                mergeArrayIndex++;
            } else if (rightArray[rightArrayIndex] < leftArray[leftArrayIndex]) {
                mergeArray[mergeArrayIndex] = rightArray[rightArrayIndex];
                rightArrayIndex++;
                mergeArrayIndex++;
            } else {
                throw new IllegalStateException("there is a bug");
            }
        }

        while (leftArrayIndex < leftArray.length) {
            mergeArray[mergeArrayIndex] = leftArray[leftArrayIndex];
            leftArrayIndex++;
            mergeArrayIndex++;
        }

        while (rightArrayIndex < rightArray.length) {
            mergeArray[mergeArrayIndex] = rightArray[rightArrayIndex];
            rightArrayIndex++;
            mergeArrayIndex++;
        }
    }

    private static class BrokenArray {
        private Integer[] leftArray;
        private Integer[] rightArray;
    }
}
