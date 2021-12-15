package com.first.interview.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        list = build(root, list);

        return list;
    }

    private List<Integer> build(TreeNode node, List<Integer> list) {
        if (node == null) {
            return Collections.emptyList();
        }
        if (node.left != null) {
            build(node.left, list);
        }

        list.add(node.val);

        if (node.right != null) {
            build(node.right, list);
        }
        return list;
    }
}
