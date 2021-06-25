package interview.sprint1;

import java.util.Arrays;

public class ChocolateDistribution {
  public static void main(String args[]) {
    int arr[] = {3, 4, 1, 9, 56, 7, 9, 12} ;
    int m = 5;
    System.out.println(Solution(arr, m));
  }



  public static int Solution(int arr[], int m) {
    Arrays.sort(arr);
    int diff = Integer.MAX_VALUE;
    for(int i=0; i<arr.length-m + 1; i++) {
      int j = i+m-1;

      if(arr[j]-arr[i] < diff) {
        diff = arr[j] - arr[i];
      }
    }

    return diff;
  }
}