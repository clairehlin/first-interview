package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MaximumDepthBinaryTreeTest {

    @Test
    void can_find_max_depth() {
        // given
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // when
        MaximumDepthBinaryTree maximumDepthBinaryTree = new MaximumDepthBinaryTree();
        int res = maximumDepthBinaryTree.maxDepth(root);

        // then
        assertThat(res).isEqualTo(3);
    }

    @Test
    void can_find_max_depth2() {
        // given
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        // when
        MaximumDepthBinaryTree maximumDepthBinaryTree = new MaximumDepthBinaryTree();
        int res = maximumDepthBinaryTree.maxDepth(root);

        // then
        assertThat(res).isEqualTo(4);
    }

    @Test
    void can_find_max_depth_with_only_one_node() {
        // given
        TreeNode root = new TreeNode(3);

        // when
        MaximumDepthBinaryTree maximumDepthBinaryTree = new MaximumDepthBinaryTree();
        int res = maximumDepthBinaryTree.maxDepth(root);

        // then
        assertThat(res).isEqualTo(1);
    }

    @Test
    void can_find_max_depth_without_a_node() {
        // given
        TreeNode root = null;

        // when
        MaximumDepthBinaryTree maximumDepthBinaryTree = new MaximumDepthBinaryTree();
        int res = maximumDepthBinaryTree.maxDepth(root);

        // then
        assertThat(res).isEqualTo(0);
    }
}