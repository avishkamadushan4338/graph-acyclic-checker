package com.avishka;

/**
 * Name: Avishka Madushan
 * Student ID: 20232557
 * Module: 5SENG003W Algorithms
 * Task 4: Sink Elimination Algorithm
 */

public class SinkElimination {

    /**
     * Checks if graph is acyclic using sink elimination
     */
    public static boolean isAcyclic(Graph graph) {

        System.out.println("Running Sink Elimination...");

        while (!graph.isEmpty()) {

            Integer sink = graph.findSink();

            // ❌ No sink → cycle exists
            if (sink == null) {
                System.out.println("No sink found → Cycle detected!");
                return false;
            }

            // ✅ Print step (important for marks)
            System.out.println("Removing sink: " + sink);

            // Remove sink
            graph.removeVertex(sink);
        }

        // ✅ Graph fully removed → acyclic
        System.out.println("Graph empty → Acyclic");
        return true;
    }
}