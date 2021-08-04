import GrafoLA.Graph;

public class Test {
    public static void main(String[] args) {
        Graph<Character> graph = new Graph<Character>();
        graph.insert('C');
        graph.insert('E');
        graph.insert('C');
        System.out.println(graph);
    }
}
