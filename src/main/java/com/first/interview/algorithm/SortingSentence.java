package com.first.interview.algorithm;

import java.util.HashMap;
import java.util.Map;

public class SortingSentence {
    public String sortingSentence(String input) {
        Map<Integer, String> map = new HashMap<>();
        int index = 0;
        int start = 0;

        while (index < input.length()) {
            if (index == input.length() - 1) {
                String word = input.substring(start, index - 1);
                map.put(((input.charAt(index - 1) - '0')), word);
            } else if (input.charAt(index) != ' ') {
                index++;
            } else {
                    String word = input.substring(start, index - 1);
                    map.put(((input.charAt(index - 1) - '0')), word);
                    index++;
                    start = index;
                }
        }

        int count = 1;
        StringBuilder res = new StringBuilder();

        while (count <= map.size()) {
            res.append(map.get(count));

            if (count != map.size()) {
                res.append(" ");
            }
            count++;
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String input = "is2 sentence4 This1 a3";
        SortingSentence sortingSentence = new SortingSentence();
        String res = sortingSentence.sortingSentence(input);
        System.out.println(res);
    }
}
