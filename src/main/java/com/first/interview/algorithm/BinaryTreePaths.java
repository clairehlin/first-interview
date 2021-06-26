package com.first.interview.algorithm;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> apply(TreeNode root) {
        List<String> result = new ArrayList<>();
        String s = "";
        depthSearch(s, root, result);
        return result;
    }

    private void depthSearch(String input, TreeNode node, List<String> list) {
        if (node != null) {
            input += Integer.toString(node.val);

            if (node.left == null && node.right == null) {
                list.add(input);
            } else {
                input += "->";
                depthSearch(input, node.left, list);
                depthSearch(input, node.right, list);
            }
        }
    }
}

