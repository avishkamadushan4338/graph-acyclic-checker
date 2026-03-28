package com.avishka;

import java.util.*;

/**
 * Name: Avishka Madushan
 * Student ID: 20232557
 * Module: 5SENG003W Algorithms
 * Task 5: Cycle Detection
 */

public class CycleDetector {

    public static List<Integer> findCycle(Graph graph) {

        Set<Integer> visited = new HashSet<>();
        Set<Integer> stack = new HashSet<>();
        Map<Integer, Integer> parent = new HashMap<>();

        for (Integer node : graph.getVertices()) {
            if (!visited.contains(node)) {
                List<Integer> cycle = dfs(node, graph, visited, stack, parent);
                if (cycle != null) return cycle;
            }
        }

        return null;
    }

    private static List<Integer> dfs(Integer current,
                                    Graph graph,
                                    Set<Integer> visited,
                                    Set<Integer> stack,
                                    Map<Integer, Integer> parent) {

        visited.add(current);
        stack.add(current);

        for (Integer neighbor : graph.getNeighbors(current)) {

            if (!visited.contains(neighbor)) {
                parent.put(neighbor, current);
                List<Integer> cycle = dfs(neighbor, graph, visited, stack, parent);
                if (cycle != null) return cycle;
            }

            else if (stack.contains(neighbor)) {
                return buildCycle(current, neighbor, parent);
            }
        }

        stack.remove(current);
        return null;
    }

    private static List<Integer> buildCycle(Integer current,
                                           Integer start,
                                           Map<Integer, Integer> parent) {

        List<Integer> cycle = new ArrayList<>();
        cycle.add(start);

        Integer node = current;

        while (!node.equals(start)) {
            cycle.add(node);
            node = parent.get(node);
        }

        cycle.add(start);
        Collections.reverse(cycle);

        return cycle;
    }
}