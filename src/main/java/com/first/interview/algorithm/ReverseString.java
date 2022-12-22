package com.first.interview.algorithm;

/*
https://leetcode.com/problems/reverse-string/

 */
public class ReverseString {
    public void reverseString(char[] s) {
        int length = s.length;

        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[length - 1 - i];
            s[length - 1 - i] = temp;
        }
    }
}
