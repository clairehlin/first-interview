package com.first.interview.algorithm;

import java.util.*;

public class LargestSubstring {
    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, Integer[]> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Integer[] pos = map.getOrDefault(s.charAt(i), new Integer[2]);
            if (pos[0] == null) {
                pos[0] = i;
            } else {
                pos[1] = i;
            }
            map.put(s.charAt(i), pos);
        }

        int maxLength = -1;

        for(Map.Entry<Character, Integer[]> entry : map.entrySet()) {
           Integer[] pos = entry.getValue();
           if (pos[1] != null) {
               maxLength = Math.max(pos[1] - pos[0] - 1, maxLength);
           }
        }
        return maxLength;
    }
}
