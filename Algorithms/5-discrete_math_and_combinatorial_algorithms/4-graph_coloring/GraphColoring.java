import java.util.*;

public class GraphColoring {

    private static int[][] graph; // Adjacency matrix representing the graph
    private static int numVertices; // Number of vertices in the graph
    private static int[] colors; // Array to store assigned colors to vertices

    // Function to color the graph using a greedy algorithm
    public static void colorGraph(int[][] adjacencyMatrix, int numColors) {
        graph = adjacencyMatrix;
        numVertices = graph.length;
        colors = new int[numVertices];

        // Initialize colors
        Arrays.fill(colors, -1);

        // Color the first vertex with the first color
        colors[0] = 0;

        // Assign colors to remaining vertices
        for (int vertex = 1; vertex < numVertices; vertex++) {
            // Check available colors for the current vertex
            boolean[] availableColors = new boolean[numColors];
            Arrays.fill(availableColors, true);

            // Mark adjacent vertices with their colors
            for (int neighbor = 0; neighbor < numVertices; neighbor++) {
                if (graph[vertex][neighbor] == 1 && colors[neighbor] != -1) {
                    availableColors[colors[neighbor]] = false;
                }
            }

            // Find the first available color
            int color;
            for (color = 0; color < numColors; color++) {
                if (availableColors[color]) {
                    break;
                }
            }

            // Assign the found color to the current vertex
            colors[vertex] = color;
        }

        // Print the assigned colors
        System.out.println("Vertex \t Color");
        for (int i = 0; i < numVertices; i++) {
            System.out.println(i + " \t " + colors[i]);
        }
    }

    public static void main(String[] args) {
        // Example adjacency matrix representing a graph
        int[][] adjacencyMatrix = {
            {0, 1, 1, 1},
            {1, 0, 1, 0},
            {1, 1, 0, 1},
            {1, 0, 1, 0}
        };

        int numColors = 3; // Number of available colors

        colorGraph(adjacencyMatrix, numColors);
    }
}
