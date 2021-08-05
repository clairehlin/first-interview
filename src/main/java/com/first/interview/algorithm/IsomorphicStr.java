package com.first.interview.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStr {
    public boolean isIsomorphic2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Set<Integer>> sPositions = new HashMap<>();
        Map<Character, Set<Integer>> tPositions = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            sPositions.computeIfAbsent(charS, c -> new HashSet<>()).add(i);
            tPositions.computeIfAbsent(charT, c -> new HashSet<>()).add(i);

            if (!sPositions.get(charS).equals(tPositions.get(charT))) {
                return false;
            }
        }
        return true;
    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> sToT = new HashMap<>();
        Map<Character, Character> tToS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            sToT.putIfAbsent(charS, charT);
            tToS.putIfAbsent(charT, charS);

            if (!sToT.get(charS).equals(charT) || !tToS.get(charT).equals(charS)) {
                return false;
            }
        }
        return true;
    }
}
