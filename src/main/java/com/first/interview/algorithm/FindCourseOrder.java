package com.first.interview.algorithm;

import java.util.*;

import static java.util.Collections.emptySet;

public class FindCourseOrder {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        int[] courseOrder = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int dst = prerequisites[i][0];
            int src = prerequisites[i][1];

            if (!adjList.containsKey(i)) {
                adjList.put(i, new TreeSet<>());
            }

            if (adjList.get(i).contains(dst)) {
                throw new IllegalArgumentException("a course already exists between " + i + "and" + dst);
            } else {
                adjList.get(i).add(dst);
            }
        }

        int firstCourse = prerequisites[0][1];
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.add(firstCourse);
        visited.add(firstCourse);
        int i = 0;

        while(!q.isEmpty()) {
            Integer node = q.poll();
            courseOrder[i++] = node;
            for (Integer neighbour : emptyIfNull(adjList.get(node))) {
                if (!visited.contains(neighbour)) {
                    q.add(neighbour);
                    visited.add(neighbour);
                }
            }
        }
        return courseOrder;
    }

    private Set<Integer> emptyIfNull(Set<Integer> neighbours) {
        return neighbours == null ? emptySet() : neighbours;
    }
}
