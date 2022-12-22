package com.first.interview.algorithm;
/*
https://leetcode.com/problems/pascals-triangle/submissions/
first, handle first row, only 1 element
from 2nd row, create two for loops
outer for loop, create rows and get the previous row
inner for loop, add elements to each row. Each element value equals previous row (previous element value + current element value)
 */
import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        // Base case; first row is always [1].
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum-1);

            // The first element of a row is always 1.
            row.add(1);

            // Each triangle element (other than the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and
            // above-and-to-the-right.
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }

            // The last row element is always 1.
            row.add(1);

            triangle.add(row);
        }
        return triangle;
    }
}

