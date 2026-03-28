package com.avishka;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        System.out.println("Graph Acyclic Checker Running...");

        File folder = new File("benchmarks/acyclic");

        File[] files = folder.listFiles();

        if (files == null) {
            System.out.println("Folder not found!");
            return;
        }

        for (File file : files) {
            System.out.println("\nReading: " + file.getName());

            Graph graph = GraphParser.parseFile(file.getPath());

            graph.printGraph();
        }
    }
}