package GrafoLA;

import java.util.LinkedList;

public class Graph<E> {

    private class Edge {
        protected Vertex refDestination;
        protected int weight;

    }
    private class Vertex {
        protected E data;
        protected LinkedList<Edge> adjacencyList;
    }

    protected LinkedList<Vertex> listVertices;

    public Graph() {
        listVertices = new LinkedList<Vertex>();
    }
}
