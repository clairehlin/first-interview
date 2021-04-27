package com.first.interview.graph;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;

class AdjacencyListGraphTest {
    @Test
    void can_bfs() {
        // given
        Graph graph = new AdjacencyListGraph();
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 6);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(5, 6);
        graph.addEdge(5, 1);

        List<Integer> actual = new ArrayList<>();
        Consumer<Integer> printer = System.out::println;
        Consumer<Integer> collector = actual::add; // equivalent to i -> actual.add(i)
        MaxFinder maxFinder = new MaxFinder();
        MinFinder minFinder = new MinFinder();
        SumFinder sumFinder = new SumFinder();

        // when
        graph.bfs(collector);
        graph.bfs(maxFinder);
        graph.bfs(minFinder);
        graph.bfs(sumFinder);
        graph.bfs(printer);


        // then
        List<Integer> expected = List.of(1, 2, 3, 4, 6, 5);
        assertThat(expected).isEqualTo(actual);
        assertThat(maxFinder.max).isEqualTo(6);
        assertThat(minFinder.min).isEqualTo(1);
        assertThat(sumFinder.sum).isEqualTo(21);
    }

    @Test
    void can_bfs_disconnected() {
        // given
        Graph graph = new AdjacencyListGraph();
        graph.addEdge(3, 1);

        List<Integer> actual = new ArrayList<>();
        Consumer<Integer> printer = System.out::println;
        Consumer<Integer> collector = actual::add; // equivalent to i -> actual.add(i)
        MaxFinder maxFinder = new MaxFinder();
        MinFinder minFinder = new MinFinder();
        SumFinder sumFinder = new SumFinder();

        // when
        graph.bfs(collector);
        graph.bfs(maxFinder);
        graph.bfs(minFinder);
        graph.bfs(sumFinder);
        graph.bfs(printer);


        // then
        List<Integer> expected = List.of(1, 3);
        assertThat(expected).isEqualTo(actual);
        assertThat(maxFinder.max).isEqualTo(3);
        assertThat(minFinder.min).isEqualTo(1);
        assertThat(sumFinder.sum).isEqualTo(4);
    }

    @Test
    void can_bfs_disconnected2() {
        // given
        Graph graph = new AdjacencyListGraph();
        graph.addEdge(3, 1);
        graph.addEdge(6, 10);
        graph.addEdge(10, 13);

        List<Integer> actual = new ArrayList<>();
        Consumer<Integer> printer = System.out::println;
        Consumer<Integer> collector = actual::add; // equivalent to i -> actual.add(i)
        MaxFinder maxFinder = new MaxFinder();
        MinFinder minFinder = new MinFinder();
        SumFinder sumFinder = new SumFinder();

        // when
        graph.bfs(collector);
        graph.bfs(maxFinder);
        graph.bfs(minFinder);
        graph.bfs(sumFinder);
        graph.bfs(printer);


        // then
        List<Integer> expected = List.of(1, 3, 6, 10, 13);
        assertThat(expected).isEqualTo(actual);
        assertThat(maxFinder.max).isEqualTo(13);
        assertThat(minFinder.min).isEqualTo(1);
        assertThat(sumFinder.sum).isEqualTo(33);
    }

    @Test
    void can_dfs() {
        Set<Integer> set = new TreeSet<>();
        set.add(2);
        set.add(3);
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        // given
        Graph graph = new AdjacencyListGraph();
        graph.addEdge(1, 3 );
        graph.addEdge(1, 2);
        graph.addEdge(2, 6);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(5, 6);
        graph.addEdge(5, 1);

        List<Integer> actual = new ArrayList<>();
        Consumer<Integer> printer = System.out::println;
        Consumer<Integer> collector = actual::add; // equivalent to i -> actual.add(i)
        MaxFinder maxFinder = new MaxFinder();
        MinFinder minFinder = new MinFinder();
        SumFinder sumFinder = new SumFinder();

        // when
        graph.dfs(collector);
        graph.dfs(maxFinder);
        graph.dfs(minFinder);
        graph.dfs(sumFinder);
        graph.dfs(printer);


        // then
        List<Integer> expected = List.of(1, 3, 5, 6, 4, 2);
        assertThat(expected).isEqualTo(actual);
        assertThat(maxFinder.max).isEqualTo(6);
        assertThat(minFinder.min).isEqualTo(1);
        assertThat(sumFinder.sum).isEqualTo(21);
    }

    @Test
    void can_dfs_disconnected() {
        // given
        Graph graph = new AdjacencyListGraph();
        graph.addEdge(2, 1);

        List<Integer> actual = new ArrayList<>();
        Consumer<Integer> printer = System.out::println;
        Consumer<Integer> collector = actual::add; // equivalent to i -> actual.add(i)
        MaxFinder maxFinder = new MaxFinder();
        MinFinder minFinder = new MinFinder();
        SumFinder sumFinder = new SumFinder();

        // when
        graph.dfs(collector);
        graph.dfs(maxFinder);
        graph.dfs(minFinder);
        graph.dfs(sumFinder);
        graph.dfs(printer);

        // then
        List<Integer> expected = List.of(1, 2);
        assertThat(expected).isEqualTo(actual);
        assertThat(maxFinder.max).isEqualTo(2);
        assertThat(minFinder.min).isEqualTo(1);
        assertThat(sumFinder.sum).isEqualTo(3);
    }

    static class MaxFinder implements Consumer<Integer> {
        private Integer max = Integer.MIN_VALUE;

        @Override
        public void accept(Integer input) {
            max = Math.max(input, max);
        }
    }

    static class MinFinder implements Consumer<Integer> {
        private Integer min = Integer.MAX_VALUE;

        @Override
        public void accept(Integer input) {
            min = Math.min(input, min);
        }
    }

    static class SumFinder implements Consumer<Integer> {
        private Integer sum = 0;

        @Override
        public void accept(Integer input) {
            sum += input;
        }
    }
}