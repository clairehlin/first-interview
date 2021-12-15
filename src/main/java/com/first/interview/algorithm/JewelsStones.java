package com.first.interview.algorithm;

import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class JewelsStones {
    public int numJewelsInStones2(String jewels, String stones) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < jewels.length(); i++) {
            map.putIfAbsent(jewels.charAt(i), 1);
        }

        int sum = 0;

        for (int i = 0; i < stones.length(); i++) {
            sum = sum + map.getOrDefault(stones.charAt(i), 0);
        }

        return sum;
    }

    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> map1 = jewels.chars()
            .boxed()
            .collect(
                toMap(
                    i -> (char) i.intValue(),
                    i -> 1
                )
            );
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < jewels.length(); i++) {
            map.putIfAbsent(jewels.charAt(i), 1);
        }

        return stones.chars()
            .map(c -> map.getOrDefault((char) c, 0))
            .sum();
    }
}
