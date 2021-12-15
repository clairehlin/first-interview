package com.first.interview.algorithm;

import java.util.*;
import java.util.stream.Collectors;

public class FindModeBST2 {
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;

        max = buildMap(map, root, max);
        int globalMax = max;

        List<Integer> res = map.entrySet().stream()
                .filter(entrySet -> entrySet.getValue() == globalMax)
                .map(entrySet -> entrySet.getKey())
                .collect(Collectors.toList());

        /*
        Set<Integer> keySet = map.keySet();

        for (Integer key : keySet) {
            if (map.get(key) == max) {
                res.add(key);
            }
        }
         */

        int[] result = new int[res.size()];
        int start = 0;
        for (int element : res) {
            result[start++] = element;
        }
        return result;
    }

    public List<Integer> find(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int max = 0;

        max = buildMap(map, root, max);
        int globalMax = max;

        return map.entrySet().stream()
                .filter(entry -> entry.getValue() == globalMax)
//                .map(entry -> entry.getKey())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private int buildMap(Map<Integer, Integer> map, TreeNode node, int max) {
        if (node == null) {
            return max;
        }

        map.put(node.val, map.getOrDefault(node.val, 0) + 1);

        if (map.get(node.val) > max) {
            max = map.get(node.val);
        }

        if (node.left != null) {
            max = buildMap(map, node.left, max);
        }

        if (node.right != null) {
            max = buildMap(map, node.right, max);
        }
        return max;
    }
}
