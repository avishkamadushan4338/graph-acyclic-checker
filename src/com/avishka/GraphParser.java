package com.avishka;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Name: Avishka Madushan
 * Student ID: 20232557
 * Module: 5SENG003W Algorithms
 * Task 3: Graph Parser
 */

public class GraphParser {

    /**
     * Parses a graph file and returns a Graph object.
     * Supports adjacency list format:
     *
     * Example:
     * 80
     * 0 -> [33]
     * 1 -> [59, 62, 41]
     * ...
     */
    public static Graph parseFile(String filePath) {

        Graph graph = new Graph();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {

                line = line.trim();

                // Skip empty lines
                if (line.isEmpty()) continue;

                // 🔹 First line = number of vertices (ignore it)
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                // 🔹 Split "node -> [neighbors]"
                String[] parts = line.split("->");

                if (parts.length != 2) continue;

                // Left side (node)
                int from = Integer.parseInt(parts[0].trim());

                // Right side (neighbors list)
                String neighborsPart = parts[1]
                        .replace("[", "")
                        .replace("]", "")
                        .trim();

                // Ensure vertex exists
                graph.addVertex(from);

                // If no outgoing edges
                if (neighborsPart.isEmpty()) continue;

                // Split neighbors
                String[] neighbors = neighborsPart.split(",");

                for (String n : neighbors) {
                    int to = Integer.parseInt(n.trim());
                    graph.addEdge(from, to);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + filePath);
        }

        return graph;
    }
}