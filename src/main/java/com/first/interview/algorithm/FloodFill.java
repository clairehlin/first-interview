// leed code 733

package com.first.interview.algorithm;

import java.util.*;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];
        int maxRow = image.length;
        int maxCol = image[0].length;
        Queue<Pixel> queue = new LinkedList<>();
        Set<Pixel> visited = new HashSet<>();
        queue.offer(new Pixel(sr, sc));

        while (!queue.isEmpty()) {
            Pixel pixel = queue.poll();
            image[pixel.x][pixel.y] = newColor;
            Set<Pixel> neighbours = findUnprocessedOriginalColourNeighbours(pixel, visited, originalColor, maxRow, maxCol, image);
            queue.addAll(neighbours);
            visited.add(pixel);
        }
        return image;
    }

    private Set<Pixel> findUnprocessedOriginalColourNeighbours(Pixel pixel, Set<Pixel> visited, int originalColor, int maxRow, int maxCol, int[][] image) {
        int x1 = pixel.x - 1;
        int y1 = pixel.y;
        int x2 = pixel.x;
        int y2 = pixel.y - 1;
        int x3 = pixel.x + 1;
        int y3 = pixel.y;
        int x4 = pixel.x;
        int y4 = pixel.y + 1;

        Set<Pixel> neighbours = new HashSet<>();
        if (x1 >= 0 && x1 < maxRow && y1 >= 0 && y1 < maxCol) {
            Pixel p = new Pixel(x1, y1);
            if (!visited.contains(p) && image[p.x][p.y] == originalColor) {
                neighbours.add(p);
            }
        }
        if (x2 >= 0 && x2 < maxRow && y2 >= 0 && y2 < maxCol) {
            Pixel p = new Pixel(x2, y2);
            if (!visited.contains(p) && image[p.x][p.y] == originalColor) {
                neighbours.add(p);
            }
        }
        if (x3 >= 0 && x3 < maxRow && y3 >= 0 && y3 < maxCol) {
            Pixel p = new Pixel(x3, y3);
            if (!visited.contains(p) && image[p.x][p.y] == originalColor) {
                neighbours.add(p);
            }
        }
        if (x4 >= 0 && x4 < maxRow && y4 >= 0 && y4 < maxCol) {
            Pixel p = new Pixel(x4, y4);
            if (!visited.contains(p) && image[p.x][p.y] == originalColor) {
                neighbours.add(p);
            }
        }
        return neighbours;
    }

    static class Pixel {
        final int x, y;

        Pixel(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            Pixel that = (Pixel) o;
            return this.x == that.x && this.y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        FloodFill floodFill = new FloodFill();
        floodFill.floodFill(image, 1, 1, 2);
        System.out.println(Arrays.deepToString(image));

    }
}
