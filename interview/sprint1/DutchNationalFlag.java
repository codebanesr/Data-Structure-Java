package interview.sprint1;

import java.util.Arrays;

public class DutchNationalFlag {
  public static void main(String args[]) {
    int arr[] = new int[] { 1, 0, 2, 0, 1, 1, 0, 0, 2 };
    int low = 0;
    int high = arr.length-1;
    int mid = 0;

    // This should be less than or equal to, just because high index doesnot mean that the element is 2
    while(mid <= high) {
      if(arr[mid] == 0) {
        swap(arr, mid, low);
        low++;
        mid++;
      }
      else if(arr[mid] == 1) {
        mid ++;
      }
      // we don't increment low here, maybe the number we pulled from the rightmost is itself 2, we need to check
      // this condition again for the number that comes to this position, and swap it with the new leftmost 2 from the 
      // right
      else if(arr[mid] == 2) {
        swap(arr, mid, high);
        high--;
      }
    }

    System.out.println(Arrays.toString(arr));
  }


  public static void swap(int arr[], int i, int high) {
    int temp = arr[i];
    arr[i] = arr[high];
    arr[high] = temp;
  }
}
