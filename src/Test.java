import GrafoLA.Graph;

import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        Graph<Character> graph = new Graph<Character>();
        /*
        graph.insertVertex('C');
        graph.insertVertex('V');
        graph.insertVertex('A');
        graph.insertVertex('E');
        graph.insertVertex('B');

        graph.insertEdge('C', 'V');
        graph.insertEdge('C', 'A');
        graph.insertEdge('V', 'E');
        graph.insertEdge('E', 'B');
        graph.insertEdge('V', 'B');
        graph.insertEdge('V', 'A');

        System.out.println(graph);

        System.out.println("RECORRIDO DFS: ");
        graph.DFS('V');
        System.out.println("RECORRIDO BFS: ");
        graph.BFS('V');
         */

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(3);
        queue.add(1);
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
        graph.test();

    }
}
