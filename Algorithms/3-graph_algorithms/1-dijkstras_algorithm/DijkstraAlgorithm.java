import java.util.*;

public class DijkstraAlgorithm {

    static class Edge {
        int source, destination, weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static void dijkstra(ArrayList<Edge>[] graph, int vertices, int source) {
        // Create priority queue for vertices
        PriorityQueue<Integer> pq = new PriorityQueue<>(vertices, Comparator.comparingInt(a -> a));

        // Initialize distances array
        int[] distances = new int[vertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        // Add source vertex to priority queue
        pq.offer(source);

        while (!pq.isEmpty()) {
            int u = pq.poll();

            // Iterate through all adjacent vertices of u
            for (Edge edge : graph[u]) {
                int v = edge.destination;
                int weight = edge.weight;

                // If there's a shorter path to v through u
                if (distances[u] != Integer.MAX_VALUE && distances[u] + weight < distances[v]) {
                    distances[v] = distances[u] + weight;
                    pq.offer(v);
                }
            }
        }

        // Print distances
        System.out.println("Shortest distances from source vertex " + source + ":");
        for (int i = 0; i < vertices; i++) {
            System.out.println("Vertex " + i + ": " + distances[i]);
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 4));
        graph[0].add(new Edge(0, 2, 8));
        graph[1].add(new Edge(1, 2, 2));
        graph[1].add(new Edge(1, 3, 5));
        graph[2].add(new Edge(2, 3, 5));
        graph[2].add(new Edge(2, 4, 9));
        graph[3].add(new Edge(3, 4, 4));

        int source = 0;

        dijkstra(graph, vertices, source);
    }
}
