package interview.sprint1;

import java.util.Arrays;

public class RotateArray {
  public static void main(String args[]) {
    int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
    int start = arr[0];
    for(int i=0; i<arr.length; i++) {
      arr[i] = arr[(i+1)%arr.length];
    }
    
    arr[arr.length-1] = start;
    System.out.println(Arrays.toString(arr));
  }
}
