package com.first.interview.queue;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class MArrayQueueTest {
    private final IntFunction<String[]> stringArrayCreator = String[]::new;

    @Test
    void can_enqueue_an_element() {
        // given
        MArrayQueue<String> q = new MArrayQueue<>(stringArrayCreator);
        assertThat(q.length()).isEqualTo(0);

        // when
        q.enqueue("a");

        // then
        assertThat(q.length()).isEqualTo(1);
        assertThat(q.peek()).isEqualTo("a");
    }

    @Test
    void can_enqueue_and_dequeue_multiple_elements() {
        // given
        MArrayQueue<String> q = new MArrayQueue<>(stringArrayCreator);
        assertThat(q.length()).isEqualTo(0);

        // when
        q.enqueue("a");
        q.enqueue("b");
        q.enqueue("c");

        // then
        assertThat(q.length()).isEqualTo(3);
        assertThat(q.peek()).isEqualTo("a");
        assertThat(q.dequeue()).isEqualTo("a");
        assertThat(q.dequeue()).isEqualTo("b");
        assertThat(q.dequeue()).isEqualTo("c");
        assertThat(q.length()).isEqualTo(0);
    }

    @Test
    void cannot_queue_null_element(){
        // given
        MArrayQueue<String> q = new MArrayQueue<>(stringArrayCreator);

        // when/then
        assertThatCode(() -> q.enqueue(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("cannot enqueue null element");
    }

    @Test
    void cannot_peek_or_dequeue_when_queue_is_empty() {
        // given
        MArrayQueue<String> q = new MArrayQueue<>(stringArrayCreator);

        // when/the
        assertThatCode(q::peek).isInstanceOf(NoSuchElementException.class);
        assertThatCode(q::dequeue).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void can_enqueue_large_number_of_elements() {
        // given
        MArrayQueue<String> q = new MArrayQueue<>(stringArrayCreator);

        // when
        IntStream.range(0, 1000).forEach(i -> q.enqueue(String.valueOf(i)));

        // then
        assertThat(q.length()).isEqualTo(1000);

        // when
        IntStream.range(0, 700).forEach(i -> q.dequeue());

        // then
        assertThat(q.length()).isEqualTo(300);
    }

    @Test
    void test() {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("mango");
        list.remove("mango");
        System.out.printf(list.get(0));
    }
}