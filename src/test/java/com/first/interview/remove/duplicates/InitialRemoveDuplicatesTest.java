package com.first.interview.remove.duplicates;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

class InitialRemoveDuplicatesTest {

    @Test
    void should_remove_duplicates() {
        // given
        char[] chars = {'a', 'a', 'b', 'c'};

        // when
        char[] output = new InitialRemoveDuplicates().apply(chars);

        // then
        assertThat(output).containsExactly('a', 'b', 'c');
    }

    @Test
    void should_not_modify_arrays_without_duplicates() {
        // given
        char[] chars = {'a', 'b', 'c'};

        // when
        char[] output = new InitialRemoveDuplicates().apply(chars);

        // then
        assertThat(output).containsExactly('a', 'b', 'c');
    }

    @Test
    void should_not_modify_empty_arrays() {
        // given
        char[] chars = {};

        // when
        char[] output = new InitialRemoveDuplicates().apply(chars);

        // then
        assertThat(output).isEmpty();
    }

    @Test
    void should_not_modify_arrays_with_one_element() {
        // given
        char[] chars = {'a'};

        // when
        char[] output = new InitialRemoveDuplicates().apply(chars);

        // then
        assertThat(output).containsExactly('a');
    }

    @Test
    void should_work_with_all_duplicates() {
        // given
        char[] chars = {'a', 'a', 'a', 'a'};

        // when
        char[] output = new InitialRemoveDuplicates().apply(chars);

        // then
        assertThat(output).containsExactly('a');
    }

    @Test
    void should_fail_on_null_arrays() {
        // given
        char[] chars = null;

        // when
        // then
        assertThatCode(() -> new InitialRemoveDuplicates().apply(chars)).isInstanceOf(NullPointerException.class);
    }
}