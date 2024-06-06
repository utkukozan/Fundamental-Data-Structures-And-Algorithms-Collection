class FenwickTree {
    private int[] tree;

    public FenwickTree(int size) {
        this.tree = new int[size + 1];
    }

    // Update the value at index i by delta
    public void update(int i, int delta) {
        while (i < tree.length) {
            tree[i] += delta;
            i += i & -i; // Update the next node in the tree
        }
    }

    // Get the sum of elements from index 1 to i
    public int query(int i) {
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= i & -i; // Move to the parent node
        }
        return sum;
    }

    // Get the sum of elements from index i to j
    public int queryRange(int i, int j) {
        return query(j) - query(i - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 11};
        FenwickTree fenwickTree = new FenwickTree(nums.length);

        // Build the Fenwick Tree
        for (int i = 0; i < nums.length; i++) {
            fenwickTree.update(i + 1, nums[i]);
        }

        // Test queries
        System.out.println("Sum of elements from index 1 to 3: " + fenwickTree.queryRange(1, 3));
        System.out.println("Sum of elements from index 2 to 5: " + fenwickTree.queryRange(2, 5));

        // Update an element at index 3
        fenwickTree.update(3, 10);

        // Test query after update
        System.out.println("Sum of elements from index 1 to 3 after update: " + fenwickTree.queryRange(1, 3));
    }
}
