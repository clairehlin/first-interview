package com.first.interview.algorithm;

import java.util.*;
import java.util.stream.Collectors;

public class UniqueOccurrences {

    public boolean uniqueOccur(int[] arr) {
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
        }

        List<Integer> hashMapValues = hashMap.values().stream().sorted().collect(Collectors.toList());

        boolean res = true;

        for (int i = 0; i < hashMapValues.size(); i++) {
            if (hashMapValues.get(i) == hashMapValues.get(i + 1)) {
                res = false;
                break;
            }

        }

        return res;
    }
}

