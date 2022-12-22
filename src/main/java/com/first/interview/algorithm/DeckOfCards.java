package com.first.interview.algorithm;
// leetcode 914

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class DeckOfCards {
    private static SortGroup sortGroup;

    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int num : deck) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        hashMap.values().forEach(integer -> list.add(integer));
        list.sort(sortGroup);

        if (list.get(0) < 2) {
            return false;
        }

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) % list.get(0) != 0) {
                return false;
            }
        }
        return true;
    }

    private class SortGroup implements Comparator<Integer> {

        @Override
        public int compare(Integer size1, Integer size2) {
            if (size1 > size2) {
                return 1;
            } else if (size1 < size2) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
