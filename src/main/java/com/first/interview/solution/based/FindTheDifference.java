package com.first.interview.solution.based;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> counterS = new HashMap<>();
        buildMap(counterS, s);

        for (int i = 0; i < t.length(); i++) {
            if(!counterS.keySet().contains(t.charAt(i)) || counterS.get(t.charAt(i)) == 0) {
                return t.charAt(i);
            } else {
                counterS.put(t.charAt(i), counterS.get(t.charAt(i)) - 1);
            }
        }
        throw new NoSuchElementException("cannot find extra character");
    }

    private void buildMap(HashMap<Character, Integer> counterS, String s) {
        for (int i = 0; i < s.length(); i++) {
            counterS.put(s.charAt(i), counterS.getOrDefault(s.charAt(i), 0) + 1);
        }
    }
}
