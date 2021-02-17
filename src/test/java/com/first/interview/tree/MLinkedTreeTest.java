package com.first.interview.tree;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

class MLinkedTreeTest {
    @Test
    void can_add_an_element_to_a_linked_tree() {
        // given
        MLinkedTree tree = new MLinkedTree();

        // when
        tree.insert(10);
        tree.insert(20);
        tree.insert(5);

        // then
        assertThat(tree.isEmpty()).isFalse();
    }

    @Test
    void can_check_if_contains_an_element() {
        // given
        MLinkedTree tree = new MLinkedTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);

        // when/then
        assertThat(tree.contains(10)).isTrue();
        assertThat(tree.contains(15)).isTrue();

        assertThatCode(() -> tree.contains(25)).isInstanceOf(NoSuchElementException.class);

    }

}