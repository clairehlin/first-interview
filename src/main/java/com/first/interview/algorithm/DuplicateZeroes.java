package com.first.interview.algorithm;

public class DuplicateZeroes {
    public void duplicateZeros(int[] arr) {
        int count = 0;
        int length = arr.length  - 1;

        for (int i = 0; i <= length - count; i++) {
            if (arr[i] == 0) {
                if (i == length - count){
                    arr[arr.length - 1] = 0;
                    length -= 1;
                    break;
                }
                count++;
            }
        }

        int lastPos = length - count;

        for (int i = lastPos; i >=0; i--) {
            if (arr[i] == 0) {
                arr[i + count] = 0;
                count--;
                arr[i + count] = 0;
            } else {
                arr[i + count] = arr[i];
            }
        }
    }
}
