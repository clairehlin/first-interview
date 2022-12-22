package com.first.interview.solution.based;

import java.util.*;

// leetcode 1971 Find if path exists in Graph
public class FindPath {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        if (n == 1) {
            return true;
        }

        Map<Integer, Set<Integer>> graph = buildMap(edges);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        Set<Integer> visited = new HashSet<>();
        visited.add(start);

        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();

            Set<Integer> neighbours = graph.get(vertex);

            for (Integer neighbour : neighbours) {
                if (neighbour == end) {
                    return true;
                }

                if (!visited.contains(neighbour)) {
                    queue.add(neighbour);
                    visited.add(neighbour);
                }
            }
        }
        return false;
    }

    private Map<Integer, Set<Integer>> buildMap(int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            int vertexU = edges[i][0];
            int vertexV = edges[i][1];

            addEdge(graph, vertexU, vertexV);
        }
        return graph;
    }

    private void addEdge(Map<Integer, Set<Integer>> graph, int vertexU, int vertexV) {
        if (!graph.containsKey(vertexU)) {
            graph.put(vertexU, new TreeSet<>());
        }

        if (!graph.containsKey(vertexV)) {
            graph.put(vertexV, new TreeSet<>());
        }

        graph.get(vertexU).add(vertexV);
        graph.get(vertexV).add(vertexU);
    }

    public boolean validPathMatrix(int n, int[][] edges, int start, int end) {
        if (n == 1) {
            return true;
        }

        boolean[][] graph = new boolean[n][n];

        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = true;
            graph[edge[1]][edge[0]] = true;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        Set<Integer> visited = new HashSet<>();
        visited.add(start);

        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();

            for (int i = 0; i < n; i++) {
                if (graph[vertex][i]) {
                    if (i == end) {
                        return true;
                    }
                    Integer boxed = i;

                    if (!visited.contains(boxed)) {
                        queue.add(boxed);
                        visited.add(boxed);
                    }
                }
            }
        }
        return false;
    }
}
