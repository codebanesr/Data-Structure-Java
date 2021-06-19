package interview.sprint1;

import java.util.HashSet;
import java.util.Set;

public class SameSumPairs {
  public static void main(String args[]) {
    int sum = 7;
    int arr[] = { 1, 2, 3, 4, 5, 6 };
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < arr.length; i++) {
      if(set.contains(sum - arr[i])) {
        System.out.println(arr[i] + ", "+ (sum-arr[i]));
      } else{
        set.add(arr[i]);
      }
    }


    System.out.println("---------trivial----------");
    trivial(arr, sum);
  }


  public static void trivial(int arr[], int sum) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = i; j < arr.length; j++) {
        if(arr[i]+arr[j] == sum) {
          System.out.println(arr[i] + ", " + arr[j]);
        }
      }
    }
  }
}
