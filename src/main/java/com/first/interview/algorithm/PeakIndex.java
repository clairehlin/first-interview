package com.first.interview.algorithm;

public class PeakIndex {
    public int peakIndexMountainArray(int[] arr) {
        int pos = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] > arr[pos]) {
                pos = i + 1;
            }
        }
        return pos;
    }
}
