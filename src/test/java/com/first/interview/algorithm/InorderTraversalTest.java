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
        TreeNode right = new TreeNode(2);
        TreeNode rightLeft = new TreeNode(3);
        right = root.right;
        rightLeft = right.left;

        // when
        InorderTraversal inorder = new InorderTraversal();
        List<Integer> list = inorder.inorderTraversal(root);

        // then
        System.out.println(list);
    }

}