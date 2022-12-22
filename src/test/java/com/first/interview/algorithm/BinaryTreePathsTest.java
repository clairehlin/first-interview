package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BinaryTreePathsTest {

    @Test
    void can_get_all_tree_paths() {
        // given
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        // when
        // then
        assertThat(new BinaryTreePaths().apply2(root)).containsExactlyInAnyOrder("1->2->5", "1->3");
        assertThat(new BinaryTreePaths().apply(root)).containsExactlyInAnyOrder("1->2->5", "1->3");
    }

}