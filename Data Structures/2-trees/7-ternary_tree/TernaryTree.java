class Node {
    char data;
    Node left, middle, right;

    public Node(char data) {
        this.data = data;
        this.left = null;
        this.middle = null;
        this.right = null;
    }
}

class TernaryTree {
    Node root;

    public TernaryTree() {
        this.root = null;
    }

    // Method to insert a new node
    public void insert(String word) {
        root = insertUtil(root, word.toCharArray(), 0);
    }

    private Node insertUtil(Node root, char[] word, int index) {
        if (root == null) {
            root = new Node(word[index]);
        }

        if (word[index] < root.data) {
            root.left = insertUtil(root.left, word, index);
        } else if (word[index] > root.data) {
            root.right = insertUtil(root.right, word, index);
        } else {
            if (index + 1 < word.length) {
                root.middle = insertUtil(root.middle, word, index + 1);
            }
        }
        return root;
    }

    // Method to search for a word in the ternary tree
    public boolean search(String word) {
        return searchUtil(root, word.toCharArray(), 0);
    }

    private boolean searchUtil(Node root, char[] word, int index) {
        if (root == null) {
            return false;
        }

        if (word[index] < root.data) {
            return searchUtil(root.left, word, index);
        } else if (word[index] > root.data) {
            return searchUtil(root.right, word, index);
        } else {
            if (index == word.length - 1) {
                return root.middle != null;
            } else {
                return searchUtil(root.middle, word, index + 1);
            }
        }
    }

    public static void main(String[] args) {
        TernaryTree tree = new TernaryTree();

        // Insert some words
        tree.insert("cat");
        tree.insert("cats");
        tree.insert("catnip");

        // Search for words
        System.out.println("Is 'cat' present? " + tree.search("cat"));
        System.out.println("Is 'cats' present? " + tree.search("cats"));
        System.out.println("Is 'dog' present? " + tree.search("dog"));
    }
}
