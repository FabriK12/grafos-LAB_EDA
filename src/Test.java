import GrafoLA.Graph;

public class Test {
    public static void main(String[] args) {
        Graph<Character> graph = new Graph<Character>();
        graph.insertVertex('C');
        graph.insertVertex('V');
        graph.insertVertex('A');
        graph.insertVertex('E');
        graph.insertVertex('B');

        graph.insertEdge('C', 'V');
        graph.insertEdge('C', 'A');
        graph.insertEdge('A', 'E');
        graph.insertEdge('A', 'B');
        graph.insertEdge('E', 'B');
        graph.insertEdge('V', 'B');

        graph.initLabels();
        System.out.println(graph);
    }
}
