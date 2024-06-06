import java.util.*;

class UndirectedGraph {
    private int V;
    private LinkedList<Integer>[] adjList;

    UndirectedGraph(int vertices) {
        V = vertices;
        adjList = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    void addEdge(int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src); // For undirected graph, add reverse connection
    }

    void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.print("Vertex " + i + " is connected to:");
            for (Integer vertex : adjList[i]) {
                System.out.print(" -> " + vertex);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.printGraph();
    }
}
