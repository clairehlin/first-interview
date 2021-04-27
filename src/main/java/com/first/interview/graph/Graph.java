package com.first.interview.graph;

import java.util.function.Consumer;

public interface Graph {
    void addEdge(int x, int y);
    void bfs(Consumer<Integer> consumer);
    void dfs(Consumer<Integer> consumer);
}
