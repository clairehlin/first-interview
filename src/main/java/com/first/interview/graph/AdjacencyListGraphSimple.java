package com.first.interview.graph;

import java.util.*;
import java.util.function.Consumer;

public class AdjacencyListGraphSimple implements Graph {
    private final Map<Integer, Set<Integer>> ajList = new HashMap<>();

    @Override
    public void addEdge(int x, int y) {
        if (!ajList.containsKey(x)) {
            ajList.put(x, new TreeSet<>());
        }

        if (!ajList.containsKey(y)) {
            ajList.put(y, new TreeSet<>());
        }

        if (ajList.get(x).contains(y)) {
            throw new IllegalArgumentException("element already exists");
        } else {
            ajList.get(x).add(y);
        }

    }

    @Override
    public void bfs(Consumer<Integer> consumer) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        Integer firstElement = ajList.keySet().iterator().next();
        q.add(firstElement);
        visited.add(firstElement);

        while (!q.isEmpty()) {
            Integer node = q.poll();
            consumer.accept(node);

            for (Integer neighbour : ajList.get(node)) {
                if (!visited.contains(neighbour)) {
                    q.add(neighbour);
                    visited.add(neighbour);
                }
            }
        }

    }

    @Override
    public void dfs(Consumer<Integer> consumer) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        Integer firstElement = ajList.keySet().iterator().next();
        stack.push(firstElement);
        visited.add(firstElement);

        while (!stack.isEmpty()) {
            Integer node = stack.pop();
            consumer.accept(node);

            for (Integer neighbour : ajList.get(node)) {
                if (!visited.contains(neighbour)) {
                    stack.push(neighbour);
                    visited.add(neighbour);
                }
            }
        }
    }
}
