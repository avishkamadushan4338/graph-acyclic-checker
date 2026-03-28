package com.avishka;

import java.io.File;
import java.util.List;

/**
 * Name: Avishka Madushan
 * Student ID: 20232557
 * Module: 5SENG003W Algorithms
 */

public class Main {

    public static void main(String[] args) {

        System.out.println("===== Graph Acyclic Checker =====");

        boolean allCorrect = true;

        allCorrect &= runFolder("benchmarks/acyclic", true);
        allCorrect &= runFolder("benchmarks/cyclic", false);

        // ✅ FINAL SUMMARY
        if (allCorrect) {
            System.out.println("\n🎉 All files processed correctly!");
        } else {
            System.out.println("\n⚠ Some files produced incorrect results.");
        }
    }

    public static boolean runFolder(String folderPath, boolean expectedAcyclic) {

        File folder = new File(folderPath);

        if (!folder.exists()) {
            System.out.println("Folder not found: " + folderPath);
            return false;
        }

        File[] files = folder.listFiles();

        if (files == null) {
            System.out.println("No files found in: " + folderPath);
            return false;
        }

        boolean allCorrect = true;

        System.out.println("\n===== Testing: " + folderPath + " =====");

        for (File file : files) {

            System.out.println("\nFile: " + file.getName());

            Graph graph = GraphParser.parseFile(file.getPath());
            graph.printSummary();

            Graph workingGraph = graph.cloneGraph();

            long start = System.nanoTime();
            boolean isAcyclic = SinkElimination.isAcyclic(workingGraph);
            long end = System.nanoTime();

            System.out.println("Result: " + (isAcyclic ? "ACYCLIC (YES)" : "CYCLIC (NO)"));
            System.out.println("Expected: " + (expectedAcyclic ? "ACYCLIC" : "CYCLIC"));
            System.out.println("Time: " + (end - start) + " ns");

            if (!isAcyclic) {
                List<Integer> cycle = CycleDetector.findCycle(graph);

                if (cycle != null) {
                    System.out.print("Cycle: ");
                    for (int i = 0; i < cycle.size(); i++) {
                        System.out.print(cycle.get(i));
                        if (i < cycle.size() - 1) System.out.print(" -> ");
                    }
                    System.out.println();
                }
            }

            if (isAcyclic != expectedAcyclic) {
                System.out.println("❌ ERROR: Incorrect result!");
                allCorrect = false;
            } else {
                System.out.println("✅ Correct");
            }
        }

        return allCorrect;
    }
}