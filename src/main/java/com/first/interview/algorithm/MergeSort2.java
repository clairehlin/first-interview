package com.first.interview.algorithm;

public class MergeSort2 {
    public void sort(Integer[] values){
        if(values.length == 0 || values.length == 1){
            return;
        }

        int leftArrayLength = values.length / 2;
        int rightArraylength = values.length - leftArrayLength;
        Integer[] leftArray = new Integer[leftArrayLength];
        Integer[] rightArray= new Integer[rightArraylength];
        System.arraycopy(values, 0, leftArray, 0, leftArrayLength);
        System.arraycopy(values, leftArrayLength, rightArray, 0 , rightArraylength);

        sort(leftArray);
        sort(rightArray);
        merge(values, leftArray, rightArray);
    }

    private void merge(Integer[] values, Integer[] leftArray, Integer[] rightArray) {
        int leftArrayIndex = 0;
        int rightArrayIndex = 0;
        int mergeArrayIndex = 0;

        while(leftArrayIndex < leftArray.length && rightArrayIndex < rightArray.length) {
            if(leftArray[leftArrayIndex] <= rightArray[rightArrayIndex]) {
                values[mergeArrayIndex] = leftArray[leftArrayIndex];
                leftArrayIndex++;
            } else {
                values[mergeArrayIndex] = rightArray[rightArrayIndex];
                rightArrayIndex++;
            }
            mergeArrayIndex++;
        }

        while(leftArrayIndex < leftArray.length){
            values[mergeArrayIndex] = leftArray[leftArrayIndex];
            leftArrayIndex++;
            mergeArrayIndex++;
        }

        while (rightArrayIndex < rightArray.length) {
            values[mergeArrayIndex] = rightArray[rightArrayIndex];
            rightArrayIndex++;
            mergeArrayIndex++;
        }
    }
}
