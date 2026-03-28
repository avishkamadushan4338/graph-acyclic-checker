package com.avishka;

import java.util.*;

/**
 * Name: Avishka Madushan
 * Student ID: 20232557/w2153540
 * Module: 5SENG003W Algorithms
 * Task 2: Graph Data Structure
 */

public class Graph {

    private Map<Integer, List<Integer>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    // ✅ Add vertex
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

    // ✅ Get neighbors
    public List<Integer> getNeighbors(int node) {
        return adjList.getOrDefault(node, new ArrayList<>());
    }

    // ✅ Find sink (node with NO outgoing edges)
    public Integer findSink() {
        for (Integer node : adjList.keySet()) {
            if (adjList.get(node).isEmpty()) {
                return node;
            }
        }
        return null;
    }

    // ✅ Remove vertex + incoming edges
    public void removeVertex(int vertex) {
        adjList.remove(vertex);

        for (List<Integer> neighbors : adjList.values()) {
            neighbors.remove(Integer.valueOf(vertex));
        }
    }

    // ✅ Check if graph empty
    public boolean isEmpty() {
        return adjList.isEmpty();
    }

    // ✅ Clone graph (important for algorithm)
    public Graph cloneGraph() {
        Graph copy = new Graph();

        for (Integer node : adjList.keySet()) {
            copy.adjList.put(node, new ArrayList<>(adjList.get(node)));
        }

        return copy;
    }

    // ✅ Number of vertices
    public int size() {
        return adjList.size();
    }

    // ✅ Debug print (small graphs only)
    public void printGraph() {
        for (Integer node : adjList.keySet()) {
            System.out.println(node + " -> " + adjList.get(node));
        }
    }

    // ✅ Summary print (for large graphs)
    public void printSummary() {
        System.out.println("Graph loaded with " + adjList.size() + " vertices.");
    }
}