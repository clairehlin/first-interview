package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BTPreorderTraversalTest {

    @Test
    void can_preorder_traversal_with_one_left_node() {
        // given
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        // when
        BTPreorderTraversal btPreorderTraversal = new BTPreorderTraversal();
        List<Integer> res = btPreorderTraversal.preorder(root);

        // then
        assertThat(res).isEqualTo(List.of(1, 2));
    }

    @Test
    void can_preorder_traversal_in_balanced_tree() {
        // given
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        // when
        BTPreorderTraversal btPreorderTraversal = new BTPreorderTraversal();
        List<Integer> res = btPreorderTraversal.preorder(root);

        // then
        assertThat(res).isEqualTo(List.of(1, 2, 3));
    }

    @Test
    void can_preorder_traversal_in_unbalanced_tree() {
        // given
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);


        // when
        BTPreorderTraversal btPreorderTraversal = new BTPreorderTraversal();
        List<Integer> res = btPreorderTraversal.preorder(root);

        // then
        assertThat(res).isEqualTo(List.of(1, 2, 3, 7, 8));
    }
}