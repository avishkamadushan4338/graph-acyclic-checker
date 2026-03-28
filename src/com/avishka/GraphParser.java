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

    public static Graph parseFile(String filePath) {

        Graph graph = new Graph();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {

                line = line.trim();

                if (line.isEmpty()) continue;

                // 🔹 Skip first line (vertex count)
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                // 🔹 Only process lines with "->"
                if (!line.contains("->")) continue;

                String[] parts = line.split("->");

                if (parts.length != 2) continue;

                int from = Integer.parseInt(parts[0].trim());

                // Clean right side
                String right = parts[1].trim();
                right = right.replace("[", "").replace("]", "");

                // Ensure vertex exists
                graph.addVertex(from);

                // If no outgoing edges
                if (right.isEmpty()) continue;

                String[] neighbors = right.split(",");

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