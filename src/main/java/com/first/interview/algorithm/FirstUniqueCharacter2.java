package com.first.interview.algorithm;

import java.util.*;
import java.util.stream.Collectors;

public class FirstUniqueCharacter2 {
    public int apply(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                map.get(chars[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(chars[i], list);
            }
        }

        for (char element : chars) {
            if (map.get(element).size() == 1) {
                return map.get(element).get(0);
            }
        }


        return -1;
    }

    public static void main(String[] args) {
        String s = "leet";
        FirstUniqueCharacter2 firstUniqueCharacter2 = new FirstUniqueCharacter2();
        int res = firstUniqueCharacter2.apply(s);
        System.out.println(res);

        String s1 = "efficiently";
        int res1 = firstUniqueCharacter2.apply(s1);
        System.out.println(res1);

        String s2 = "aabb";
        int res2 = firstUniqueCharacter2.apply(s2);
        System.out.println(res2);

    }
}
