package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InorderTraversalTest {
    @Test
    void can_inorder_traverse_a_tree() {
        // given
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        // when
        InorderTraversal inorder = new InorderTraversal();
        List<Integer> list = inorder.inorderTraversal(root);

        // then
        System.out.println(list);
    }

    @Test
    void can_inorder_traverse_a_tree_with_one_node() {
        // given
        TreeNode root = new TreeNode(1);

        // when
        InorderTraversal inorder = new InorderTraversal();
        List<Integer> list = inorder.inorderTraversal(root);

        // then
        System.out.println(list);
    }

    @Test
    void can_inorder_traverse_a_tree_with_null_element() {
        // given
        TreeNode root = null;

        // when
        InorderTraversal inorder = new InorderTraversal();
        List<Integer> list = inorder.inorderTraversal(root);

        // then
        assertThat(list).isEmpty();
    }

}