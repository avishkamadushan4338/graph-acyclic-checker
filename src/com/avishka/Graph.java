package com.avishka;

import java.util.*;

/**
 * Name: Avishka Madushan
 * Student ID: 20232557
 * Module: 5SENG003W Algorithms
 * Task 2: Graph Data Structure
 */

public class Graph {

    private Map<Integer, List<Integer>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    public void addVertex(int v) {
        adjList.putIfAbsent(v, new ArrayList<>());
    }

    public void addEdge(int from, int to) {
        adjList.putIfAbsent(from, new ArrayList<>());
        adjList.get(from).add(to);
        adjList.putIfAbsent(to, new ArrayList<>());
    }

    public Set<Integer> getVertices() {
        return adjList.keySet();
    }

    public List<Integer> getNeighbors(int node) {
        return adjList.getOrDefault(node, new ArrayList<>());
    }

    public Integer findSink() {
        for (Integer node : adjList.keySet()) {
            if (adjList.get(node).isEmpty()) {
                return node;
            }
        }
        return null;
    }

    public void removeVertex(int vertex) {
        adjList.remove(vertex);
        for (List<Integer> neighbors : adjList.values()) {
            neighbors.remove(Integer.valueOf(vertex));
        }
    }

    public boolean isEmpty() {
        return adjList.isEmpty();
    }

    public Graph cloneGraph() {
        Graph copy = new Graph();
        for (Integer node : adjList.keySet()) {
            copy.adjList.put(node, new ArrayList<>(adjList.get(node)));
        }
        return copy;
    }

    public int size() {
        return adjList.size();
    }

    public void printSummary() {
        System.out.println("Graph loaded with " + adjList.size() + " vertices.");
    }
}