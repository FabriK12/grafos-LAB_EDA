import GrafoLA.Graph;

import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        Graph<Character> graph = new Graph<Character>();
        graph.insertVertex('A');
        graph.insertVertex('B');
        graph.insertVertex('C');
        graph.insertVertex('D');
        graph.insertVertex('E');
        graph.insertVertex('F');
        graph.insertVertex('G');
        graph.insertVertex('H');

        graph.insertEdge('A', 'B', 3);
        graph.insertEdge('B', 'G', 6);
        graph.insertEdge('B', 'D', 8);
        graph.insertEdge('H', 'A', 10);
        graph.insertEdge('H', 'F', 5);
        graph.insertEdge('A', 'D', 2);
        graph.insertEdge('H', 'D', 14);
        graph.insertEdge('H', 'B', 6);
        graph.insertEdge('E', 'G', 15);
        graph.insertEdge('D', 'E', 12);
        graph.insertEdge('B', 'E', 4);
        graph.insertEdge('B', 'C', 5);
        graph.insertEdge('A', 'C', 5);
        graph.insertEdge('H', 'G', 3);
        graph.insertEdge('C', 'G', 9);
        graph.insertEdge('C', 'F', 7);


        System.out.println("Rpresentacion en lista enlazada: ");
        System.out.println(graph);
        System.out.println("RECORRIDO DFS: ");
        graph.DFS('D');
        System.out.println("\nRECORRIDO BFS: ");
        graph.BFS('D');
        System.out.println("\nCAMINO MINIMO DESDE VERTICE 'D'");
        graph.Dijkstra('D');
        System.out.println(graph);

    }
}
