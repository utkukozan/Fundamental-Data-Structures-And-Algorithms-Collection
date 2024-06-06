class SegmentTree {
    private int[] tree;
    private int[] nums;
    private int n;

    public SegmentTree(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.tree = new int[4 * n];
        buildTree(1, 0, n - 1);
    }

    private void buildTree(int index, int left, int right) {
        if (left == right) {
            tree[index] = nums[left];
            return;
        }

        int mid = left + (right - left) / 2;
        buildTree(2 * index, left, mid);
        buildTree(2 * index + 1, mid + 1, right);

        tree[index] = tree[2 * index] + tree[2 * index + 1];
    }

    public void update(int i, int val) {
        updateTree(1, 0, n - 1, i, val);
    }

    private void updateTree(int index, int left, int right, int i, int val) {
        if (left == right) {
            tree[index] = val;
            return;
        }

        int mid = left + (right - left) / 2;
        if (i <= mid)
            updateTree(2 * index, left, mid, i, val);
        else
            updateTree(2 * index + 1, mid + 1, right, i, val);

        tree[index] = tree[2 * index] + tree[2 * index + 1];
    }

    public int sumRange(int i, int j) {
        return sumRange(1, 0, n - 1, i, j);
    }

    private int sumRange(int index, int left, int right, int i, int j) {
        if (left >= i && right <= j) // Segment completely inside the range
            return tree[index];
        if (right < i || left > j)   // Segment completely outside the range
            return 0;

        int mid = left + (right - left) / 2;
        return sumRange(2 * index, left, mid, i, j) + sumRange(2 * index + 1, mid + 1, right, i, j);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 11};
        SegmentTree segmentTree = new SegmentTree(nums);

        // Test sumRange query
        System.out.println("Sum of elements in range [1, 3]: " + segmentTree.sumRange(1, 3));

        // Test update operation
        segmentTree.update(2, 10); // Update the value at index 2 to 10
        System.out.println("Sum of elements in range [1, 3] after update: " + segmentTree.sumRange(1, 3));
    }
}
