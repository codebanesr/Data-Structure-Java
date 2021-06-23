package interview.sprint1;

public class CoinChange {
  public static void main(String args[]) {
    int N = 11;
    int coins[] = { 1 , 2, 5 };

    System.out.println(Solution(coins, N));
  }



  public static int Solution(int coins[], int sum) {
    int dp[] = new int[sum+1];
    dp[0] = 1;

    for(int i=0; i<coins.length; i++) {
      for(int j=coins[i]; j<=sum; j++) {
        dp[j] = dp[j-coins[i]] + dp[j];
      }
    }
    return dp[sum];
  }
}
