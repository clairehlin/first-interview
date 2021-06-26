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
        List<String> result = new BinaryTreePaths().apply(root);

        // then
        List<String> expected = new ArrayList<>();
        expected.add("1->2->5");
        expected.add("1->3");
        assertThat(result).isEqualTo(expected);
    }

}