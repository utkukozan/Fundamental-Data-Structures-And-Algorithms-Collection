import java.util.ArrayList;
import java.util.List;

class Node {
    int val;
    List<Node> children;

    public Node(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }
}

class NAryTree {
    Node root;

    public NAryTree(int val) {
        this.root = new Node(val);
    }

    // Add a child to a given parent node
    public void addChild(Node parent, int val) {
        Node child = new Node(val);
        parent.children.add(child);
    }

    // Depth-first traversal (Preorder)
    public void dfs(Node node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        for (Node child : node.children) {
            dfs(child);
        }
    }

    public static void main(String[] args) {
        // Create an n-ary tree
        NAryTree tree = new NAryTree(1);

        // Add children to the root
        tree.addChild(tree.root, 2);
        tree.addChild(tree.root, 3);
        tree.addChild(tree.root, 4);

        // Add children to the node with value 2
        tree.addChild(tree.root.children.get(0), 5);
        tree.addChild(tree.root.children.get(0), 6);

        // Add children to the node with value 3
        tree.addChild(tree.root.children.get(1), 7);

        // Print the tree using DFS (Preorder)
        System.out.println("DFS (Preorder) traversal of the n-ary tree:");
        tree.dfs(tree.root);
    }
}
