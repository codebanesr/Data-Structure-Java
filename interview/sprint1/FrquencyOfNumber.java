package interview.sprint1;

import java.util.HashMap;
import java.util.Map;

public class FrquencyOfNumber {
  public static void main(String args[]) {
    int arr[] = {1,1,1,2,3,12,4,3,1,2,2,2,4,5,5,4,5};
    System.out.println(Solution(arr));
  }
  
  public static Map<Integer, Integer> Solution(int arr[]) {
    Map<Integer, Integer> map = new HashMap<>();
    for(int i=0; i<arr.length; i++) {
      if(map.containsKey(arr[i])) {
        map.put(arr[i], map.get(arr[i])+1);
      }else {
        map.put(arr[i], 1);
      }
    }
    return map;
  }
}
