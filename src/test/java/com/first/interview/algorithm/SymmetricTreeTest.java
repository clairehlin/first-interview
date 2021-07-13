package com.first.interview.algorithm;

import com.sun.source.tree.Tree;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SymmetricTreeTest {

    @Test
    void can_identify_symmetric_tree_with_root_only() {
        // given
        TreeNode root = new TreeNode(1);

        // when
        SymmetricTree symmetricTree = new SymmetricTree();
        boolean result = symmetricTree.isSymmetric(root);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void can_identify_symmetric_tree() {
        // given
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);


        // when
        SymmetricTree symmetricTree = new SymmetricTree();
        boolean result = symmetricTree.isSymmetric(root);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void can_identify_symmetric_tree2() {
        // given
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);


        // when
        SymmetricTree symmetricTree = new SymmetricTree();
        boolean result = symmetricTree.isSymmetric(root);

        // then
        assertThat(result).isFalse();
    }
}