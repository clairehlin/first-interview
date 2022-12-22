package com.first.interview.graph;

import java.util.*;

public class MyGraph {
    private final Map<Integer, Set<Integer>> nodesLookup = new HashMap<>();

    public void addEdge(int src, int dst) {
        if (!nodesLookup.containsKey(src)) {
            nodesLookup.put(src, new HashSet<>());
        }

        if (nodesLookup.get(src).contains(dst)) {
            throw new IllegalArgumentException("node " + dst + " already exists in the graph.");
        } else {
            nodesLookup.get(src).add(dst);
        }
    }

    public boolean hasBFSPath(int src, int dst) {
        Queue<Integer> nextToVisit = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();

        nextToVisit.add(src);
//        seen.add(src);

        while (!nextToVisit.isEmpty()) {
            int fromQ = nextToVisit.poll();
            Set<Integer> connectedNodes = nodesLookup.get(fromQ);

            if (connectedNodes != null) {
                for (Integer node : connectedNodes) {
                    if (node == dst) {
                        return true;
                    } else {
                        if (!seen.contains(node)) {
                            nextToVisit.add(node);
                            seen.add(node);
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean hasDFSPath(int src, int dst) {
        Stack<Integer> nextToVisit = new Stack<>();
        Set<Integer> seen = new HashSet<>();

        nextToVisit.add(src);
//        seen.add(src);

        while (!nextToVisit.isEmpty()) {
            Integer fromStack = nextToVisit.pop();
            Set<Integer> connectedNodes = nodesLookup.get(fromStack);

            if (connectedNodes != null) {
                for (int node : connectedNodes) {
                    if (node == dst) {
                        return true;
                    } else {
                        if (!seen.contains(node)) {
                            nextToVisit.push(node);
                            seen.add(node);
                        }
                    }
                }
            }


        }
        return false;
    }
}
