public class Main {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.printGraph();


    }
}