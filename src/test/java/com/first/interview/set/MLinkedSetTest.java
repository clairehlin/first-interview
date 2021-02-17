package com.first.interview.set;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class MLinkedSetTest<T> {

    @Test
    void can_add_an_element_to_set() {
        // given
        MLinkedSet<String> s = new MLinkedSet<>();

        // when
        s.add("a");
        s.add("b");

        // then
        assertThat(s.size()).isEqualTo(2);
        assertThat(s.contains("a")).isTrue();
        assertThat(s.contains("b")).isTrue();
    }

    @Test
    void cannot_add_duplicate_element_to_the_set() {
        // given
        MLinkedSet<String> s = new MLinkedSet<>();

        // when
        s.add("a");

        // then
        assertThatCode(() -> s.add("a")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void can_add_large_numbers_of_elements_to_set() {
        // given
        MLinkedSet<String> s = new MLinkedSet<>();

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
        MLinkedSet<String> s = new MLinkedSet<>();
        s.add("a");
        s.add("b");
        s.add("c");
        assertThat(s.size()).isEqualTo(3);

        // when
        s.remove("b");

        // then
        assertThat(s.size()).isEqualTo(2);
        assertThat(s.contains("b")).isFalse();
    }

    // cannot remove absent element from the set
    @Test
    void cannot_remove_absent_element_from_the_set() {
        // given
        MLinkedSet<String> s = new MLinkedSet<>();

        // when
        s.add("a");
        s.add("b");
        s.add("c");

        // then
        assertThatCode(() -> s.remove("abc"))
                .isInstanceOf(NoSuchElementException.class)
                .hasMessageContaining("element does not exist: " + "abc");
    }

    @Test
    void can_check_if_set_contains_an_element() {
        // given
        MLinkedSet<String> s = new MLinkedSet<>();

        // when
        s.add("a");

        // then
        assertThatCode(() -> s.add("a")).isInstanceOf(IllegalArgumentException.class);
    }

    // contains should fail for null
    @Test
    void cannot_check_if_a_set_contains_null_element() {
        // given
        MLinkedSet<String> s = new MLinkedSet<>();

        // when/then
        assertThatCode(() -> s.contains(null)).isInstanceOf(NullPointerException.class);
    }

    @Test
    void can_check_the_size_of_a_set() {
        // given/when
        MLinkedSet<String> s = new MLinkedSet<>();
        s.add("a");
        s.add("b");
        s.add("c");

        //then
        assertThat(s.size()).isEqualTo(3);
    }

    @Test
    void cannot_add_a_null_element_to_a_set() {
        // given
        MLinkedSet<String> s = new MLinkedSet<>();

        // when/then
        assertThatCode(() -> s.add(null)).isInstanceOf(NullPointerException.class);
    }

    @Test
    void cannot_remove_null_element_from_a_set() {
        // given
        MLinkedSet<String> s = new MLinkedSet<>();

        // when/then
        assertThatCode(() -> s.remove(null)).isInstanceOf(NullPointerException.class);
    }

    @Test
    void can_check_if_set_is_empty() {
        // given
        MLinkedSet<String> s = new MLinkedSet<>();

        // when/then
        assertThat(s.isEmpty()).isTrue();
    }
}