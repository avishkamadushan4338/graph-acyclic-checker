package com.avishka;

public class Main {
    public static void main(String[] args) {

        System.out.println("Graph Acyclic Checker Running...");

        // 🔹 Read graph from file
        String filePath = "benchmark/acyclic/file1.txt"; // change file name

        Graph graph = GraphParser.parseFile(filePath);

        // 🔹 Print graph
        graph.printGraph();
    }
}