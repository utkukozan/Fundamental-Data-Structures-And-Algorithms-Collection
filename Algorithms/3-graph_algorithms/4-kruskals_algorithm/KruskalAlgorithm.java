import java.util.*;

public class KruskalAlgorithm {

    static class Edge implements Comparable<Edge> {
        int source, destination, weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    static class DisjointSet {
        int[] parent, rank;

        public DisjointSet(int vertices) {
            parent = new int[vertices];
            rank = new int[vertices];
            for (int i = 0; i < vertices; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }

    static void kruskal(ArrayList<Edge> edges, int vertices) {
        // Sort edges by weight
        Collections.sort(edges);

        // Initialize disjoint set
        DisjointSet ds = new DisjointSet(vertices);

        ArrayList<Edge> mst = new ArrayList<>();
        int mstWeight = 0;

        for (Edge edge : edges) {
            int rootSource = ds.find(edge.source);
            int rootDestination = ds.find(edge.destination);
            if (rootSource != rootDestination) {
                mst.add(edge);
                mstWeight += edge.weight;
                ds.union(rootSource, rootDestination);
            }
        }

        // Print MST edges and total weight
        System.out.println("Minimum Spanning Tree edges:");
        for (Edge edge : mst) {
            System.out.println(edge.source + " - " + edge.destination + " : " + edge.weight);
        }
        System.out.println("Total Weight: " + mstWeight);
    }

    public static void main(String[] args) {
        int vertices = 6;
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 4));
        edges.add(new Edge(0, 2, 4));
        edges.add(new Edge(1, 2, 2));
        edges.add(new Edge(1, 3, 3));
        edges.add(new Edge(1, 4, 5));
        edges.add(new Edge(2, 3, 1));
        edges.add(new Edge(3, 4, 6));
        edges.add(new Edge(4, 5, 2));

        kruskal(edges, vertices);
    }
}
