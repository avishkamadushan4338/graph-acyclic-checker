package com.avishka;

import java.util.*;

/**
 * Name: Avishka Madushan
 * Student ID: 20232557
 * Module: 5SENG003W Algorithms
 * Task 2: Graph Data Structure
 */

public class Graph {

    // Adjacency list representation
    private Map<Integer, List<Integer>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    // ✅ Add edge (directed)
    public void addEdge(int from, int to) {
        adjList.putIfAbsent(from, new ArrayList<>());
        adjList.get(from).add(to);

        // Ensure destination node exists
        adjList.putIfAbsent(to, new ArrayList<>());
    }

    // ✅ Get all vertices
    public Set<Integer> getVertices() {
        return adjList.keySet();
    }

    // ✅ Find a sink (node with no outgoing edges)
    public Integer findSink() {
        for (Integer node : adjList.keySet()) {
            if (adjList.get(node).isEmpty()) {
                return node;
            }
        }
        return null; // No sink found
    }

    // ✅ Remove a vertex (IMPORTANT for algorithm)
    public void removeVertex(int vertex) {

        // Remove the vertex itself
        adjList.remove(vertex);

        // Remove all incoming edges to this vertex
        for (List<Integer> neighbors : adjList.values()) {
            neighbors.remove(Integer.valueOf(vertex));
        }
    }

    // ✅ Check if graph is empty
    public boolean isEmpty() {
        return adjList.isEmpty();
    }

    // ✅ Print graph (for debugging / output)
    public void printGraph() {
        System.out.println("Graph:");
        for (Integer node : adjList.keySet()) {
            System.out.println(node + " -> " + adjList.get(node));
        }
    }

    // ✅ Deep copy (VERY IMPORTANT for algorithm)
    public Graph cloneGraph() {
        Graph copy = new Graph();

        for (Integer node : adjList.keySet()) {
            copy.adjList.put(node, new ArrayList<>(adjList.get(node)));
        }

        return copy;
    }
}