package com.first.interview.algorithm;

// aaabbcbbaacc
// a3b2c1b2a2c2

import java.util.ArrayList;
import java.util.List;

public class PrintString {
    List<String> apply (String input) {
        List<String> res = new ArrayList<>();
        char[] chars = input.toCharArray();
        int count = 0;

        for (int start = 0, pointer = 0; pointer < chars.length - 1; pointer++) {
            if (chars[pointer] == chars[pointer + 1]) {
                count++;
                continue;
            } else {
                res.add("" + chars[start]);
                res.add("" + (count + 1));
            }
            start = pointer + 1;
            count = 0;
        }
        return res;
    }

    public static void main(String[] args) {
        String input = "aaabbcbbaacc";
        PrintString printString = new PrintString();

        System.out.println(printString.apply(input));
    }
}
