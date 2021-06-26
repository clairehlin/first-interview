package com.first.interview.algorithm;

import java.util.ArrayList;
import java.util.List;

public class MissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        List<Integer> missList = new ArrayList<>();
        int count = 1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == count) {
                count++;
                continue;
            } else {
                missList.add(count);
                count++;
                i--;
            }
        }

        if (missList.size() <= k) {
            int fillingNumElements = k - missList.size();
            int start = arr[arr.length - 1];

            for (int i = 0; i < fillingNumElements; i++) {
                missList.add(start + 1);
                start++;
            }
        }
        return missList.get(k - 1);
    }
}
