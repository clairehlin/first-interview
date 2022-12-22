package com.first.interview.solution.based;

import java.util.*;

public class RingsRods {

    public int countPoints(String rings) {
        HashMap<Integer, Set<Character>> rods = new HashMap<>();
        buildMap(rings, rods);
        int count = 0;

        for (Map.Entry<Integer, Set<Character>> entry : rods.entrySet()) {
            if(entry.getValue().contains('B')
                && entry.getValue().contains('G')
                && entry.getValue().contains('R')) {
                count++;
            }
        }
        return count;
    }

    private void buildMap(String rings, HashMap<Integer, Set<Character>> rods) {
        for (int i = 0; i < rings.length(); i += 2) {
            Integer key = rings.charAt(i + 1) - '0';
            if (!rods.containsKey(key)) {
                Set<Character> set = new HashSet<>();
                set.add(rings.charAt(i));
                rods.put(key, set);
            } else {
                rods.get(key).add(rings.charAt(i));
            }
        }
    }
}
