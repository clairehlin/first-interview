package com.first.interview.algorithm;
/*
Given a string, return recursively a "cleaned" string where adjacent chars that are the same have been reduced to a single char. So "yyzzza" yields "yza".

stringClean("yyzzzayy") → "yzay"
stringClean("abbbcdd") → "abcd"
stringClean("Hello") → "Helo"
 */


// stringClean("yyzzzayy")
//      - y stringClean("yzzzayy") -> yzzzayy -> yzayy -> yzay
//          - ^
//              - ^
//                 - ^
//                    -  ^
//                       - (base case)

// import java.io.*;
// import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class RemoveAdjacentChar {

    public String processed2(String str) {

        // your implementation here

        if (str.isEmpty()) {
            return str;
        }

        StringBuilder res = new StringBuilder();

        char[] chars = str.toCharArray();
        char first = chars[0];
        res.append(first);

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != first) {
                res.append(chars[i]);
            }
            first = chars[i];
        }

        return res.toString();
    }

    public String processed(String input) {
        StringBuilder result = new StringBuilder();
        return processed2(input, result);
    }

    /*
    abbc
    processed2(abbc, "")
    processed2(bbc, "a")
    processed2(bc, "a")
    processed2(c , "ab")
    processed2( , "abc")

     */
    private String processed2(String input, StringBuilder result) {
        if (input.isEmpty()) {
            return result.toString();
        } else if (input.length() == 1) {
          return result.append(input.charAt(0)).toString();
        } else {
            if (input.charAt(0) != input.charAt(1)) {
                result.append(input.charAt(0));
            }
            return processed2(input.substring(1), result);
        }
    }
}

