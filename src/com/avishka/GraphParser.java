package com.avishka;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Name: Avishka Madushan
 * Student ID: 20232557
 * Module: 5SENG003W Algorithms
 * Task 3: Graph Parser (FINAL FIXED VERSION)
 */

public class GraphParser {

    public static Graph parseFile(String filePath) {

        Graph graph = new Graph();

        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(filePath), "UTF-8")
            );

            String line;
            boolean firstLine = true;

            // Regex to extract numbers
            Pattern pattern = Pattern.compile("\\d+");

            while ((line = reader.readLine()) != null) {

                line = line.trim();

                if (line.isEmpty()) continue;

                // 🔹 Skip first line (vertex count)
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                // 🔹 Extract numbers from line
                Matcher matcher = pattern.matcher(line);

                // If no numbers → skip
                if (!matcher.find()) continue;

                // First number = source node
                int from = Integer.parseInt(matcher.group());
                graph.addVertex(from);

                // Remaining numbers = neighbors
                while (matcher.find()) {
                    int to = Integer.parseInt(matcher.group());
                    graph.addEdge(from, to);
                }
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("❌ Error reading file: " + filePath);
            e.printStackTrace(); // helps debug if something still wrong
        }

        return graph;
    }
}