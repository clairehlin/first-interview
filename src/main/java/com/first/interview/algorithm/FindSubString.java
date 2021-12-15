package com.first.interview.algorithm;

import java.util.ArrayList;
import java.util.List;

public class FindSubString {

    public List<Integer> find(String base, String keyword) {
        List<Integer> list = new ArrayList<>();
        int keywordSize = keyword.length();
        for (int i = 0; i < base.length() - 1 - keywordSize; i++) {
            if (base.substring(i, i + keywordSize).equalsIgnoreCase(keyword)){
                list.add(i);
            }
        }
        return list;
    }

    public List<Integer> search (String base, String keyword) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= base.length() - keyword.length(); i++) {
           if (isSameSequence(base, keyword, i)) {
               list.add(i);
           }
        }
        return list;
    }

    private boolean isSameSequence(String base, String keyword, int start) {
        int keywordLength = keyword.length();
        int keywordIndex = 0;
        boolean result = true;

        while (keywordLength > 0) {
            if (Character.toLowerCase(base.charAt(start)) == Character.toLowerCase(keyword.charAt(keywordIndex))) {
                start++;
                keywordIndex++;
                keywordLength--;
            } else {
                result = false;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String base = "A customer walked in Walmart";
        String keyword = "wal";
        FindSubString findSubstring = new FindSubString();
        List<Integer> res = findSubstring.find(base, keyword);
        System.out.println(res);

        List<Integer> res2 = findSubstring.search(base, keyword);
        System.out.println(res2);

    }
}
