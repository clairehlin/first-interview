package com.first.interview.array;

import org.apache.commons.lang3.Validate;

public class MergeSortedArray {

    int[] merge(int[] arr1, int[] arr2) {
        Validate.notNull(arr1, "did not receive input array");
        Validate.notNull(arr2, "did not receive input array");

        int[] arrNew = new int[arr1.length + arr2.length];

        int arr1Index = 0;
        int arr2Index = 0;
        int arrNewIndex = 0;

        while (arr1Index < arr1.length && arr2Index < arr2.length) {
            if (arr1[arr1Index] <= arr2[arr2Index]) {
                arrNew[arrNewIndex] = arr1[arr1Index];
                arr1Index++;
                arrNewIndex++;
            } else if (arr2[arr2Index] < arr1[arr1Index]) {
                arrNew[arrNewIndex] = arr2[arr2Index];
                arr2Index++;
                arrNewIndex++;
            } else {
                throw new IllegalStateException("there is a bug");
            }
        }

        while (arr1Index < arr1.length) {
            arrNew[arrNewIndex] = arr1[arr1Index];
            arr1Index++;
            arrNewIndex++;
        }

        while (arr2Index < arr2.length) {
            arrNew[arrNewIndex] = arr2[arr2Index];
            arr2Index++;
            arrNewIndex++;
        }
        return arrNew;
    }
}
