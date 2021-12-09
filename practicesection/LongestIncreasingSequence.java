
import java.util.*;
public class LongestIncreasingSequence {
    public static void main(String[] args) {

        int arr[] = {1,2,3,4,5,6,7,8,-1,-1,12};
        System.out.println(solve(arr));
    }
    


    static int solve(int arr[]) {
        // track[i] LIS formed by taking element at index i in arr
        int[] lis = new int[arr.length];
        Arrays.fill(lis, 1);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[j] + 1 > lis[i]) {
                    lis[i] = lis[j] + 1;
                }
            }
        }


        int max = Integer.MIN_VALUE;
        for (int i = 0; i < lis.length; i++) {
            if (lis[i] > max) {
                max = lis[i];
            }
        }


        return max;
    }
}
