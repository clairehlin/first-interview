package com.first.interview.algorithm;

public class SlowValidPalindromeII implements ValidPalindromeII {
    public boolean apply(String s) {
        char[] chars = s.toCharArray();

        // check if the entire string is palindrome or not, no skipping character. Hence send parameter -1 to the method
        if (isPalindrome(chars, -1)) {
            return true;
        } else {
            for (int i = 0; i < chars.length; i++) {
                // when the string is not palindrome, skip a character one by one
                // first skip the character at position 0, then check if the rest of string is palindrome
                // brute force method o(nxn)
                if (isPalindrome(chars, i)) {
                    return true;
                }
            }
            return false;
        }
    }

    private boolean isPalindrome(char[] chars, int skippedIndex) {
        // find out low and high position of the char array
        int low = next(-1, skippedIndex);
        int high = previous(chars.length, skippedIndex);

        while (low < high) {
            if (chars[low] != chars[high]) {
                return false;
            }
            low = next(low, skippedIndex);
            high = previous(high, skippedIndex);
        }
        return true;
    }

    // calculate the starting position, assume current is -1, which is position before index 0
    private int next(int current, int skipped) {
        if (current + 1 == skipped) {
            return current + 2;
        } else {
            return current + 1;
        }
    }

    // calculate the end of position, assume the current is chars.length,
    // which is the position after the last character in the array
    private int previous(int current, int skipped) {
        if (current - 1 == skipped) {
            return current - 2;
        } else {
            return current - 1;
        }
    }
}
