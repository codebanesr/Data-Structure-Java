package interview.sprint1;

import java.util.Arrays;

// Given an array arr[], find the maximum j – i such that arr[j] > arr[i].
public class MaximumIndex {
  public static void main(String args[]) {
    int arr[] = {34, 8, 10, 3, 2, 80, 30, 33, 1};
    int globalMax = 0;
    for(int i=0; i<arr.length; i++) {
      for(int j=i+1; j<arr.length; j++) {
        if(arr[j] > arr[i]) {
          globalMax = Math.max(j-i, globalMax);
        }
      }
    }
    System.out.println(globalMax);


    efficientMethod(arr);
  }



  public static void efficientMethod(int arr[]) {
    // Take a left pointer and a right pointer, I have to implement a guide which tells me
    // whether to go right or move left. 

    // left array can tell me if there is an element on the left smaller than the current
    // element and right array can tell me if there is an element greater than element at 
    // current right index


    int right[] = new int[arr.length];
    int left[] = new int[arr.length];

    int maxsofar = arr[arr.length-1];
    for(int i=arr.length-1; i>=0; i--) {
      maxsofar = Math.max(maxsofar, arr[i]);
      right[i] = maxsofar;
    }

    int minsofar = arr[0];
    for(int i=0; i<arr.length; i++) {
      minsofar = Math.min(minsofar, arr[i]);
      left[i] = minsofar;
    }

    int maxDiff = 0;
    int i=0; int j=0;
    while(i<arr.length && j<arr.length){
      if(right[j] > left[i]) {
        maxDiff = Math.max(maxDiff, j-i);
        j++;
      } else {
        i++;
      }
    }

    System.out.println("\n" +Arrays.toString(left) + "\n" + Arrays.toString(right));
    System.out.println(maxDiff);
  }
}
