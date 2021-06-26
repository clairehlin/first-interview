package com.first.interview.algorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FirstUniqueCharacter {
    public int firstUnique(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();

        for (char c : chars) {
            if (map.containsKey(c)) {
                int count = map.get(c);
                count = count + 1;
                map.put(c, count);
            } else {
                int count = 1;
                map.put(c, count);
            }
        }

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (map.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }
}
