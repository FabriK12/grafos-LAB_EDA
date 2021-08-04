package GrafoLA;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph<E> {

    private static class Edge<T> {
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
            if (obj instanceof Edge<?>) {
                Edge<T> obj1 = (Edge<T>) obj;
                return this.refDestination.equals(obj1.refDestination);
            }
            return false;
        }

        @Override
        public String toString() {
            if (this.weight > -1)
                return refDestination.data + " {" + this.weight + "}, ";
            else
                return refDestination.data + ", ";
        }
    }

    private static class Vertex<T> {
        protected T data;
        protected LinkedList<Edge<T>> adjacencyList;

        public Vertex(T data) {
            this.data = data;
            adjacencyList = new LinkedList<Edge<T>>();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Vertex<?>) {
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

    public void insertVertex(E data) {
        Vertex<E> v = new Vertex<E>(data);
        if (this.listVertices.isEmpty()) {
            this.listVertices.addFirst(v);
        } else if (this.listVertices.contains(v)) {
            System.out.println("El nodo ya se inserto...");
        } else {
            this.listVertices.addFirst(v);
        }
    }

    public void insertEdge(E vertexOrigin, E vertexDest) {
        Vertex<E> refOrigin = searchVertex(vertexOrigin);
        Vertex<E> refDest = searchVertex(vertexDest);
        if (refOrigin == null || refDest == null) {
            System.out.println("No se encuentran los vertices...");
            return;
        }
        if (refOrigin.adjacencyList.contains(new Edge<E>(refDest))) {
            System.out.println("Arista insertada con anterioridad...");
            return;
        }
        refOrigin.adjacencyList.addFirst(new Edge<E>(refDest));
        refDest.adjacencyList.addFirst(new Edge<E>(refOrigin));

    }

    public Vertex<E> searchVertex(E vertexSearch) {
        Iterator<Vertex<E>> itr = this.listVertices.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
        for (int i = 0; i < this.listVertices.size(); i++) {
            Vertex<E> v = this.listVertices.get(i);
            /*
            if (v.data.equals(vertexSearch)) {
                return v;
            } else {
                return null;
            }
             */
        }
        return null;
    }

    @Override
    public String toString() {
        return "listVertices=\n" + listVertices;
    }
}
