package com.avishka;

/**
 * Name: Avishka Madushan
 * Student ID: 20232557
 * Module: 5SENG003W Algorithms
 * Task 4: Sink Elimination Algorithm
 */

public class SinkElimination {

    public static boolean isAcyclic(Graph graph) {

        System.out.println("Running Sink Elimination...");

        int step = 1;

        while (!graph.isEmpty()) {

            Integer sink = graph.findSink();

            if (sink == null) {
                System.out.println("Step " + step + ": No sink found - Cycle detected!");
                return false;
            }

            // ✅ FIXED FORMAT
            System.out.println("Step " + step + ": Removing sink: " + sink);

            graph.removeVertex(sink);
            step++;
        }

        System.out.println("Graph empty - Acyclic");
        return true;
    }
}