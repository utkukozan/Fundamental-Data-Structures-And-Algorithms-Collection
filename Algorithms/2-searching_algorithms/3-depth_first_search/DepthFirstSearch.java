import java.util.*;

public class DepthFirstSearch {

    // Function to perform Depth First Search
    public static void dfs(ArrayList<ArrayList<Integer>> adjList, int source, boolean[] visited) {
        visited[source] = true;
        System.out.print(source + " ");

        for (int neighbor : adjList.get(source)) {
            if (!visited[neighbor]) {
                dfs(adjList, neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        // Add edges to the graph
        addEdge(adjList, 0, 1);
        addEdge(adjList, 0, 2);
        addEdge(adjList, 1, 3);
        addEdge(adjList, 1, 4);
        
        boolean[] visited = new boolean[vertices];

        System.out.println("Depth First Traversal:");
        dfs(adjList, 0, visited);
    }

    // Function to add an edge to the graph
    public static void addEdge(ArrayList<ArrayList<Integer>> adjList, int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }
}
