package com.first.interview.algorithm;

/*
https://leetcode.com/discuss/interview-question/976668/chubb-online-placement-reach-the-end-in-time
A 2-D grid consisting of some blocked (represented as '#') and some unblocked (represented as '.') cells is given.
The starting position of a pointer is in the top-left corner of the grid. It is guaranteed that the starting position is in an unblocked cell.
It is also guaranteed that the bottom-right cell is unblocked. Each cell of the grid is connected with
its right, left, top, and bottom cells (if those cells exist). It takes 1 second for a pointer to move from a cell to its adjacent cell.
If the pointer can reach the bottom-right corner of the grid within k seconds, print YES. If not, print NO

For example,
Case 1

Input: "..", ".."
maximum time: 2 seconds

Output: Yes

Case 2

Input: ".*", "*."
maximum time, 2 seconds

Output: No (because the pointer cannot move to the top right (blocked )) or move to the bottom left (blocked)

 */
public class ReachEndInTime {

    static int minTime;

    static String canReach(String[] input, int max) {
        char[][] converted = convert(input);
        int rows = converted.length;
        int cols = converted[0].length;

        minTime = Integer.MAX_VALUE;

        reach(converted, max, 0, 0, new boolean[rows][cols], 0);

        if (minTime <= max) {
            System.out.println("YES");
            return "YES";
        } else {
            System.out.println("NO");
            return "NO";
        }

    }

    static char[][] convert(String[] input) {
        int rows = input.length;
        int columns = input[0].length();

        char[][] convertedArr = new char[rows][columns];

        for (int i = 0; i < rows; i++) {
            convertedArr[i] = input[i].toCharArray();
        }
        return convertedArr;
    }

    static void reach(char[][] arr, int maxTime, int i, int j, boolean[][] visited, int time) {
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] == '#' || visited[i][j] == true) {
            return;
        }

        if (i == arr.length - 1 && j == arr[0].length - 1) {
            minTime = Math.min(minTime, time);
            return;
        }

        visited[i][j] = true;

        reach(arr, maxTime, i - 1, j, visited, time + 1);
        reach(arr, maxTime, i, j - 1, visited, time + 1);
        reach(arr, maxTime, i + 1, j, visited, time + 1);
        reach(arr, maxTime, i, j + 1, visited, time + 1);

        visited[i][j] = false;

    }

    public static void main(String[] args) {
        String[] input = {".#", ".."};
        canReach(input, 2);
    }

}
