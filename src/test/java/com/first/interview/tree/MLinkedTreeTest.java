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

    @Test
    void can_remove_a_node() {
        // given
        MLinkedTree tree = new MLinkedTree();
        tree.insert(100);
        tree.insert(80);
        tree.insert(110);
        tree.insert(75);
        tree.insert(85);
        tree.insert(65);
        tree.insert(76);
        tree.insert(84);
        tree.insert(86);
        assertThat(tree.contains(75)).isTrue();
        assertThat(tree.size()).isEqualTo(9);

        // when
        tree.remove(75);

        // then
        assertThatCode(() -> tree.contains(75)).isInstanceOf(NoSuchElementException.class);
        assertThat(tree.contains(65)).isTrue();
        assertThat(tree.size()).isEqualTo(8);
    }

    @Test
    void can_check_if_a_tree_is_empty() {
        // given
        MLinkedTree tree = new MLinkedTree();
        tree.insert(10);
        tree.insert(15);
        tree.insert(5);

        // when
        tree.remove(10);
        tree.remove(15);
        tree.remove(5);

        // then
        assertThat(tree.isEmpty()).isTrue();
    }

    @Test
    void can_remove_the_root_of_a_tree() {
        // given
        MLinkedTree tree = new MLinkedTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(2);

        // when
        tree.remove(10);

        // then
        assertThatCode(() -> tree.contains(10)).isInstanceOf(NoSuchElementException.class);
        assertThat(tree.contains(20)).isTrue();
        assertThat(tree.contains(2)).isTrue();
    }

    @Test
    void can_remove_a_node_under_one_child() {
        // given
        MLinkedTree tree = new MLinkedTree();
        tree.insert(100);
        tree.insert(110);
        tree.insert(105);
        tree.insert(115);

        // when
        tree.remove(110);

        // then
        assertThat(tree.contains(105)).isTrue();
        assertThat(tree.contains(115)).isTrue();
        assertThat(tree.size()).isEqualTo(3);
    }
}