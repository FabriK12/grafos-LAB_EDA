package GrafoLA;

import java.util.LinkedList;

public class Graph<E> {

    private class Edge<T> {
        protected Vertex<T> refDestination;
        protected int weight;

        public Edge(Vertex<T> refDestination) {
            this(refDestination, -1);
        }

        public Edge(Vertex<T> refDestination, int weight) {
            this.refDestination = refDestination;
            this.weight = weight;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Edge<?>) {
                Edge<T> e = (Edge<T>) obj;
                return this.refDestination.equals(e.refDestination);
            }
            return false;
        }

        @Override
        public String toString() {
            if(this.weight > -1)
                return refDestination.data + " {" + this.weight + "}, ";
            else
                return refDestination.data + ", ";
        }
    }
    private class Vertex<T> {
        protected T data;
        protected LinkedList<Edge<T>> adjacencyList;

        public Vertex(T data) {
            this.data = data;
            adjacencyList = new LinkedList<Edge<T>>();
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Vertex<?>) {
                Vertex<T> e = (Vertex<T>) obj;
                return this.data.equals(e.data);
            }
            return false;
        }

        @Override
        public String toString() {
            return this.data + " -> " + this.adjacencyList.toString() + "\n";
        }
    }

    protected LinkedList<Vertex<E>> listVertices;

    public Graph() {
        listVertices = new LinkedList<Vertex<E>>();
    }
}
