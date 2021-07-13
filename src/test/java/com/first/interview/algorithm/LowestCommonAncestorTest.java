package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LowestCommonAncestorTest {

    @Test
    void can_find_lca_with_two_nodes() {
        // given
        TreeNode root = new TreeNode(6);
        TreeNode p = new TreeNode(4);
        root.left = p;

        // when
        LowestCommonAncestor lca = new LowestCommonAncestor();
        TreeNode node = lca.lowestCommonAncestor(root, root , p);

        // then
        assertThat(node).isEqualTo(root);
    }

    @Test
    void can_find_lowest_common_ancestor() {
        // given
        TreeNode root = new TreeNode(6);
        TreeNode two = new TreeNode(2);
        TreeNode zero = new TreeNode(0);
        TreeNode four = new TreeNode(4);
        root.left = two;
        two.left = zero;
        two.right = four;


        TreeNode eight = new TreeNode(8);
        TreeNode seven = new TreeNode(7);
        TreeNode nine = new TreeNode(9);
        root.right = eight;
        eight.left = seven;
        eight.right = nine;

        // when
        LowestCommonAncestor lca = new LowestCommonAncestor();
        TreeNode node = lca.lowestCommonAncestor(root, two, four);

        // then
        assertThat(node).isEqualTo(two);
    }
}