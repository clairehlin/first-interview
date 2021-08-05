package com.first.interview.algorithm;

import java.util.ArrayList;
import java.util.List;

public class BTPreorderTraversal2 {
    List<Integer> list = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        } else {
            list.add(root.val);
        }

        if (root.left != null) {
            list = preorderTraversal(root.left);
        }

        if (root.right != null) {
            list = preorderTraversal(root.right);
        }

        return list;
    }
}
