package com.first.interview.algorithm;

import java.util.ArrayList;
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
public class SearchMultiRange {

    public List<List<Integer>> searchRange(List<Integer> list1, List<Integer> list2) {
        Range nextRange = new Range(-1, -1, null);

        List<List<Integer>> intersectionList = new ArrayList<>();

        while (nextRange.endPoint1 < list1.size() - 1 && nextRange.endPoint2 < list2.size() - 1) {
            nextRange = findNextRange(list1, list2, nextRange.endPoint1 + 1, nextRange.endPoint2 + 1);
            if (!nextRange.result.isEmpty()) {
                intersectionList.add(nextRange.result);
            }
        }
        return intersectionList;
    }

    private Range findNextRange(List<Integer> list1, List<Integer> list2, int startPoint1, int startPoint2) {
        IntersectionStartingPoints intersectionStartingPoints = findWhereTheyMeet(list1, list2, startPoint1, startPoint2);
        if (intersectionStartingPoints == null) {
            return new Range(list1.size() - 1, list2.size() - 1, Collections.emptyList());
        }

        List<Integer> result = new ArrayList<>();

        int start1 = intersectionStartingPoints.start1;
        int start2 = intersectionStartingPoints.start2;

        while (list1.size() > start1 && list2.size() > start2
                && list1.get(start1).equals(list2.get(start2)))
        {
            result.add(list1.get(start1));
            start1++;
            start2++;
        }

        return new Range(start1 - 1, start2 - 2, result);
    }

    private IntersectionStartingPoints findWhereTheyMeet(List<Integer> list1, List<Integer> list2, int startPoint1, int startPoint2) {
        for (int i = startPoint1; i < list1.size(); i++) {
            for (int j = startPoint2; j < list2.size(); j++) {
                if (list1.get(i).equals(list2.get(j))) {
                    return new IntersectionStartingPoints(i, j);
                }
            }
        }
        return null;
    }

    static class IntersectionStartingPoints {
        private final int start1;
        private final int start2;

        IntersectionStartingPoints(int start1, int start2) {
            this.start1 = start1;
            this.start2 = start2;
        }
    }

    static class Range {
        private final int endPoint1;
        private final int endPoint2;
        private final List<Integer> result;

        Range(int endPoint1, int endPoint2, List<Integer> result) {
            this.endPoint1 = endPoint1;
            this.endPoint2 = endPoint2;
            this.result = result;
        }
    }
}
