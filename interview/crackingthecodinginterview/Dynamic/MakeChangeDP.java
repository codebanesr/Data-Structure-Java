
import java.util.*;

public class MakeChangeDP {
    public static void main(String[] args) {
        int coins[] = { 25, 10, 5, 1 };
        int sum = 10;
        int ways = calculateWaysToMakeChange(coins, sum);

        System.out.println("DP sol below");
        System.out.println(ways);
        
        System.out.println("Recursive memo solution below");
        System.out.println(makeChangeRecursive(coins, sum));
    }

    public static int calculateWaysToMakeChange(int coins[], int sum) {
        int dp[] = new int[sum + 1];
        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            int cc = coins[i];
            for (int j = cc; j <= sum; j++) { // we can only use this coins when sum>coin.value
                dp[j] += dp[j - cc];
            }
        }
        return dp[dp.length-1];
    }


    public static int makeChangeRecursive(int coins[], int sum) {
        HashMap<String, Integer> cache = new HashMap<>();
        return makeChangeRecursiveUtil(coins, sum, 0, cache);
    }

    static String getKey(int i, int sum) {
        return i + "|" + sum;
    }

    static int makeChangeRecursiveUtil(int coins[], int sum, int i, HashMap<String, Integer> cache) {
        if (sum == 0) {
            return 1;
        }

        if (i >= coins.length) {
            return 0;
        }
        String key = getKey(i, sum);

        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        int take = 0, leave = 0;
        if (sum - coins[i] >= 0) {
            take = makeChangeRecursiveUtil(coins, sum - coins[i], i, cache);
        }
        leave = makeChangeRecursiveUtil(coins, sum, i + 1, cache);

        int result = take + leave;
        cache.put(key, result);

        return result;
    }
}
