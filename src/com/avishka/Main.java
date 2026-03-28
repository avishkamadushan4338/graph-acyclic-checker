package com.avishka;

import java.io.File;

/**
 * Name: Avishka Madushan
 * Student ID: 20232557
 * Module: 5SENG003W Algorithms
 */

public class Main {

    public static void main(String[] args) {

        System.out.println("===== Graph Acyclic Checker =====");

        // 🔹 Run tests on both folders
        runFolder("benchmarks/acyclic", true);
        runFolder("benchmarks/cyclic", false);
    }

    /**
     * Runs all files inside a folder
     */
    public static void runFolder(String folderPath, boolean expectedAcyclic) {

        File folder = new File(folderPath);

        if (!folder.exists()) {
            System.out.println("Folder not found: " + folderPath);
            return;
        }

        File[] files = folder.listFiles();

        if (files == null) {
            System.out.println("No files found in: " + folderPath);
            return;
        }

        System.out.println("\n===== Testing: " + folderPath + " =====");

        for (File file : files) {

            System.out.println("\nFile: " + file.getName());

            // 🔹 Parse graph
            Graph graph = GraphParser.parseFile(file.getPath());

            // 🔹 Print summary (not full graph)
            graph.printSummary();

            // 🔹 Clone graph for safe processing
            Graph workingGraph = graph.cloneGraph();

            // 🔹 Run algorithm
            long start = System.nanoTime();

            boolean isAcyclic = SinkElimination.isAcyclic(workingGraph);

            long end = System.nanoTime();

            // 🔹 Output result
            System.out.println("Result: " + (isAcyclic ? "ACYCLIC (YES)" : "CYCLIC (NO)"));
            System.out.println("Expected: " + (expectedAcyclic ? "ACYCLIC" : "CYCLIC"));
            System.out.println("Time: " + (end - start) + " ns");

            // 🔹 Validate correctness
            if (isAcyclic != expectedAcyclic) {
                System.out.println("❌ ERROR: Incorrect result!");
            } else {
                System.out.println("✅ Correct");
            }
        }
    }
}