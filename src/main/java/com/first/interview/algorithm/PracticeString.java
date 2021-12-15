package com.first.interview.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PracticeString {
    boolean isEqual(String s, String t) {
        List<String> sList = process(s);
        List<String> tList = process(t);

        return sList.equals(tList);
    }

    private List<String> process(String s) {
        List<String> list = new ArrayList<>();
        String[] words = s.split(" ");

        for(String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            list.add(String.valueOf(chars));
        }

        return list;
    }
}
