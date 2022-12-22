package com.first.interview.graph;

import java.util.*;
import java.util.function.Consumer;

public class AdjListGraph {
    private final Map<Integer, Set<Integer>> adj = new HashMap<>();

    public void addEdge(int x, int y) {
        if (!adj.containsKey(x)) {
            adj.put(x, new TreeSet<>());
        }

        if (!adj.containsKey(y)) {
            adj.put(y, new TreeSet<>());
        }

        adj.get(x).add(y);
        adj.get(y).add(x);
    }

    public void bfs() {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        Integer start = adj.keySet().iterator().next();
        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            System.out.println(node);
            Set<Integer> values = adj.get(node);
            for (Integer element : values) {
                if (!visited.contains(element)) {
                    visited.add(element);
                    queue.add(element);
                }
            }
        }
    }

    public void dfs() {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        int start = adj.keySet().iterator().next();
        visited.add(start);
        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            System.out.println(node);

            Set<Integer> values = adj.get(node);
            for (Integer element : values) {
                if (!visited.contains(element)) {
                    stack.push(element);
                    visited.add(element);
                }
            }
        }
    }
}
