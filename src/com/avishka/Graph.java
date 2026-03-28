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

    // ✅ Add a vertex (important for nodes with no edges)
    public void addVertex(int v) {
        adjList.putIfAbsent(v, new ArrayList<>());
    }

    // ✅ Add directed edge
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

    // ✅ Get neighbors of a node
    public List<Integer> getNeighbors(int node) {
        return adjList.getOrDefault(node, new ArrayList<>());
    }

    // ✅ Find a sink (node with NO outgoing edges)
    public Integer findSink() {
        for (Integer node : adjList.keySet()) {
            if (adjList.get(node).isEmpty()) {
                return node;
            }
        }
        return null; // No sink found
    }

    // ✅ Remove a vertex and all related edges
    public void removeVertex(int vertex) {

        // Remove the vertex itself
        adjList.remove(vertex);

        // Remove all incoming edges
        for (List<Integer> neighbors : adjList.values()) {
            neighbors.remove(Integer.valueOf(vertex));
        }
    }

    // ✅ Check if graph is empty
    public boolean isEmpty() {
        return adjList.isEmpty();
    }

    // ✅ Clone graph (VERY IMPORTANT for algorithm)
    public Graph cloneGraph() {
        Graph copy = new Graph();

        for (Integer node : adjList.keySet()) {
            copy.adjList.put(node, new ArrayList<>(adjList.get(node)));
        }

        return copy;
    }

    // ✅ Get number of vertices
    public int size() {
        return adjList.size();
    }

    // ✅ Print graph (only for small graphs)
    public void printGraph() {
        for (Integer node : adjList.keySet()) {
            System.out.println(node + " -> " + adjList.get(node));
        }
    }

    // ✅ Print summary (for large benchmark graphs)
    public void printSummary() {
        System.out.println("Graph loaded with " + adjList.size() + " vertices.");
    }
}