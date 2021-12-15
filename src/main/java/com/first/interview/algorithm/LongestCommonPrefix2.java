package com.first.interview.algorithm;

public class LongestCommonPrefix2 {
    public String longestCommonPrefix(String[] strs) {
        String sample = strs[0];
        int sampleLength = sample.length();
        StringBuilder res = new StringBuilder();

        for(int i = 0; i < sample.length(); i++) {
            char c = sample.charAt(i);

            for (int j = 1; j < strs.length; j++) {
                if(strs[j].charAt(i) != c) {
                    return res.toString();
                }
            }

            res.append(c);
        }

        if (res.length() == 0) {
            return "";
        } else {
            return res.toString();
        }
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        LongestCommonPrefix2 longestCommonPrefix2 = new LongestCommonPrefix2();
        String res = longestCommonPrefix2.longestCommonPrefix(strs);
        System.out.println(res);
    }
}
