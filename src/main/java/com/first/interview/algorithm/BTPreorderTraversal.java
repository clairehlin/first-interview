package com.first.interview.algorithm;

import java.util.ArrayList;
import java.util.List;

public class BTPreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        } else {
            preorderChild(root, list);
        }
        return list;
    }

    private List<Integer> preorderChild(TreeNode node, List<Integer> list) {
        list.add(node.val);

        if (node.left != null) {
            list = preorderChild(node.left, list);
        }

        if (node.right != null) {
            list = preorderChild(node.right, list);
        }
        return list;
    }

}
