package com.first.interview.graph;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AdjacencyListGraphSimpleTest {
    @Test
    void can_bfs() {
        // given
        Graph graph = new AdjacencyListGraphSimple();
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 6);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(5, 6);
        graph.addEdge(5, 1);

        List<Integer> actual = new ArrayList<>();
        Consumer<Integer> collector = actual::add;

        // when
        graph.dfs(collector);

        // then
        List<Integer> expected = List.of(1, 3, 5, 6, 4, 2);
        assertThat(actual).isEqualTo(expected);
    }
}