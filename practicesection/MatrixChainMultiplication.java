import java.util.*;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int arr[] = new int[] { 1, 2, 3, 4 };
        System.out.println(total(arr));

    }

    static int total(int arr[]) {
        int dp[][] = new int[arr.length][arr.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 0;
        }


        for (int L = 2; L < arr.length; ++L) {
            for (int i = 1; i < arr.length - L + 1; i++) {
                int j = i + L - 1;

                if (i >= arr.length || j >= arr.length) {
                    continue;
                }

                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int temp = arr[i - 1] * arr[k] * arr[j] + dp[i][k] + dp[k + 1][j];
                    System.out.println(temp);
                    dp[i][j] = Math.min(dp[i][j], temp);
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));
        return dp[1][arr.length - 1];
    }
}
