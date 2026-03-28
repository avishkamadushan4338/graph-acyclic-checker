package com.avishka;

import java.io.*;
import java.util.regex.*;

/**
 * Name: Avishka Madushan
 * Student ID: 20232557
 * Module: 5SENG003W Algorithms
 * Task 3: Graph Parser
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

            Pattern pattern = Pattern.compile("\\d+");

            while ((line = reader.readLine()) != null) {

                line = line.trim();

                if (line.isEmpty()) continue;

                // ✅ FIRST LINE = TOTAL VERTICES
                if (firstLine) {
                    int totalVertices = Integer.parseInt(line);

                    for (int i = 0; i < totalVertices; i++) {
                        graph.addVertex(i);
                    }

                    firstLine = false;
                    continue;
                }

                Matcher matcher = pattern.matcher(line);

                if (!matcher.find()) continue;

                int from = Integer.parseInt(matcher.group());

                while (matcher.find()) {
                    int to = Integer.parseInt(matcher.group());
                    graph.addEdge(from, to);
                }
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("Error reading file: " + filePath);
            e.printStackTrace();
        }

        return graph;
    }
}