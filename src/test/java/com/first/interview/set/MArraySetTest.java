package com.first.interview.set;

import org.junit.jupiter.api.Test;

import java.util.function.IntFunction;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class MArraySetTest<T> {
    IntFunction<String[]> stringArray = String[]::new;

    @Test
    void can_add_an_element_to_set() {
        // given
        MArraySet<String> s = new MArraySet<>(stringArray);

        // when
        s.add("a");
        s.add("b");

        // then
        assertThat(s.size()).isEqualTo(2);
        assertThat(s.contains("a")).isTrue();
        assertThat(s.contains("b")).isTrue();
    }

    @Test
    void can_add_large_numbers_of_elements_to_set() {
        // given
        MArraySet<String> s = new MArraySet<>(stringArray);

        // when
        IntStream.range(0, 1000).forEach(
                element -> s.add(Integer.toString(element))
        );

        // then
        assertThat(s.size()).isEqualTo(1000);
    }

    @Test
    void can_remove_an_element_from_set() {
        // given
        MArraySet<String> s = new MArraySet<>(stringArray);
        s.add("a");
        s.add("b");
        s.add("c");

        // when
        s.remove("b");

        // then
        assertThat(s.size()).isEqualTo(2);
        assertThat(s.contains("b")).isFalse();
    }

    @Test
    void can_check_if_set_contains_an_element() {
        // given
        MArraySet<String> s = new MArraySet<>(stringArray);

        // when
        s.add("a");

        // then
        assertThatCode(() -> s.add("a")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void can_check_the_size_of_a_set() {
        // given/when
        MArraySet<String> s = new MArraySet<>(stringArray);
        s.add("a");
        s.add("b");
        s.add("c");

        //then
        assertThat(s.size()).isEqualTo(3);
    }

    @Test
    void cannot_add_a_null_element_to_a_set() {
        // given
        MArraySet<String> s = new MArraySet<>(stringArray);

        // when/then
        assertThatCode(() -> s.add(null)).isInstanceOf(NullPointerException.class);
    }

    @Test
    void cannot_remove_null_element_from_a_set() {
        // given
        MArraySet<String> s = new MArraySet<>(stringArray);

        // when/then
        assertThatCode(() -> s.remove(null)).isInstanceOf(NullPointerException.class);
    }
}