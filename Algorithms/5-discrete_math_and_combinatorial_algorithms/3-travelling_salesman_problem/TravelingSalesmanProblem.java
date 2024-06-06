import java.util.ArrayList;
import java.util.List;

public class TravelingSalesmanProblem {

    private static int[][] distances; // Distance matrix
    private static int numCities; // Number of cities
    private static List<Integer> bestPath; // Best path found
    private static int shortestDistance = Integer.MAX_VALUE; // Shortest distance found so far

    public static void tsp(int[][] distanceMatrix) {
        distances = distanceMatrix;
        numCities = distances.length;
        bestPath = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        boolean[] visited = new boolean[numCities];
        visited[0] = true; // Start from city 0
        currentPath.add(0); // Add city 0 to the path
        tspHelper(0, visited, currentPath, 0);
    }

    private static void tspHelper(int currentCity, boolean[] visited, List<Integer> currentPath, int distanceSoFar) {
        if (currentPath.size() == numCities) { // All cities visited
            if (distanceSoFar + distances[currentCity][0] < shortestDistance) { // Update best path if shorter
                shortestDistance = distanceSoFar + distances[currentCity][0];
                bestPath = new ArrayList<>(currentPath);
                bestPath.add(0); // Return to the starting city
            }
            return;
        }

        for (int nextCity = 0; nextCity < numCities; nextCity++) {
            if (!visited[nextCity]) {
                visited[nextCity] = true;
                currentPath.add(nextCity);
                tspHelper(nextCity, visited, currentPath, distanceSoFar + distances[currentCity][nextCity]);
                visited[nextCity] = false;
                currentPath.remove(currentPath.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[][] distances = {
                {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}
        };

        tsp(distances);

        System.out.println("Shortest distance: " + shortestDistance);
        System.out.println("Best path: " + bestPath);
    }
}
