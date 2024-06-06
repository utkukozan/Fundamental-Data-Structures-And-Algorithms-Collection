import java.util.*;

public class AStar {
    
    // Node class to represent each cell in the grid
    static class Node {
        int x, y; // coordinates of the cell
        int g; // cost from the start node
        int h; // heuristic (estimated cost to reach the end node)
        int f; // total cost
        
        Node parent; // parent node
        
        Node(int x, int y) {
            this.x = x;
            this.y = y;
            this.g = 0;
            this.h = 0;
            this.f = 0;
            this.parent = null;
        }
    }
    
    // A* algorithm implementation
    public static List<Node> aStar(int[][] grid, Node start, Node end) {
        // Open and Closed lists to keep track of visited nodes
        List<Node> openList = new ArrayList<>();
        List<Node> closedList = new ArrayList<>();
        
        // Add the start node to the open list
        openList.add(start);
        
        while (!openList.isEmpty()) {
            // Get the node with the lowest f value from the open list
            Node current = openList.get(0);
            for (int i = 1; i < openList.size(); i++) {
                if (openList.get(i).f < current.f) {
                    current = openList.get(i);
                }
            }
            
            // Remove the current node from the open list and add it to the closed list
            openList.remove(current);
            closedList.add(current);
            
            // If the current node is the end node, reconstruct and return the path
            if (current.x == end.x && current.y == end.y) {
                List<Node> path = new ArrayList<>();
                while (current != null) {
                    path.add(current);
                    current = current.parent;
                }
                Collections.reverse(path);
                return path;
            }
            
            // Generate neighbors of the current node
            List<Node> neighbors = new ArrayList<>();
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    if (dx == 0 && dy == 0) continue;
                    int nx = current.x + dx;
                    int ny = current.y + dy;
                    if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == 0) {
                        neighbors.add(new Node(nx, ny));
                    }
                }
            }
            
            // Update the cost of each neighbor and add them to the open list
            for (Node neighbor : neighbors) {
                if (closedList.contains(neighbor)) continue;
                int tentativeG = current.g + 1; // assuming each move costs 1
                if (!openList.contains(neighbor) || tentativeG < neighbor.g) {
                    neighbor.parent = current;
                    neighbor.g = tentativeG;
                    neighbor.h = Math.abs(neighbor.x - end.x) + Math.abs(neighbor.y - end.y); // Manhattan distance heuristic
                    neighbor.f = neighbor.g + neighbor.h;
                    if (!openList.contains(neighbor)) {
                        openList.add(neighbor);
                    }
                }
            }
        }
        
        // No path found
        return null;
    }
    
    public static void main(String[] args) {
        int[][] grid = {
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0}
        };
        
        Node start = new Node(0, 0);
        Node end = new Node(4, 4);
        
        List<Node> path = aStar(grid, start, end);
        if (path != null) {
            System.out.println("Path found:");
            for (Node node : path) {
                System.out.println("(" + node.x + ", " + node.y + ")");
            }
        } else {
            System.out.println("No path found.");
        }
    }
}
