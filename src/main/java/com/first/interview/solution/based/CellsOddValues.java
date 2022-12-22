package com.first.interview.solution.based;

public class CellsOddValues {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] array = new int[m][n];

        for (int[] index : indices) {
            int row = index[0];
            int col = index[1];

            // loop through all the columns
            for (int i = 0; i < n; i++) {
                array[row][i]++;
            }

            // loop through all the rows
            for (int i = 0; i < m; i++) {
                array[i][col]++;
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] % 2 != 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
