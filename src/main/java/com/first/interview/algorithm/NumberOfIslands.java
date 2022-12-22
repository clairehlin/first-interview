package com.first.interview.algorithm;

/*
https://leetcode.com/problems/number-of-islands/
Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.



Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3

start from position(0,0) , move to four directions at any position,
move to :
x+1, y
x-1,y
x, y+1
x, y-1
turn every 1 into 2(or any numbers) to mark that number as visited
if it is not 1, skip (return)
 */
public class NumberOfIslands {
    public int numberOfIslands(char[][] grid) {
        int count = 0;

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == '1') {
                    moveFourDirections(grid, x, y);
                    count++;
                }
            }
        }
        return count;
    }

    private static void moveFourDirections(char[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length ||
            grid[x][y] != '1') {
            return;
        }

        grid[x][y] = '2';

        moveFourDirections(grid, x + 1, y);
        moveFourDirections(grid, x - 1, y);
        moveFourDirections(grid, x, y + 1);
        moveFourDirections(grid, x, y - 1);
    }
}
