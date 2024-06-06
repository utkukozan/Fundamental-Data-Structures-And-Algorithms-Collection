import java.util.*;

class TopologicalSortAlgorithm {
    static class Graph {
        int V;
        List<List<Integer>> adjList;

        Graph(int V) {
            this.V = V;
            adjList = new ArrayList<>(V);
            for (int i = 0; i < V; i++)
                adjList.add(new ArrayList<>());
        }

        void addEdge(int src, int dest) {
            adjList.get(src).add(dest);
        }

        void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
            visited[v] = true;

            for (Integer neighbor : adjList.get(v)) {
                if (!visited[neighbor]) {
                    topologicalSortUtil(neighbor, visited, stack);
                }
            }

            stack.push(v);
        }

        void topologicalSort() {
            Stack<Integer> stack = new Stack<>();
            boolean[] visited = new boolean[V];

            for (int i = 0; i < V; i++) {
                if (!visited[i]) {
                    topologicalSortUtil(i, visited, stack);
                }
            }

            // Print the contents of the stack
            System.out.println("Topological Sorting:");
            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int V = 6;
        Graph graph = new Graph(V);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        graph.topologicalSort();
    }
}
