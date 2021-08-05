package com.first.interview.algorithm;

import java.util.Stack;

public class ReverseVowels {
    public String reverseVowels(String s) {
        Stack<Character> stack = new Stack<>();
        String vowels = "aeiouAEIOU";

        for (Character c : s.toCharArray()) {
            if (vowels.contains(c.toString())) {
                stack.add(c);
            }
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
           String element = "" + s.charAt(i);
           if (vowels.contains(element)) {
               chars[i] = Character.valueOf(stack.pop());
           }
        }

        String res = new String(chars);
        return res;
    }

}
