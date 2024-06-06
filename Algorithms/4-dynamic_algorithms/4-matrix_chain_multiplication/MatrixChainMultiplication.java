public class MatrixChainMultiplication {

    public static int matrixChainOrder(int[] dimensions) {
        int n = dimensions.length;
        
        // Create a 2D array to store the minimum number of multiplications
        int[][] dp = new int[n][n];
        
        // Fill the diagonal with 0 because a single matrix requires no multiplication
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }
        
        // Iterate over the chain lengths
        for (int chainLen = 2; chainLen < n; chainLen++) {
            for (int i = 1; i < n - chainLen + 1; i++) {
                int j = i + chainLen - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + dimensions[i - 1] * dimensions[k] * dimensions[j];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                    }
                }
            }
        }
        
        // The result is stored in dp[1][n-1]
        return dp[1][n - 1];
    }

    public static void main(String[] args) {
        int[] dimensions = {10, 20, 30, 40, 30};
        System.out.println("Minimum number of multiplications: " + matrixChainOrder(dimensions));
    }
}
