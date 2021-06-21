package interview.sprint1;

import java.util.HashSet;
import java.util.Set;

public class PrintPossibleCombinations {
  static Set<String> set = new HashSet<>();
  public static void main(String args[]) {
    int arr[] = { 1, 2, 3, 4, 5 };
    int r = 3;
    
    recurse(arr, r, 0, "");

    System.out.println(set);
  }


  public static void recurse(int arr[], int r, int ci, String s) {
    if(s.length() == r) {
      set.add(s);
    }

    // this step should be second, because string is sent from the previous iteration
    if(ci>=arr.length) {
      return;
    }
    
    recurse(arr, r, ci+1, s+arr[ci]);
    recurse(arr, r, ci+1, s);
  }
}
