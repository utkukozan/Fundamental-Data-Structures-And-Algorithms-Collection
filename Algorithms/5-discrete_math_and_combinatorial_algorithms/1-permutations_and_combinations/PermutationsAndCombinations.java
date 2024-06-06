import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsAndCombinations {

    // Function to calculate factorial
    public static int factorial(int n) {
        if (n == 0)
            return 1;
        return n * factorial(n - 1);
    }

    // Function to calculate permutations
    public static int permutations(int n, int r) {
        return factorial(n) / factorial(n - r);
    }

    // Function to calculate combinations
    public static int combinations(int n, int r) {
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    // Function to generate permutations
    public static List<List<Integer>> generatePermutations(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        generatePermutationsHelper(nums, new ArrayList<>(), permutations);
        return permutations;
    }

    private static void generatePermutationsHelper(int[] nums, List<Integer> currentPermutation, List<List<Integer>> permutations) {
        if (currentPermutation.size() == nums.length) {
            permutations.add(new ArrayList<>(currentPermutation));
            return;
        }

        for (int num : nums) {
            if (!currentPermutation.contains(num)) {
                currentPermutation.add(num);
                generatePermutationsHelper(nums, currentPermutation, permutations);
                currentPermutation.remove(currentPermutation.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        // Test permutations and combinations
        int n = 5;
        int r = 3;

        System.out.println("Permutations of " + n + " choose " + r + ": " + permutations(n, r));
        System.out.println("Combinations of " + n + " choose " + r + ": " + combinations(n, r));

        // Test generatePermutations
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutations = generatePermutations(nums);
        System.out.println("Permutations of " + Arrays.toString(nums) + ": " + permutations);
    }
}
