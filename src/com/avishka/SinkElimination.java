package com.avishka;

/**
 * Name: Avishka Madushan
 * Student ID: 20232557 / w2153540
 * Module: 5SENG003W Algorithms
 * Task 4: Sink Elimination Algorithm
 */

public class SinkElimination {

    public static boolean isAcyclic(Graph graph) {

        System.out.println("Running Sink Elimination...");

        int step = 1;

        while (!graph.isEmpty()) {

            Integer sink = graph.findSink();

            // ❌ No sink → cycle exists
            if (sink == null) {
                System.out.println("Step " + step + ": No sink found → Cycle detected!");
                return false;
            }

            // ✅ Print step (required by spec)
            System.out.println("Step " + step + ": Removing sink → " + sink);

            graph.removeVertex(sink);

            step++;
        }

        // ✅ All vertices removed → acyclic
        System.out.println("Graph empty → Acyclic");
        return true;
    }
}