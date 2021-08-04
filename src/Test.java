import GrafoLA.Graph;

public class Test {
    public static void main(String[] args) {
        Graph<Character> graph = new Graph<Character>();
        graph.insertVertex('C');
        graph.insertVertex('V');
        graph.insertVertex('C');
        System.out.println(graph);
    }
}
