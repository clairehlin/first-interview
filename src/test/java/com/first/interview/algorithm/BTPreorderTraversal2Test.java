package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BTPreorderTraversal2Test {
    @Test
    void can_preorder_traversal_in_unbalanced_tree() {
        // given
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);


        // when
        BTPreorderTraversal2 btPreorderTraversal2 = new BTPreorderTraversal2();
        List<Integer> res = btPreorderTraversal2.preorderTraversal(root);

        // then
        assertThat(res).isEqualTo(List.of(1, 2, 3, 7, 8));
    }

}