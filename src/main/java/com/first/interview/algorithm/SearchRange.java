package com.first.interview.algorithm;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
first intersection between two lists
for example,

[2, 3, 4, 5, 6, 8]
[9, 8, 7, 3, 1, 6, 5]
result is [3]

[1, 2, 7, -1, 17, 6, 8]
[9, 7, -1, 17, 9, 6, 5]
result is [7, -1, 17]

[1, 2, 3, 7, 5, 6, 8]
[1, 2, 3, 7]
result is [1, 2, 3, 7]

find where two lists meet
keep going until they don't meet
*/
public class SearchRange {
    public List<Integer> searchRange2 (List<Integer> list1, List<Integer> list2) {
        int index = 0;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < list1.size(); i++) {
            for (int j = index; j < list2.size(); j++) {
                Integer list1Res = list1.get(i);
                Integer list2Res = list2.get(j);

                if (!result.isEmpty() && !list1Res.equals(list2Res)) {
                    return result;
                } else if (list1Res.equals(list2Res)) {
                    result.add(list1Res);
                    index = j;
                    index++;
                    break;
                }
            }
        }
        return result;
    }

    public List<Integer> searchRange(List<Integer> list1, List<Integer> list2) {
        Pair pair = findWhereTheyMeet(list1, list2);
        if (pair == null) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();

        while (list1.size() > pair.start1 && list2.size() > pair.start2
                && list1.get(pair.start1).equals(list2.get(pair.start2)))
        {
            result.add(list1.get(pair.start1));
            pair.start1++;
            pair.start2++;
        }

        return result;
    }

    private Pair findWhereTheyMeet(List<Integer> list1, List<Integer> list2) {
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (list1.get(i).equals(list2.get(j))) {
                    Pair pair = new Pair();
                    pair.start1 = i;
                    pair.start2 = j;
                    return pair;
                }
            }
        }
        return null;
    }

    static class Pair{
        int start1;
        int start2;
    }
}
