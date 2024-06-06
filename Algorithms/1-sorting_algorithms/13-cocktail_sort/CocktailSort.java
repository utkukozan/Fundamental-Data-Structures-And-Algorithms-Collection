public class CocktailSort {
    public static void cocktailSort(int[] arr) {
        boolean swapped = true;
        int start = 0;
        int end = arr.length - 1;

        while (swapped) {
            // Reset the swapped flag on each iteration
            swapped = false;

            // Forward pass: Bubble the largest element to the end
            for (int i = start; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    // Swap arr[i] and arr[i+1]
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
            
            // If no swaps occurred, the array is already sorted
            if (!swapped) {
                break;
            }

            // Decrement end as the largest element is now at the end
            end--;

            // Backward pass: Bubble the smallest element to the start
            for (int i = end; i > start; i--) {
                if (arr[i] < arr[i - 1]) {
                    // Swap arr[i] and arr[i-1]
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    swapped = true;
                }
            }

            // Increment start as the smallest element is now at the start
            start++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Unsorted array:");
        printArray(arr);

        cocktailSort(arr);

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
