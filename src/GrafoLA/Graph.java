package GrafoLA;

import java.util.LinkedList;

public class Graph<E> {

    private class Edge<T> {
        protected Vertex refDestination;
        protected int weight;

        public Edge(Vertex refDestination) {
            this(refDestination, -1);
        }

        public Edge(Vertex refDestination, int weight) {
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
    private class Vertex {
        protected E data;
        protected LinkedList<Edge<E>> adjacencyList;
    }

    protected LinkedList<Vertex> listVertices;

    public Graph() {
        listVertices = new LinkedList<Vertex>();
    }
}
