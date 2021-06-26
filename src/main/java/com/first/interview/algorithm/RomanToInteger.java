package com.first.interview.algorithm;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int apply(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

        int sum = 0;

        char[] chars = s.toCharArray();
        String initial;

        for (int i = 0; i < s.length(); i++){
            if (i == s.length() - 1) {
                initial = new String(chars, i, 1);
            } else {
                initial = new String(chars, i, 2);
            }
                if (map.containsKey(initial)) {
                    sum += map.get(initial);
                    i++;
                } else {
                    char[] singleChar = initial.toCharArray();
                    String firstChar = new String(singleChar, 0, 1);
                    sum += map.get(firstChar);
                }

        }
        return sum;
    }
}
