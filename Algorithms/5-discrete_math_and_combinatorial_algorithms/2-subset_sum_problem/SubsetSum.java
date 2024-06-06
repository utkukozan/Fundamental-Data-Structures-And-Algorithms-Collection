import java.util.ArrayList;
import java.util.List;

public class SubsetSum {

    // Function to find subsets with given sum
    public static List<List<Integer>> findSubsetsWithSum(int[] nums, int targetSum) {
        List<List<Integer>> subsets = new ArrayList<>();
        findSubsetsWithSumHelper(nums, 0, new ArrayList<>(), subsets, targetSum);
        return subsets;
    }

    private static void findSubsetsWithSumHelper(int[] nums, int index, List<Integer> currentSubset, List<List<Integer>> subsets, int remainingSum) {
        if (remainingSum == 0) {
            subsets.add(new ArrayList<>(currentSubset));
            return;
        }

        if (index >= nums.length || remainingSum < 0)
            return;

        // Include current element
        currentSubset.add(nums[index]);
        findSubsetsWithSumHelper(nums, index + 1, currentSubset, subsets, remainingSum - nums[index]);

        // Exclude current element
        currentSubset.remove(currentSubset.size() - 1);
        findSubsetsWithSumHelper(nums, index + 1, currentSubset, subsets, remainingSum);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 5, 7};
        int targetSum = 7;

        List<List<Integer>> subsets = findSubsetsWithSum(nums, targetSum);

        System.out.println("Subsets with sum " + targetSum + ": ");
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
