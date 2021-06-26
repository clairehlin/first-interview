package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SameTreeTest {

    @Test
    void can_identify_if_two_trees_being_the_same() {
        // given
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        // when
        boolean result = new SameTree().isSameTree(p, q);

        // then
        assertThat(result).isEqualTo(true);

    }

    @Test
    void can_identify_if_being_same_tree_or_not_with_two_nodes_only() {
        // given
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);

        TreeNode q = new TreeNode(1);
        q.right = new TreeNode(2);

        // when
        boolean result = new SameTree().isSameTree(p, q);

        // then
        assertThat(result).isEqualTo(false);

    }
}