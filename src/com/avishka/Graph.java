package com.avishka;

// IIT Student ID: 20232557 | UOW Student ID: w2153540
// Name: Avishka Madushan

import java.util.*;

/**
 * Directed graph represented using adjacency lists.
 * Maintains both outgoing and incoming edge maps for efficient
 * sink detection (O(V)) and vertex removal (O(degree(v))).
 */
public class Graph {

    private final Map<Integer, Set<Integer>> outEdges;
    private final Map<Integer, Set<Integer>> inEdges;
    private final Set<Integer> vertices;

    public Graph() {
        outEdges = new HashMap<>();
        inEdges  = new HashMap<>();
        vertices = new HashSet<>();
    }

    /** Deep-copy constructor – used by the algorithm so the original is preserved. */
    public Graph(Graph other) {
        vertices = new HashSet<>(other.vertices);
        outEdges = new HashMap<>();
        inEdges  = new HashMap<>();
        for (int v : other.outEdges.keySet()) {
            outEdges.put(v, new HashSet<>(other.outEdges.get(v)));
        }
        for (int v : other.inEdges.keySet()) {
            inEdges.put(v, new HashSet<>(other.inEdges.get(v)));
        }
    }

    public void addVertex(int v) {
        if (vertices.add(v)) {
            outEdges.put(v, new HashSet<>());
            inEdges.put(v, new HashSet<>());
        }
    }

    public void addEdge(int from, int to) {
        addVertex(from);
        addVertex(to);
        outEdges.get(from).add(to);
        inEdges.get(to).add(from);
    }

    public boolean isEmpty() {
        return vertices.isEmpty();
    }

    /**
     * Returns any sink vertex (no outgoing edges), or null if none exists.
     * O(V) worst case.
     */
    public Integer findSink() {
        for (int v : vertices) {
            if (outEdges.get(v).isEmpty()) {
                return v;
            }
        }
        return null;
    }

    /**
     * Removes vertex v and all edges incident to it.
     * O(degree(v)) due to the reverse-edge map.
     */
    public void removeVertex(int v) {
        for (int to : outEdges.get(v)) {
            inEdges.get(to).remove(v);
        }
        for (int from : inEdges.get(v)) {
            outEdges.get(from).remove(v);
        }
        outEdges.remove(v);
        inEdges.remove(v);
        vertices.remove(v);
    }

    public Set<Integer> getVertices() {
        return Collections.unmodifiableSet(vertices);
    }

    public Set<Integer> getOutNeighbors(int v) {
        return Collections.unmodifiableSet(outEdges.getOrDefault(v, Collections.emptySet()));
    }
}
