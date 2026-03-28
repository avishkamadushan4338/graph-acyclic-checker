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

    // ✅ Read file and convert to Graph
    public static Graph parseFile(String filePath) {

        Graph graph = new Graph();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line;

            while ((line = reader.readLine()) != null) {

                // Remove spaces
                line = line.trim();

                // Skip empty lines
                if (line.isEmpty()) continue;

                // Split numbers (handles spaces/tabs)
                String[] parts = line.split("\\s+");

                // Validate format
                if (parts.length != 2) {
                    System.out.println("Invalid line: " + line);
                    continue;
                }

                try {
                    int from = Integer.parseInt(parts[0]);
                    int to = Integer.parseInt(parts[1]);

                    graph.addEdge(from, to);

                } catch (NumberFormatException e) {
                    System.out.println("Invalid number in line: " + line);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + filePath);
        }

        return graph;
    }
}