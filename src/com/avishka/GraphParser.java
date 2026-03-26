package com.avishka;

// IIT Student ID: 20232557 | UOW Student ID: w2153540
// Name: Avishka Madushan

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Parses a directed graph from a plain-text file.
 * Each non-empty line must contain two integers separated by whitespace,
 * representing a directed edge from the first vertex to the second.
 */
public class GraphParser {

    public static Graph parse(String filePath) throws IOException {
        Graph graph = new Graph();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] parts = line.split("\\s+");
                int from = Integer.parseInt(parts[0]);
                int to   = Integer.parseInt(parts[1]);
                graph.addEdge(from, to);
            }
        }
        return graph;
    }
}
