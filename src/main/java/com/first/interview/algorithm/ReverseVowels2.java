package com.first.interview.algorithm;

import java.util.Arrays;
import java.util.List;

public class ReverseVowels2 {
    public String reverseVowels(String s) {
        List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u');
        String res = new String();

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (!list.contains(s.charAt(start))) {
                start++;
            }

            if (!list.contains(s.charAt(end))) {
                end--;
            }

            if (list.contains(s.charAt(start)) && list.contains(s.charAt(end))) {
                res = swap(s, start, end);
                start++;
                end--;
            }
        }
        return res;
    }

    private String swap(String s, int start, int end) {
        char[] chars = s.toCharArray();
        char temp = chars[end];
        chars[end] = chars[start];
        chars[start] = temp;
        return new String(chars);
    }

    public static void main(String[] args) {
        String input = "leetcode";
        ReverseVowels2 reverseVowels2 = new ReverseVowels2();
        String res = reverseVowels2.reverseVowels(input);
        System.out.println(res);
    }
}
