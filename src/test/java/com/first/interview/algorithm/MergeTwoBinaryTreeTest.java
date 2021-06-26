package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MergeTwoBinaryTreeTest {

    @Test
    void mergeTrees() {
        // given
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.left.left = new TreeNode(5);
        root1.right = new TreeNode(2);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.left.right = new TreeNode(4);
        root2.right = new TreeNode(3);
        root2.right.right = new TreeNode(7);

        // when
        MergeTwoBinaryTree mergeTwoBinaryTree = new MergeTwoBinaryTree();
        TreeNode mergedTree = mergeTwoBinaryTree.mergeTrees(root1, root2);

        // then
        assertThat(mergedTree.val).isEqualTo(3);

        assertThat(mergedTree.left.val).isEqualTo(4);
        assertThat(mergedTree.left.left.val).isEqualTo(5);
        assertThat(mergedTree.left.right.val).isEqualTo(4);
        assertThat(mergedTree.left.left.left).isNull();
        assertThat(mergedTree.left.left.right).isNull();

        assertThat(mergedTree.right.val).isEqualTo(5);
        assertThat(mergedTree.right.right.val).isEqualTo(7);
        assertThat(mergedTree.right.left).isNull();
        assertThat(mergedTree.right.right.left).isNull();
        assertThat(mergedTree.right.right.right).isNull();

    }
}