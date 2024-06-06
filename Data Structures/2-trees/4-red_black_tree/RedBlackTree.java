enum Color {
    RED, BLACK
}

class Node {
    int key;
    Color color;
    Node left, right, parent;

    public Node(int key) {
        this.key = key;
        color = Color.RED;
        left = right = parent = null;
    }
}

class RedBlackTree {
    private Node root;
    private Node nullNode;

    public RedBlackTree() {
        nullNode = new Node(0);
        nullNode.color = Color.BLACK;
        nullNode.left = nullNode.right = null;
        root = nullNode;
    }

    // Rotate left
    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != nullNode)
            y.left.parent = x;
        y.parent = x.parent;
        if (x.parent == nullNode)
            root = y;
        else if (x == x.parent.left)
            x.parent.left = y;
        else
            x.parent.right = y;
        y.left = x;
        x.parent = y;
    }

    // Rotate right
    private void rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != nullNode)
            y.right.parent = x;
        y.parent = x.parent;
        if (x.parent == nullNode)
            root = y;
        else if (x == x.parent.right)
            x.parent.right = y;
        else
            x.parent.left = y;
        y.right = x;
        x.parent = y;
    }

    // Insert a new key
    public void insert(int key) {
        Node newNode = new Node(key);
        Node parent = nullNode;
        Node current = root;

        while (current != nullNode) {
            parent = current;
            if (newNode.key < current.key)
                current = current.left;
            else
                current = current.right;
        }

        newNode.parent = parent;
        if (parent == nullNode)
            root = newNode;
        else if (newNode.key < parent.key)
            parent.left = newNode;
        else
            parent.right = newNode;

        newNode.left = nullNode;
        newNode.right = nullNode;
        newNode.color = Color.RED;
        insertFixUp(newNode);
    }

    // Maintain Red-Black tree properties after insertion
    private void insertFixUp(Node x) {
        while (x != root && x.parent.color == Color.RED) {
            if (x.parent == x.parent.parent.left) {
                Node y = x.parent.parent.right;
                if (y.color == Color.RED) {
                    x.parent.color = Color.BLACK;
                    y.color = Color.BLACK;
                    x.parent.parent.color = Color.RED;
                    x = x.parent.parent;
                } else {
                    if (x == x.parent.right) {
                        x = x.parent;
                        leftRotate(x);
                    }
                    x.parent.color = Color.BLACK;
                    x.parent.parent.color = Color.RED;
                    rightRotate(x.parent.parent);
                }
            } else {
                Node y = x.parent.parent.left;
                if (y.color == Color.RED) {
                    x.parent.color = Color.BLACK;
                    y.color = Color.BLACK;
                    x.parent.parent.color = Color.RED;
                    x = x.parent.parent;
                } else {
                    if (x == x.parent.left) {
                        x = x.parent;
                        rightRotate(x);
                    }
                    x.parent.color = Color.BLACK;
                    x.parent.parent.color = Color.RED;
                    leftRotate(x.parent.parent);
                }
            }
        }
        root.color = Color.BLACK;
    }

    // Print the tree in order
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node != nullNode) {
            inOrder(node.left);
            System.out.print(node.key + "(" + node.color + ") ");
            inOrder(node.right);
        }
    }

    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();

        // Insert some elements
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);

        // Print the tree in order
        System.out.println("Inorder traversal of the Red-Black tree:");
        tree.inOrder();
    }
}
