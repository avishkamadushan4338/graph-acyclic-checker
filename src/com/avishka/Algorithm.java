package com.avishka;

// IIT Student ID: 20232557 | UOW Student ID: w2153540
// Name: Avishka Madushan

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implements the sink elimination algorithm to check acyclicity,
 * and a DFS-based cycle finder for Task 5.
 */
public class Algorithm {

    /**
     * Runs the sink elimination algorithm on a copy of the graph.
     * Prints each sink removed. Returns true if the graph is acyclic.
     */
    public static boolean isAcyclic(Graph original) {
        Graph graph = new Graph(original);

        System.out.println("--- Sink Elimination ---");
        while (!graph.isEmpty()) {
            Integer sink = graph.findSink();
            if (sink == null) {
                System.out.println("No sink found in remaining graph. A cycle exists.");
                return false;
            }
            System.out.println("Removed sink: " + sink
                    + "  (remaining vertices: " + (graph.getVertices().size() - 1) + ")");
            graph.removeVertex(sink);
        }
        System.out.println("Graph fully eliminated — no cycle.");
        return true;
    }

    /**
     * Finds and returns a cycle in the graph using DFS colouring.
     * Returns null if the graph is acyclic.
     */
    public static List<Integer> findCycle(Graph graph) {
        Map<Integer, Integer> colour = new HashMap<>(); // 0=unvisited 1=in-stack 2=done
        Map<Integer, Integer> parent = new HashMap<>();

        for (int v : graph.getVertices()) {
            colour.put(v, 0);
            parent.put(v, -1);
        }

        for (int v : graph.getVertices()) {
            if (colour.get(v) == 0) {
                List<Integer> cycle = dfs(v, graph, colour, parent);
                if (cycle != null) {
                    return cycle;
                }
            }
        }
        return null;
    }

    private static List<Integer> dfs(int v, Graph graph,
            Map<Integer, Integer> colour, Map<Integer, Integer> parent) {
        colour.put(v, 1);

        for (int neighbour : graph.getOutNeighbors(v)) {
            if (colour.get(neighbour) == 1) {
                // Back edge found — trace cycle
                List<Integer> cycle = new ArrayList<>();
                cycle.add(neighbour);
                int cur = v;
                while (cur != neighbour) {
                    cycle.add(cur);
                    cur = parent.get(cur);
                }
                cycle.add(neighbour);
                Collections.reverse(cycle);
                return cycle;
            }
            if (colour.get(neighbour) == 0) {
                parent.put(neighbour, v);
                List<Integer> cycle = dfs(neighbour, graph, colour, parent);
                if (cycle != null) {
                    return cycle;
                }
            }
        }

        colour.put(v, 2);
        return null;
    }
}
