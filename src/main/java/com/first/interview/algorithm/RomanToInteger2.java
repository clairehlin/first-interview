package com.first.interview.algorithm;
/*
https://leetcode.com/problems/roman-to-integer/
create a Map to put all symbols as keys, their values as values
traverse input String from left to right (character by character)
based on map, look up current value(current character) and next value (next character)

if current value < next value, sum = sum + (next value - current value), then move 2 characters
otherwise, sum = sum + current value , move 1 character

 */
import java.util.HashMap;
import java.util.Map;

public class RomanToInteger2 {
    public static final Map<String, Integer> values = new HashMap<>();

    static {
        values.put("M", 1000);
        values.put("D", 500);
        values.put("C", 100);
        values.put("L", 50);
        values.put("X", 10);
        values.put("V", 5);
        values.put("I", 1);
    }

    public int apply(String s) {
        int sum = 0;
        int i = 0;
        while(i < s.length()) {
            String currentStr = s.substring(i, i + 1);
            int currentValue = values.get(currentStr);
            int nextValue = 0;

            if (i + 1 < s.length()) {
                String nextStr = s.substring(i + 1, i + 2);
                nextValue = values.get(nextStr);
            }

            if (currentValue < nextValue) {
                sum += (nextValue - currentValue);
                i += 2;
            } else {
                sum += currentValue;
                i += 1;
            }
        }
        return sum;
    }
}
