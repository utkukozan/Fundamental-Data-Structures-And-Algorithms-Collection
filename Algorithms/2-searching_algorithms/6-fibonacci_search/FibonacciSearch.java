import java.util.Arrays;

public class FibonacciSearch {

    public static int fibonacciSearch(int[] arr, int target) {
        int n = arr.length;
        int fibM_minus_2 = 0;
        int fibM_minus_1 = 1;
        int fibM = fibM_minus_1 + fibM_minus_2;

        while (fibM < n) {
            fibM_minus_2 = fibM_minus_1;
            fibM_minus_1 = fibM;
            fibM = fibM_minus_1 + fibM_minus_2;
        }

        int offset = -1;

        while (fibM > 1) {
            int i = Math.min(offset + fibM_minus_2, n - 1);

            if (arr[i] < target) {
                fibM = fibM_minus_1;
                fibM_minus_1 = fibM_minus_2;
                fibM_minus_2 = fibM - fibM_minus_1;
                offset = i;
            } else if (arr[i] > target) {
                fibM = fibM_minus_2;
                fibM_minus_1 = fibM_minus_1 - fibM_minus_2;
                fibM_minus_2 = fibM - fibM_minus_1;
            } else {
                return i;
            }
        }

        if (fibM_minus_1 == 1 && arr[offset + 1] == target) {
            return offset + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 22, 35, 40, 45, 50, 80, 82, 85, 90, 100 };
        int target = 85;
        int index = fibonacciSearch(arr, target);
        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}
