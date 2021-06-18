package com.first.interview.algorithm;

import java.util.Stack;

public class ReformatString {

    public String reformat(String s) {
        Stack<Character> nums = new Stack<>();
        Stack<Character> letters = new Stack<>();
        StringBuilder str = new StringBuilder();

        char[] chars = s.toCharArray();

        for (Character c : chars) {
            if (Character.isDigit(c)) {
                nums.push(c);
            } else {
                letters.push(c);
            }
        }

        if (letters.size() == (nums.size() + 1) || nums.size() == letters.size()) {
            while (!letters.isEmpty()) {
                str.append(letters.pop());
                if (!nums.isEmpty()) {
                    str.append(nums.pop());
                }
            }
        } else if (nums.size() == (letters.size() + 1)) {
            while (!nums.isEmpty()) {
                str.append(nums.pop());
                if (!letters.isEmpty()) {
                    str.append(letters.pop());
                }
            }
        } else {
            str.append("");
        }
        return str.toString();
    }
}
