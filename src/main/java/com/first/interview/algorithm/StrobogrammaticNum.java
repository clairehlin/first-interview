package com.first.interview.algorithm;

import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticNum {
    public boolean apply(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');

        for (int i = 0, j = num.length() - 1; i < num.length(); i++, j--) {
            Character start = num.charAt(i);
            Character expected = map.get(start);
            Character end = num.charAt(j);
            if (expected == null || !expected.equals(end)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "2";
        StrobogrammaticNum instance = new StrobogrammaticNum();
        boolean res = instance.apply(input);
        System.out.println(res);
    }
}
