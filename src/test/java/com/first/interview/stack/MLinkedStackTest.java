package com.first.interview.stack;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class MLinkedStackTest {

    @Test
    void can_push_an_element_into_array_stack() {
        // given

        MLinkedStack<String> stack = new MLinkedStack<>();
        assertThat(stack.length()).isEqualTo(0);

        // when
        stack.push("a");

        // then
        assertThat(stack.length()).isEqualTo(1);
    }

    @Test
    void cannot_push_a_null_element_into_array_stack() {
        // given
        MLinkedStack<String> stack = new MLinkedStack<>();
        assertThat(stack.length()).isEqualTo(0);

        // when/then
        assertThatCode(() -> stack.push(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("cannot push null element into stack");
    }

    @Test
    void can_peek_a_top_element_from_array_stack() {
        // given
        MLinkedStack<String> stack = new MLinkedStack<>();

        // when
        stack.push("a");
        stack.push("b");

        // then
        assertThat(stack.peek()).isEqualTo("b");
    }

    @Test
    void failed_to_peek_an_element_when_stack_being_empty() {
        // given
        MLinkedStack<String> stack = new MLinkedStack<>();
        assertThat(stack.length()).isEqualTo(0);

        // when/then
        assertThatCode(stack::peek)
                .isInstanceOf(NoSuchElementException.class)
                .hasMessageContaining("cannot peek on empty stack");
    }

    @Test
    void can_pop_an_element_from_array_stack() {
        // given
        MLinkedStack<String> stack = new MLinkedStack<>();

        // when
        stack.push("a");
        stack.push("b");
        stack.push("c");
        assertThat(stack.length()).isEqualTo(3);

        // then
        assertThat(stack.pop()).isEqualTo("c");
        assertThat(stack.pop()).isEqualTo("b");
        assertThat(stack.pop()).isEqualTo("a");
        assertThat(stack.length()).isEqualTo(0);
    }

    @Test
    void cannot_pop_an_element_when_array_stack_is_empty() {
        // given
        MLinkedStack<String> stack = new MLinkedStack<>();
        assertThat(stack.length()).isEqualTo(0);

        // when/then
        assertThatCode(stack::pop)
                .isInstanceOf(NoSuchElementException.class)
                .hasMessageContaining("cannot pop from empty stack");
    }

    @Test
    void can_check_if_array_stack_is_empty() {
        // given
        MLinkedStack<String> stack = new MLinkedStack<>();

        // when/then
        assertThat(stack.isEmpty()).isTrue();

        // when
        stack.push("a");

        // then
        assertThat(stack.isEmpty()).isFalse();

        // when
        stack.pop();

        // then
        assertThat(stack.isEmpty()).isTrue();
    }

    @Test
    void can_add_large_number_of_elements() {
        // given
        MLinkedStack<Integer> stack = new MLinkedStack<>();

        // when
        IntStream.range(0, 1000).forEach(stack::push);

        // then
        assertThat(stack.length()).isEqualTo(1000);

        // when
        IntStream.range(0, 1000).forEach(i -> stack.pop());

        // then
        assertThat(stack.length()).isEqualTo(0);
    }

}