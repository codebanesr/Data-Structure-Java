package practicesection;

import java.util.Arrays;

public class MakeChange {
    public static void main(String[] args) {
        int coins[] = {1,2,5};
        int sum = 5;


        int count = getCount(coins, sum);
        System.out.println(count);
    }
    


    public static int getCount(int coins[], int S) {
        int dp[] = new int[S + 1];
        
        dp[0] = 1;
        for (int coin : coins) {
            for (int sum = coin; sum <= S; sum++) {
                dp[sum] += dp[sum - coin];
            }
        }

        System.out.println(Arrays.toString(dp));
        return dp[S];
    }
}
