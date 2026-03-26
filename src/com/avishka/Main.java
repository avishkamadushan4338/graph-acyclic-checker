package com.avishka;

// IIT Student ID: 20232557 | UOW Student ID: w2153540
// Name: Avishka Madushan

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String filePath = "input/graph.txt";
        if (args.length > 0) {
            filePath = args[0];
        }

        System.out.println("=== Graph Acyclic Checker ===");
        System.out.println("Reading graph from: " + filePath);

        Graph graph;
        try {
            graph = GraphParser.parse(filePath);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        System.out.println("Vertices: " + graph.getVertices());
        System.out.println();

        boolean acyclic = Algorithm.isAcyclic(graph);
        System.out.println();

        if (acyclic) {
            System.out.println("Result: YES — the graph is acyclic.");
        } else {
            System.out.println("Result: NO — the graph is not acyclic.");
            List<Integer> cycle = Algorithm.findCycle(graph);
            if (cycle != null) {
                StringBuilder sb = new StringBuilder("Cycle: ");
                for (int i = 0; i < cycle.size(); i++) {
                    if (i > 0) {
                        sb.append(" -> ");
                    }
                    sb.append(cycle.get(i));
                }
                System.out.println(sb.toString());
            }
        }
    }
}
