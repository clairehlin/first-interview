package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FindModeBSTTest {

    @Test
    void can_find_mode() {
        // given
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);

        // when
        int[] result = new FindModeBST().findMode(root);

        // then
        assertThat(result).isEqualTo(new int[]{2});
    }
}