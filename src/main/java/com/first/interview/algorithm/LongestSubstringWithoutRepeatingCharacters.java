package com.first.interview.algorithm;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/

use sliding window, two pointers, head and tail pointer
iterate entire string
head and tail pointers, both point to the first (position 0) character to start with
use a set
if tail pointer points to a character , which does not exist in set, add char to set
if char exists in set, remove the character which head pointer points to
move head pointer

keep doing, until set does not contain character which tail pointer points to any more
move tail pointer

compute max record, whichever is greater, current max or (tail - head + 1)

 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        if (s == null || s.length() == 0) {
            return 0;
        }

        int head = 0;
        int tail = 0;
        int max = 0;

        while (tail < s.length()) {
            char c = s.charAt(tail);
            while (set.contains(c)) {
                set.remove(s.charAt(head));
                head++;
            }
            set.add(c);
            max = Math.max(max, tail - head + 1);
            tail++;

        }
        return max;
    }
}
