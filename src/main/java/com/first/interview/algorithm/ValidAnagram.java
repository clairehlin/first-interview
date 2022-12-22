package com.first.interview.algorithm;
/*
https://leetcode.com/problems/valid-anagram/

if the length of String s is not equal to the length of String t, they are not anagram

convert both Strings to char arrays
sort both char arrays
if both char arrays are not equal, they are not anagram
 */
import java.util.Arrays;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();

        Arrays.sort(str1);
        Arrays.sort(str2);

        return Arrays.equals(str1, str2);
    }
}
