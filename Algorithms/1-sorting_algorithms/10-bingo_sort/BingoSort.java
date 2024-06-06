import java.util.ArrayList;
import java.util.List;

public class BingoSort {
    public static void bingoSort(int[] arr) {
        // Find the maximum value in the array
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // Create buckets
        List<List<Integer>> buckets = new ArrayList<>(max + 1);
        for (int i = 0; i <= max; i++) {
            buckets.add(new ArrayList<>());
        }

        // Distribute elements into buckets
        for (int value : arr) {
            buckets.get(value).add(value);
        }

        // Merge buckets into the original array
        int index = 0;
        for (List<Integer> bucket : buckets) {
            for (int value : bucket) {
                arr[index++] = value;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 5, 2, 3, 5};
        
        System.out.println("Unsorted array:");
        printArray(arr);
        
        bingoSort(arr);
        
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
