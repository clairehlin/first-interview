package com.first.interview.algorithm;

import java.util.ArrayList;
import java.util.List;

public class BTPreorderTraversal {
    public List<Integer> preorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        return preorderList(root, list);
    }

    private List<Integer> preorderList(TreeNode root, List<Integer> list) {
        if (root == null) {
            // do nothing
        } else {
            list.add(root.val);
            preorderList(root.left, list);
            preorderList(root.right, list);
        }
        return list;
    }
}
