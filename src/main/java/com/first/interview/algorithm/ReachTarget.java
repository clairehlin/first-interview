package com.first.interview.algorithm;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ReachTarget {
    private static final Point startingPoint = new Point(0, 0);
    private static Point target;

    boolean canReachTarget(String[] input, int maxTime) {
        target = new Point(input.length - 1, input[0].length() - 1);
        Set<Point> parentsPath = new HashSet<>();
        parentsPath.add(startingPoint);

        return canArrive(parentsPath, startingPoint, 0, maxTime);
    }

    private boolean canArrive(Set<Point> parentsPath, Point current, int totalTime, int maxTime) {
        if (totalTime > maxTime) {
            return false;
        }

        if (current.equals(target)) {
            return true;
        }

        boolean moveRight = false;
        boolean moveLeft = false;
        boolean moveUp = false;
        boolean moveDown = false;

        Point rightPoint = new Point(current.x + 1, current.y);
        if (rightPoint.x <= target.x && !parentsPath.contains(rightPoint)) {
            parentsPath.add(rightPoint);
            moveRight = canArrive(parentsPath, rightPoint, totalTime + 1, maxTime);
        }

        Point leftPoint = new Point(current.x - 1, current.y);
        if ((leftPoint.x >= 0 && !parentsPath.contains(leftPoint))) {
            parentsPath.add(leftPoint);
            moveLeft = canArrive(parentsPath, leftPoint, totalTime + 1, maxTime);
        }

        Point upPoint = new Point(current.x, current.y - 1);
        if ((upPoint.y >= 0 && !parentsPath.contains(upPoint))) {
            parentsPath.add(upPoint);
            moveUp = canArrive(parentsPath, upPoint, totalTime + 1, maxTime);
        }

        Point downPoint = new Point(current.x, current.y + 1);
        if ((downPoint.y >= 0 && !parentsPath.contains(downPoint))) {
            parentsPath.add(downPoint);
            moveDown = canArrive(parentsPath, downPoint, totalTime + 1, maxTime);
        }

        return (moveRight) || (moveLeft) || (moveUp) || (moveDown);
    }

    private static class Point {
        private final int x, y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
        }
    }
}
