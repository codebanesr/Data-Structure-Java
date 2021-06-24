package interview.sprint1;

public class LongestConsecutiveSubsequence {
  public static void main(String args[]) {
    int arr[] = { 1, 2, 3, 4, 1, 2, 3, 5, 6 };
    System.out.println(Solution(arr));
  }

  public static int Solution(int arr[]) {
    int dp[] = new int[arr.length];
    dp[0] = 1;
    for(int i=1; i<arr.length; i++) {
      for(int j=0; j<i; j++) {
        if(arr[i] > arr[j]) {
          dp[i] = Math.max(dp[j]+1, dp[i]);
        }
      }
    }
    return dp[arr.length-1];
  }
}
