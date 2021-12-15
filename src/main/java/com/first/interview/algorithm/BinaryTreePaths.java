package com.first.interview.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreePaths {
    public List<String> apply(TreeNode root) {
        List<String> result = new ArrayList<>();
        depthSearch("", root, result);
        return result;
    }

    private void depthSearch(String basePath, TreeNode node, List<String> paths) {
        if (node != null) {
            basePath += node.val;

            if (node.left == null && node.right == null) {
                paths.add(basePath);
            } else {
                basePath += "->";
                depthSearch(basePath, node.left, paths);
                depthSearch(basePath, node.right, paths);
            }
        }
    }

    public List<String> apply2(TreeNode root) {
        return depthSearch(root);
    }

    private List<String> depthSearch(TreeNode node) {
        if (node == null) { // null, no paths to return
            return Collections.emptyList();
        } else if (isLeaf(node)) { // leaf, start a new path
            return List.of(String.valueOf(node.val));
        } else { // non-leaf, add this node to all paths coming from children, join all in one list of paths, and return all.
            List<String> listOfPathsFromRight = depthSearch(node.right);
            List<String> listOfPathsFromLeft = depthSearch(node.left);

            List<String> listOfPaths = new ArrayList<>();

            for (String path : listOfPathsFromRight) {
                listOfPaths.add(node.val + "->" + path);
            }

            for (String path : listOfPathsFromLeft) {
                listOfPaths.add(node.val + "->" + path);
            }

            return listOfPaths;
        }
    }

    private boolean isLeaf(TreeNode node) {
        return node.right == null && node.left == null;
    }
}

