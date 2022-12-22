package com.first.interview.algorithm;
/*
https://leetcode.com/problems/longest-common-prefix/
take the first String in the String array as an example
iterate entire array
if the subString of the second string contains example , use indexOf(),
and the return result is 0, it means containing prefix.

if the return result is NOT 0, trim down one character from the right of "example" String
use substring()
looping to keep trimming down example, until indexOf() return 0
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

}
