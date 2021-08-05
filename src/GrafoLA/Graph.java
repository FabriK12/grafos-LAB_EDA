package GrafoLA;

import lineal.ListLinked;

import java.util.Iterator;
import java.util.PriorityQueue;


public class Graph<E> {

    private static class Edge<T> {
        protected Vertex<T> refDestination;
        protected int weight;
        protected int estado; //0: Sin explorar, 1: Explorado, 2: Retorno

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

    private static class Vertex<T> implements Comparable{
        protected T data;
        protected ListLinked<Edge<T>> adjacencyList;
        protected boolean isVisited;
        protected int distance;

        public Vertex(T data) {
            this.data = data;
            adjacencyList = new ListLinked<Edge<T>>();
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

        @Override
        public int compareTo(Object obj) {
            if (obj instanceof Vertex<?>) {
                Vertex<T> e = (Vertex<T>) obj;
                return Integer.compare(e.distance, ((Vertex) obj).distance);
            }
            return 0;
        }
    }

    protected ListLinked<Vertex<E>> listVertices;

    public Graph() {
        listVertices = new ListLinked<Vertex<E>>();
    }

    public void insertVertex(E data) {
        Vertex<E> v = new Vertex<E>(data);
        if (this.listVertices.search(v) != null) {
            System.out.println("Vertice ya ingresado anteriormente...");
            return;
        }
        this.listVertices.insertFirst(v);
    }

    public void insertEdge(E vertexOrigin, E vertexDest) {
        Vertex<E> refOrigin = this.listVertices.search(new Vertex<E>(vertexOrigin));
        Vertex<E> refDest = this.listVertices.search(new Vertex<E>(vertexDest));

        if (refOrigin == null || refDest == null) {
            System.out.println("No se encuentran los vertices...");
        } else {
            if (refOrigin.adjacencyList.search(new Edge<E>(refDest)) == null) {
                refOrigin.adjacencyList.insertFirst(new Edge<E>(refDest));
                refDest.adjacencyList.insertFirst(new Edge<E>(refOrigin));
            } else {
                System.out.println("Arista insertada con anterioridad...");
            }
        }

    }

    private void initLabels() {
        Iterator<Vertex<E>> itr = this.listVertices.iterator();
        while (itr.hasNext()) {
            Vertex<E> aux = itr.next();
            aux.isVisited = false;
            Iterator<Edge<E>> itr2 = aux.adjacencyList.iterator();
            while (itr2.hasNext()) {
                Edge<E> aux2 = itr2.next();
                aux2.estado = 0;
            }
        }
    }

    private void initDijkstra() {
        Iterator<Vertex<E>> itr = this.listVertices.iterator();
        while (itr.hasNext()) {
            Vertex<E> aux = itr.next();
            aux.isVisited = false;
            aux.distance = (int) Double.POSITIVE_INFINITY;
        }
    }

    public void Dijkstra(E data) {
        Vertex<E> v = this.listVertices.search(new Vertex<E>(data));
        if (v == null) {
            System.out.println("No existe el vertice...");
            return;
        }
        this.initLabels();
        this.initDijkstra();
//        Dijkstra(v);
    }

    private void Dijkstra(Vertex<E> s) {
        PriorityQueue<Vertex<E>> queue = new PriorityQueue<>();
        s.distance = 0;
        s.isVisited = true;
        queue.add(s);
        while (!queue.isEmpty()) {
            Vertex<E> vertex = queue.poll();

        }
    }

    public void test() {
        PriorityQueue<Vertex<Character>> queue = new PriorityQueue<>();
        Vertex<Character> a = new Vertex<>('C');
        Vertex<Character> b = new Vertex<>('A');
        a.distance = 1;
        b.distance = 5;
        queue.add(b);
        queue.add(a);
        System.out.println(queue);
    }

    public void DFS(E data) {//DEFINIR EL RECORRIDO EN CIERTO NODO
        Vertex<E> v = this.listVertices.search(new Vertex<E>(data));
        if (v == null) {
            System.out.println("No existe el vertice...");
            return;
        }
        this.initLabels();
        DFS(v);
    }

    private void DFS(Vertex<E> v) {
        v.isVisited = true;
        System.out.print(v.data + ", ");
        //RECORRER LA LISTA
        Iterator<Edge<E>> itr = v.adjacencyList.iterator();
        while (itr.hasNext()) {
            Edge<E> e = itr.next();
            if (e.estado == 0) {
                Vertex<E> neighbor = e.refDestination;
                if (!neighbor.isVisited) {
                    e.estado = 1;
                    DFS(neighbor);
                } else {
                    e.estado = 2;
                }
            }
        }
    }

    public void BFS(E data) {
        Vertex<E> v = this.listVertices.search(new Vertex<E>(data));
        if (v == null) {
            System.out.println("No existe el vertice...");
            return;
        }
        this.initLabels();
        BFS(v);
    }

    private void BFS(Vertex<E> v) {
        ListLinked<Vertex<E>> fifo = new ListLinked<>();
        fifo.insertLast(v);
        v.isVisited = true;
        while (!fifo.isEmpty()) {
            Vertex<E> vertex = fifo.remove();
            System.out.print(vertex.data + ", ");
            Iterator<Edge<E>> itr = vertex.adjacencyList.iterator();
            while (itr.hasNext()) {
                Edge<E> e = itr.next();
                if (e.estado == 0) {
                    Vertex<E> neighbor = e.refDestination;
                    if (!neighbor.isVisited) {
                        e.estado = 1;
                        neighbor.isVisited = true;
                        fifo.insertLast(neighbor);
                    } else {
                        e.estado = 2;
                    }
                }
            }
        }
        /*
        v.isVisited = true;
        System.out.print(v.data + ", ");
        //RECORRER LA LISTA
        Iterator<Edge<E>> itr = v.adjacencyList.iterator();
        while(itr.hasNext()){
            Edge<E> e = itr.next();
            if(e.estado == 0){
                Vertex<E> neighbor = e.refDestination;
                if(!neighbor.isVisited){
                    e.estado = 1;
                    BFS(neighbor);
                }else {
                    e.estado = 2;
                }
            }
        }
         */
    }

    @Override
    public String toString() {
        return "listVertices = {\n" + listVertices + "\n}";
    }
}
