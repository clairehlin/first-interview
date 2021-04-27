package com.first.interview.graph;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;

class AdjacencyMatrixGraphTest {
    @Test
    void can_bfs() {
        // given
        Graph graph = new AdjacencyMatrixGraph();
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
        AdjacencyMatrixGraphTest.MaxFinder maxFinder = new AdjacencyMatrixGraphTest.MaxFinder();
        AdjacencyMatrixGraphTest.MinFinder minFinder = new AdjacencyMatrixGraphTest.MinFinder();
        AdjacencyMatrixGraphTest.SumFinder sumFinder = new AdjacencyMatrixGraphTest.SumFinder();

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
        Graph graph = new AdjacencyMatrixGraph();
        graph.addEdge(3, 1);

        List<Integer> actual = new ArrayList<>();
        Consumer<Integer> printer = System.out::println;
        Consumer<Integer> collector = actual::add; // equivalent to i -> actual.add(i)
        AdjacencyMatrixGraphTest.MaxFinder maxFinder = new AdjacencyMatrixGraphTest.MaxFinder();
        AdjacencyMatrixGraphTest.MinFinder minFinder = new AdjacencyMatrixGraphTest.MinFinder();
        AdjacencyMatrixGraphTest.SumFinder sumFinder = new AdjacencyMatrixGraphTest.SumFinder();

        // when
        graph.bfs(collector);
        graph.bfs(maxFinder);
        graph.bfs(minFinder);
        graph.bfs(sumFinder);
        graph.bfs(printer);


        // then
        List<Integer> expected = List.of(1, 2, 3);
        assertThat(expected).isEqualTo(actual);
        assertThat(maxFinder.max).isEqualTo(3);
        assertThat(minFinder.min).isEqualTo(1);
        assertThat(sumFinder.sum).isEqualTo(6);
    }

    @Test
    void can_bfs_disconnected2() {
        // given
        Graph graph = new AdjacencyMatrixGraph();
        graph.addEdge(3, 1);
        graph.addEdge(6, 8);

        List<Integer> actual = new ArrayList<>();
        Consumer<Integer> printer = System.out::println;
        Consumer<Integer> collector = actual::add; // equivalent to i -> actual.add(i)
        AdjacencyMatrixGraphTest.MaxFinder maxFinder = new AdjacencyMatrixGraphTest.MaxFinder();
        AdjacencyMatrixGraphTest.MinFinder minFinder = new AdjacencyMatrixGraphTest.MinFinder();
        AdjacencyMatrixGraphTest.SumFinder sumFinder = new AdjacencyMatrixGraphTest.SumFinder();

        // when
        graph.bfs(collector);
        graph.bfs(maxFinder);
        graph.bfs(minFinder);
        graph.bfs(sumFinder);
        graph.bfs(printer);


        // then
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 8, 7);
        assertThat(expected).isEqualTo(actual);
        assertThat(maxFinder.max).isEqualTo(8);
        assertThat(minFinder.min).isEqualTo(1);
        assertThat(sumFinder.sum).isEqualTo(36);
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
        Graph graph = new AdjacencyMatrixGraph();
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
        AdjacencyMatrixGraphTest.MaxFinder maxFinder = new AdjacencyMatrixGraphTest.MaxFinder();
        AdjacencyMatrixGraphTest.MinFinder minFinder = new AdjacencyMatrixGraphTest.MinFinder();
        AdjacencyMatrixGraphTest.SumFinder sumFinder = new AdjacencyMatrixGraphTest.SumFinder();

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
        Graph graph = new AdjacencyMatrixGraph();
        graph.addEdge(2, 1);

        List<Integer> actual = new ArrayList<>();
        Consumer<Integer> printer = System.out::println;
        Consumer<Integer> collector = actual::add; // equivalent to i -> actual.add(i)
        AdjacencyMatrixGraphTest.MaxFinder maxFinder = new AdjacencyMatrixGraphTest.MaxFinder();
        AdjacencyMatrixGraphTest.MinFinder minFinder = new AdjacencyMatrixGraphTest.MinFinder();
        AdjacencyMatrixGraphTest.SumFinder sumFinder = new AdjacencyMatrixGraphTest.SumFinder();

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

    @Test
    void can_dfs_disconnected2() {
        // given
        Graph graph = new AdjacencyMatrixGraph();
        graph.addEdge(2, 1);
        graph.addEdge(6, 4);

        List<Integer> actual = new ArrayList<>();
        Consumer<Integer> printer = System.out::println;
        Consumer<Integer> collector = actual::add; // equivalent to i -> actual.add(i)
        AdjacencyMatrixGraphTest.MaxFinder maxFinder = new AdjacencyMatrixGraphTest.MaxFinder();
        AdjacencyMatrixGraphTest.MinFinder minFinder = new AdjacencyMatrixGraphTest.MinFinder();
        AdjacencyMatrixGraphTest.SumFinder sumFinder = new AdjacencyMatrixGraphTest.SumFinder();

        // when
        graph.dfs(collector);
        graph.dfs(maxFinder);
        graph.dfs(minFinder);
        graph.dfs(sumFinder);
        graph.dfs(printer);

        // then
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
        assertThat(expected).isEqualTo(actual);
        assertThat(maxFinder.max).isEqualTo(6);
        assertThat(minFinder.min).isEqualTo(1);
//        assertThat(sumFinder.sum).isEqualTo(3);
    }

    @Test
    void can_bfs_disconnected3() {
        // given
        Graph graph = new AdjacencyMatrixGraph();
        graph.addEdge(2, 1);
        graph.addEdge(6, 4);

        List<Integer> actual = new ArrayList<>();
        Consumer<Integer> printer = System.out::println;
        Consumer<Integer> collector = actual::add;

        // when
        graph.bfs(printer);
        graph.bfs(collector);

        // then
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
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