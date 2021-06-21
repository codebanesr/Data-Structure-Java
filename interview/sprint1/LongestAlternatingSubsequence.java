package interview.sprint1;

public class LongestAlternatingSubsequence {
  public static void main(String args[]) {
    int arr[] = {10, 22, 9, 33, 49, 50, 31, 60};
    System.out.println(Solution(arr, true));



    int sol = max_util_memoized(arr);
    System.out.println(sol);
  }


  public static int max_util_memoized(int arr[]) {
    int dp[][] = new int[2][arr.length];
    dp[0][0] = 1;
    dp[1][0] = 1;
    for(int j = 1; j<arr.length; j++) {
      if(arr[j-1] < arr[j]) {
        dp[0][j] = Math.max(1+dp[1][j-1], dp[0][j-1]);
      }
      else{
        dp[0][j] = dp[0][j-1];
      }

      if(arr[j] < arr[j-1]) {
        dp[1][j] = Math.max(1+dp[0][j-1], dp[1][j-1]);
      }
      else {
        dp[1][j] = dp[1][j-1];
      }
    }
    return Math.max(dp[0][arr.length-1], dp[1][arr.length-1]);
  }


  public static int max_util(int arr[], int start, int end, boolean flag) {
    int result = 0;

    for(int i=start; i<=end; i++) {
      if(flag && arr[i-1]<arr[i]) {
        result = Math.max(result, 1+max_util(arr, i+1, end, !flag));
      }else if(!flag && arr[i-1]>arr[i]) {
        result = Math.max(result, 1+max_util(arr, i+1, end, !flag));
      }else {
        result = Math.max(result, max_util(arr, i+1, end, flag));
      }
    }
    return result;
  }

  public static int Solution(int arr[], boolean flag) {
    return 1 + Math.max(max_util(arr, 1, arr.length-1, true), max_util(arr, 1, arr.length - 1, false));
  }
}




// 11, 4, 26, 14, 29
// [1, 1, 3] <- ends at larger number
// [1, 2, 2] <- ends at smaller number