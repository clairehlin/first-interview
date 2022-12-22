package com.first.interview.algorithm;

import java.util.Arrays;

public class CountMatchingInMatrix {
    public int findMatchingInMatrix(char[][] input, String word) {
        int rowSum = 0;
        int colSum = 0;
        int diag = 0;
        int wordLen = 0;

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < wordLen; j++) {
                String rowString = String.valueOf(input[i], j, wordLen);
                rowString.indexOf("");
            }
        }

        return rowSum + colSum + diag;
    }

    public int findMatchingInMatrix2(char[][] input, String word) {
        return rowsSum(input, word) + rowsSum(transpose(input), word) + rowsSum(diagonals(input), word);
    }

    private char[][] diagonals(char[][] input) {
        char[][] diagonals = new char[input.length + input[0].length - 1][];
        int index = 0;

        for (int i = input.length - 1; i >= 0; i--) {
            int rowLength = Math.min(input.length - i, input[0].length);
            char[] row = new char[rowLength];
            int currIndex = 0;

            int rowNumber = i;
            int colNumber = 0;

            while (colNumber < input[0].length && rowNumber < input.length) {
                row[currIndex] = input[rowNumber][colNumber];
                colNumber++;
                rowNumber++;
                currIndex++;
            }
            diagonals[index] = row;
            index++;
        }

        for (int i = 1; i < input[0].length; i++) {
            int rowLength = Math.min(input[0].length - i, input.length);
            char[] row = new char[rowLength];
            int currIndex = 0;

            int rowNumber = 0;
            int colNumber = i;

            while (colNumber < input[0].length && rowNumber < input.length) {
                row[currIndex] = input[rowNumber][colNumber];
                colNumber++;
                rowNumber++;
                currIndex++;
            }
            diagonals[index] = row;
            index++;
        }

        return diagonals;
    }

    private char[][] transpose(char[][] input) {
        char[][] transposed = new char[input[0].length][input.length];

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                transposed[j][i] = input[i][j];
            }
        }

        return transposed;
    }

    private int rowsSum(char[][] input, String word) {
        int sum = 0;

        for (char[] row : input) {
            sum += rowSum(row, word);
        }
        return sum;
    }

    private int rowSum(char[] row, String word) {
        int sum = 0;

        System.out.println("row:" + Arrays.toString(row));
        System.out.println("word:" + word);

        if (row == null) {
            System.out.println();
        }
        String rowText = String.valueOf(row);
        int i = rowText.indexOf(word);
        int lettersBehind = 0;

        while (i >= 0 && lettersBehind - 1 < rowText.length()) {
            sum++;
            lettersBehind += i + word.length();
            i = rowText.substring(lettersBehind - 1).indexOf(word);
        }
        return sum;
    }


}
