package com.first.interview.graph;

import org.apache.commons.lang3.Validate;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toSet;

public class AdjacencyMatrixGraph implements Graph {
    private boolean[][] adjacencyMatrix;

    @Override
    public void addEdge(int x, int y) {
        if (adjacencyMatrix == null) {
            initializeMatrix(Math.max(x, y) + 1);
        }
        if (adjacencyMatrix.length <= Math.max(x, y)) {
            sizeUp(Math.max(x, y) + 1);
        }
        adjacencyMatrix[x][y] = true;
    }

    private void sizeUp(int i) {
        boolean[][] temp = new boolean[i][i];
        for (int y = 0; y < adjacencyMatrix.length; y++) {
            for (int z = 0; z < adjacencyMatrix[0].length; z++) {
                temp[y][z] = adjacencyMatrix[y][z];
            }
        }
        adjacencyMatrix = temp;
    }

    private void initializeMatrix(int i) {
        adjacencyMatrix = new boolean[i][i];
    }

    @Override
    public void bfs(Consumer<Integer> consumer) {
        Set<Integer> visited = new HashSet<>(); // nodes that were processed already
        Queue<Integer> q = new LinkedList<>(); // nodes to process
        Integer firstElement = 1;
        q.add(firstElement);
        visited.add(firstElement);

        while (!q.isEmpty()) {
            Integer node = q.poll();
            consumer.accept(node);
            for (Integer neighbour : adjacentTo(node)) {
                if (!visited.contains(neighbour)) {
                    q.add(neighbour);
                    visited.add(neighbour);
                }
            }
            if (q.isEmpty() && !visited.containsAll(allNodes())) {
                for (Integer otherNode : allNodes()) {
                    if (!visited.contains(otherNode)) {
                        q.add(otherNode);
                        visited.add(otherNode);
                        break;
                    }
                }
            }
        }
    }

    private Collection<Integer> allNodes() {
        return IntStream.range(1, adjacencyMatrix.length)
                .boxed()
                .collect(toSet());
    }

    private Set<Integer> adjacentTo(Integer node) {
        Set<Integer> neighbours = new HashSet<>();
        for (int i = 0; i < adjacencyMatrix[node].length; i++) {
            if (adjacencyMatrix[node][i]) {
                neighbours.add(i);
            }
        }
        return neighbours;
    }

    @Override
    public void dfs(Consumer<Integer> consumer) {
        Validate.notNull(consumer);
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        Integer firstElement = 1;
        stack.push(firstElement);
        visited.add(firstElement);

        while (!stack.isEmpty()) {
            Integer node = stack.pop();
            consumer.accept(node);

            for (Integer neighbour : adjacentTo(node)) {
                if (!visited.contains(neighbour)) {
                    stack.add(neighbour);
                    visited.add(neighbour);
                }
            }

            if(stack.isEmpty() && !visited.containsAll(allNodes())) {
                for (Integer otherNode : allNodes()) {
                    if(!visited.contains(otherNode)) {
                        stack.push(otherNode);
                        visited.add(otherNode);
                        break;
                    }
                }
            }
        }
    }
}
