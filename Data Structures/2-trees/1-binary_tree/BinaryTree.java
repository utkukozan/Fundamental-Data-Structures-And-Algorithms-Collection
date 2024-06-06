class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    // Method to insert a new node
    void insert(int key) {
        root = insertRec(root, key);
    }

    // A recursive function to insert a new key in BST
    Node insertRec(Node root, int key) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Otherwise, recur down the tree
        if (key < root.data)
            root.left = insertRec(root.left, key);
        else if (key > root.data)
            root.right = insertRec(root.right, key);

        // return the (unchanged) node pointer
        return root;
    }

    // Method to print the tree in preorder
    void printPreorder(Node node) {
        if (node == null)
            return;

        // Visit the root
        System.out.print(node.data + " ");

        // Traverse the left subtree
        printPreorder(node.left);

        // Traverse the right subtree
        printPreorder(node.right);
    }

    // Method to print the tree in inorder
    void printInorder(Node node) {
        if (node == null)
            return;

        // Traverse the left subtree
        printInorder(node.left);

        // Visit the root
        System.out.print(node.data + " ");

        // Traverse the right subtree
        printInorder(node.right);
    }

    // Method to print the tree in postorder
    void printPostorder(Node node) {
        if (node == null)
            return;

        // Traverse the left subtree
        printPostorder(node.left);

        // Traverse the right subtree
        printPostorder(node.right);

        // Visit the root
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Insert some elements
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Preorder traversal of the binary tree:");
        tree.printPreorder(tree.root);
        System.out.println("\nInorder traversal of the binary tree:");
        tree.printInorder(tree.root);
        System.out.println("\nPostorder traversal of the binary tree:");
        tree.printPostorder(tree.root);
    }
}
