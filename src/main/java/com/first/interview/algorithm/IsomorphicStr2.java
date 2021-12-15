package com.first.interview.algorithm;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStr2 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        boolean res = true;

        for(int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)).equals(t.charAt(i))) {
                    continue;
                } else {
                    res = false;
                    break;
                }
            } else {
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "paper";
        String t = "title";

        IsomorphicStr2 iso = new IsomorphicStr2();
        boolean res = iso.isIsomorphic(s, t);
        System.out.println(res);
    }
}
