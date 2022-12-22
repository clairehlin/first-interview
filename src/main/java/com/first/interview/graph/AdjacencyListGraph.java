package com.first.interview.graph;
/*
BFS - use set and queue
DFS - use set and stack
 */
import org.apache.commons.lang3.Validate;

import java.util.*;
import java.util.function.Consumer;

import static java.util.Collections.emptySet;

public class AdjacencyListGraph implements Graph {
    private final Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();

    @Override
    public void addEdge(int x, int y) {
        if (!adjacencyList.containsKey(x)) {
            adjacencyList.put(x, new TreeSet<>());
        }
        if (!adjacencyList.containsKey(y)) {
            adjacencyList.put(y, new TreeSet<>());
        }
        if (adjacencyList.get(x).contains(y)) {
            throw new IllegalArgumentException("an edge already exists between " + x + " and " + y);
        } else {
            adjacencyList.get(x).add(y);
        }
    }

    @Override
    public void bfs(Consumer<Integer> consumer) {
        Set<Integer> visited = new HashSet<>(); // nodes that were processed already
        Queue<Integer> q = new LinkedList<>(); // nodes to process
        Integer firstElement = adjacencyList.keySet().iterator().next();
        q.add(firstElement);
        visited.add(firstElement);

        while (!q.isEmpty()) {
            Integer node = q.poll();
            consumer.accept(node);
            for (Integer neighbour : emptyIfNull(adjacencyList.get(node))) {
                if (!visited.contains(neighbour)) {
                    q.add(neighbour);
                    visited.add(neighbour);
                }
            }
            if (q.isEmpty() && !visited.containsAll(adjacencyList.keySet())) {
                for (Integer otherNode : adjacencyList.keySet()) {
                    if (!visited.contains(otherNode)) {
                        q.add(otherNode);
                        visited.add(otherNode);
                        break;
                    }
                }
            }
        }
    }

    private Set<Integer> emptyIfNull(Set<Integer> neighbours) {
        return neighbours == null ? emptySet() : neighbours;
    }

    @Override
    public void dfs(Consumer<Integer> consumer) {
        Validate.notNull(consumer);
        Set<Integer> visited = new HashSet<>(); // nodes that were processed already
        Stack<Integer> stack = new Stack<>(); // nodes to process
        Integer firstElement = adjacencyList.keySet().iterator().next();
        stack.add(firstElement);
        visited.add(firstElement);

        while (!stack.isEmpty()) {
            Integer node = stack.pop();
            consumer.accept(node);
            for (Integer neighbour : emptyIfNull(adjacencyList.get(node))) {
                if (!visited.contains(neighbour)) {
                    stack.add(neighbour);
                    visited.add(neighbour);
                }
            }
            // this is to recover when the initial element is not connected to all other nodes in the graph,
            // in which case we will end up with unvisited nodes.
            // for example, 3 --> 1 , starting from 1. we will never get to 3 without the below code
            if (stack.isEmpty() && !visited.containsAll(adjacencyList.keySet())) {
                for (Integer otherNode : adjacencyList.keySet()) {
                    if (!visited.contains(otherNode)) {
                        stack.push(otherNode);
                        visited.add(otherNode);
                        break;
                    }
                }
            }
        }
    }

    public void bfs2(Consumer<Integer> consumer) {
        Queue<Integer> q = new LinkedList<>(); // nodes to process
        fs(consumer, new Tracker() {
            @Override
            public Integer take() {
                return q.poll();
            }

            @Override
            public void take(Integer i) {
                q.offer(i);
            }

            @Override
            public boolean isEmpty() {
                return q.isEmpty();
            }
        });
    }

    public void dfs2(Consumer<Integer> consumer) {
        Stack<Integer> stack = new Stack<>(); // nodes to process
        fs(consumer, new Tracker() {
            @Override
            public Integer take() {
                return stack.pop();
            }

            @Override
            public void take(Integer i) {
                stack.push(i);
            }

            @Override
            public boolean isEmpty() {
                return stack.isEmpty();
            }
        });
    }

    private void fs(Consumer<Integer> consumer, Tracker tracker) {
        Set<Integer> visited = new HashSet<>(); // nodes that were processed already
        Integer firstElement = adjacencyList.keySet().iterator().next();
        tracker.take(firstElement);
        visited.add(firstElement);

        while (!tracker.isEmpty()) {
            Integer node = tracker.take();
            consumer.accept(node);
            for (Integer neighbour : emptyIfNull(adjacencyList.get(node))) {
                if (!visited.contains(neighbour)) {
                    tracker.take(neighbour);
                    visited.add(neighbour);
                }
            }
            if (tracker.isEmpty() && !visited.containsAll(adjacencyList.keySet())) {
                for (Integer otherNode : adjacencyList.keySet()) {
                    if (!visited.contains(otherNode)) {
                        tracker.take(otherNode);
                        visited.add(otherNode);
                        break;
                    }
                }
            }
        }
    }

    static interface Tracker {
        Integer take();
        void take(Integer i);
        boolean isEmpty();
    }
}
