package com.first.interview.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FindModeBST {
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;

        max = updateMap(root, map, max);

        Set<Integer> set = map.keySet();
        ArrayList<Integer> res = new ArrayList<>();

        for (Integer key : set) {
            if (map.get(key) == max) {
                res.add(key);
            }
        }

        int[] array = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            array[i] = res.get(i);
        }
        return array;
    }

    private int updateMap(TreeNode node, Map<Integer, Integer> map, int maxCount) {
        if (node == null) {
            return maxCount;
        }
        map.put(node.val, 1 + map.getOrDefault(node.val, 0));

        maxCount = Math.max(maxCount, map.get(node.val));

        maxCount = updateMap(node.left, map, maxCount);
        maxCount = updateMap(node.right, map, maxCount);

        return maxCount;
    }
}
