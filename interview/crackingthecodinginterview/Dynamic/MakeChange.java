package interview.crackingthecodinginterview.Dynamic;

import java.util.*;

public class MakeChange {
    public static void main(String[] args) {
        int coins[] = { 25, 10, 5, 1 };
        int sum = 10;
        int ways[] = calculateWaysToMakeChange(coins, sum);

        System.out.println(Arrays.toString(ways));
    }

    public static int[] calculateWaysToMakeChange(int coins[], int sum) {
        int dp[] = new int[sum + 1];
        dp[1] = dp[0] = 1;

        for (int i = 2; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] += dp[i - coins[j]];
                }
            }
        }

        return dp;
    }
}
