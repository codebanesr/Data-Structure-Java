package interview.crackingthecodinginterview.Dynamic;

import java.util.Arrays;

public class Stairs {
    public static void main(String[] args) {
        int result[] = solveDynamic(10);
        System.out.println(Arrays.toString(result));
    }

    public static int solveRecursive(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1 || n == 2 || n == 3) {
            return 1;
        }

        return solveRecursive(n - 1) + solveRecursive(n - 2) + solveRecursive(n - 3);
    }
    
    public static int[] solveDynamic(int n) {
        int dp[] = new int[n + 1];
        
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        
        return dp;
    }
}



    // 0
    // 1 -> [1,0]
    // 2 -> [2,0], [2,1,0]
    // 3 -> [3, 0], [3,1,0], [3,2,0], [3,2,1,0]