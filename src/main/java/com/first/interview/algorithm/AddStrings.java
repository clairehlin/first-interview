// leetcode 415
package com.first.interview.algorithm;

public class AddStrings {

    public String addStrings(String s, String t) {
       int size = Math.max(s.length(), t.length());
       StringBuilder result = new StringBuilder();
       int carry = 0;

       for (int i = size - 1; i >= 0; i--) {
           char c1 = charAt(s, i, size);
           char c2 = charAt(t, i, size);
           char current = current(c1, c2, carry);
           carry = carry(c1, c2, carry);
           result.insert(0, current);
       }

       if (carry > 0) {
           result.insert(0, (char)('0' + carry));
       }

       return result.toString();
    }

    private int carry(char c1, char c2, int carry) {
        int i1 = c1 - '0';
        int i2 = c2 - '0';
        return (i1 + i2 + carry) / 10;
    }

    private char current(char c1, char c2, int carry) {
        int i1 = c1 - '0';
        int i2 = c2 - '0';
        int result = (i1 + i2 + carry) % 10;
        return (char)('0' + result);
    }

    private char charAt(String s, int i, int max) {
        int offset = max - s.length();
        if (i - offset >= 0) {
            return s.charAt(i - offset);
        } else {
            return '0';
        }
    }
}
