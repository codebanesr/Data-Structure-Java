package practicesection;


import java.util.*;
public class LongestIncreasingSequence {
    public static void main(String[] args) {

        int arr[] = {1,2,3,4,5,6,7,8,-1,-1,12};
        System.out.println(solve(arr));
    }
    


    static int solve(int arr[]) {
        // track[i] LIS formed by taking element at index i in arr
        int[] tracker = new int[arr.length];
        Arrays.fill(tracker, 1);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && tracker[j] + 1 > tracker[i]) {
                    tracker[i] = tracker[j] + 1;
                }
            }
        }


        int max = Integer.MIN_VALUE;
        for (int i = 0; i < tracker.length; i++) {
            if (tracker[i] > max) {
                max = tracker[i];
            }
        }


        return max;
    }
}
