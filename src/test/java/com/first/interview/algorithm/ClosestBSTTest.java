package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ClosestBSTTest {

    @Test
    void can_find_closet_node1() {
        // given
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        double target = 3.114286;

        // when
        int result = new ClosestBST().closestValue(root, target);

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    void can_find_closet_node2() {
        // given
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        double target = 3.714286;

        // when
        int result = new ClosestBST().closestValue(root, target);

        // then
        assertThat(result).isEqualTo(4);
    }

    @Test
    void can_find_closet_node3() {
        // given
        TreeNode root = new TreeNode(4);
        double target = 3.114286;

        // when
        int result = new ClosestBST().closestValue(root, target);

        // then
        assertThat(result).isEqualTo(4);
    }

    @Test
    void can_find_closet_node4() {
        // given
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        double target = 5.714286;

        // when
        int result = new ClosestBST().closestValue(root, target);

        // then
        assertThat(result).isEqualTo(2);
    }

}