package com.first.interview.algorithm;

public class FastExplicitValidPalindromeII implements ValidPalindromeII {
    public boolean apply(String s) {
        char[] chars = s.toCharArray();

        int breakingPoint = isPalindrome(chars, 0, chars.length - 1);

        // if breaking point is less than 0 (as returned value is Integer.MIN_VALUE), the string is palindrome
        // else the string is not palindrome, drop the character at the low pointer, check the rest of the string
        // is palindrome or not. For example, string "abbca". breaking point = 1. drop character at position 1.
        // check if the rest of string "bc" is palindrome or not
        // if dropping the character at low position is not palindrome. Drop the character at high position (drop "c"),
        // to see if the rest "bb" is palindrome or not
        if (breakingPoint < 0) {
            return true;
        } else {
            if (isPalindrome(chars, breakingPoint + 1, chars.length - breakingPoint - 1) < 0) {
                return true;
            } else if (isPalindrome(chars, breakingPoint, chars.length - breakingPoint - 1 - 1) < 0) {
                return true;
            } else {
                return false;
            }
        }

    }

    //find out breaking point - where two chars (one from the beginning, one from the end) are two equal
    // if two chars are not equal, return the position of the beginning pointer
    // else (the entire char[] char is palindrome, return return Integer.MIN_VALUE (or Integer.MAX_VALUE)
    private int isPalindrome(char[] chars, int low, int high) {

        while (low < high) {
            if (chars[low] != chars[high]) {
                return low;
            }
            low++;
            high--;
        }
        return Integer.MIN_VALUE;
    }
}
