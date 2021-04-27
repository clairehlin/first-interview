package com.first.interview.search;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

abstract class AbstractBinarySearchTest {

    protected abstract ListSearch listSearch(List<Integer> list);

    @Test
    void can_find_existing_element() {
        // given
        List<Integer> list = List.of(7, 9, 13, 17, 19, 23, 29, 31, 33);

        // when
        ListSearch bls = listSearch(list);

        // then
        assertThat(bls.positionOf(29)).isEqualTo(6);
        assertThat(bls.positionOf(9)).isEqualTo(1);
        assertThat(bls.positionOf(7)).isEqualTo(0);
        assertThat(bls.positionOf(33)).isEqualTo(8);
    }

    @Test
    void cannot_find_an_element_in_empty_list() {
        // given
        List<Integer> list = emptyList();

        // when
        ListSearch bls = listSearch(list);

        // then
        assertThatCode(() -> bls.positionOf(10)).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void can_find_an_element_in_one_element_list() {
        // given
        List<Integer> list = List.of(3);

        // when
        ListSearch bls = listSearch(list);

        // then
        assertThat(bls.positionOf(3)).isEqualTo(0);
    }

    @Test
    void can_find_an_element_in_two_elements_list() {
        // given
        List<Integer> list = List.of(10, 20);

        // when
        ListSearch bls = listSearch(list);

        // then
        assertThat(bls.positionOf(10)).isEqualTo(0);
        assertThat(bls.positionOf(20)).isEqualTo(1);

    }

    @Test
    void cannot_find_non_existing_element() {
        // given
        List<Integer> list = List.of(7, 9, 13, 17, 19, 23, 29, 31, 33);

        // when
        ListSearch bls = listSearch(list);

        // then
        assertThatCode(() -> bls.positionOf(18)).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void cannot_accept_null() {
        // given
        List<Integer> list = List.of(1, 2, 3);

        // when
        ListSearch bls = listSearch(list);

        // then
        assertThatCode(() -> bls.positionOf(null)).isInstanceOf(NullPointerException.class);
        assertThatCode(() -> listSearch(null)).isInstanceOf(NullPointerException.class);
    }
}