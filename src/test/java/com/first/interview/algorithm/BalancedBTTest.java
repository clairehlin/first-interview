package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BalancedBTTest {

    @Test
    void can_find_if_tree_being_balanced_binary_tree() {
        // given
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // when
        BalancedBT bbt = new BalancedBT();
        boolean result = bbt.isBalanced(root);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void can_find_if_tree_being_unbalanced_binary_tree() {
        // given
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);

        // when
        BalancedBT bbt = new BalancedBT();
        boolean result = bbt.isBalanced(root);

        // then
        assertThat(result).isFalse();
    }

    @Test
    void can_find_if_tree_being_unbalanced_right_tree_is_higher() {
        // given
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(3);
        root.right.right.left = new TreeNode(4);
        root.right.right.right = new TreeNode(4);

        // when
        BalancedBT bbt = new BalancedBT();
        boolean result = bbt.isBalanced(root);

        // then
        assertThat(result).isFalse();
    }

    @Test
    void can_find_if_tree_being_balanced_and_empty() {
        // given
        TreeNode root = null;

        // when
        boolean result = new BalancedBT().isBalanced(root);

        // then
        assertThat(result).isTrue();
    }
}