package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InvertBinaryTreeTest {
    @Test
    void can_invert_binary_tree() {
        // given
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(3);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(9);

        InvertBinaryTree tree = new InvertBinaryTree();

        //when
        tree.invertTree(root);

        // then
        assertThat(root.left.val).isEqualTo(7);
    }

}