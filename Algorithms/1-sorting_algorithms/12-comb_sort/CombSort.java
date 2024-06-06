public class CombSort {
    // To find gap between elements
    public static int getNextGap(int gap) {
        // Shrink gap by Shrink factor
        gap = (gap * 10) / 13;
        if (gap < 1) {
            return 1;
        }
        return gap;
    }

    // Function to sort arr[] using Comb Sort
    public static void combSort(int[] arr) {
        int n = arr.length;

        // Initialize gap
        int gap = n;

        // Initialize swapped as true to make sure that loop runs
        boolean swapped = true;

        // Keep running while gap is more than 1 or last iteration caused a swap
        while (gap > 1 || swapped) {
            // Find next gap
            gap = getNextGap(gap);

            // Initialize swapped as false so that we can check if swap happened or not
            swapped = false;

            // Compare all elements with current gap
            for (int i = 0; i < n - gap; i++) {
                if (arr[i] > arr[i + gap]) {
                    // Swap arr[i] and arr[i+gap]
                    int temp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = temp;

                    // Set swapped
                    swapped = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 4, 1, 56, 3, -44, 23, -6, 28, 0};

        System.out.println("Unsorted array:");
        printArray(arr);

        combSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }

    // Utility method to print an array
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
