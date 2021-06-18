package com.first.interview.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> initial = Arrays.asList(1);
        res.add(initial);
        int rowNum = 1;

        while (rowNum < numRows) {
            res.add(buildElement(res.get(rowNum - 1), rowNum));
            rowNum++;
        }
        return res;
    }

    private List<Integer> buildElement(List<Integer> preRow, int rowNum) {
        List<Integer> current = new ArrayList<>();
        current.add(1);

        for (int i = 1; i < rowNum; i++) {
            current.add(preRow.get(i - 1) + preRow.get(i));
        }

        current.add(1);
        return current;
    }
}
