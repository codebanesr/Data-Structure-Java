package practicesection;


import java.util.*;
public class MaxSumSubarray {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 1, 2, 0, -1, -2, -3, 11 };
        int answer[] = solve(arr);
        System.out.println(Arrays.toString(answer));
    }
    

    static int[] solve(int arr[]) {
        int sum[] = new int[arr.length];
        sum[0] = arr[0] > 0 ? arr[0] : 0;
        for (int i = 1; i < arr.length; i++) {
            // if the sum till last number is negative, it's contribution if taken
            // forward would be negative which we do not want
            if (sum[i - 1] < 0) {
                // set ith contribution to zero as well if its negative, this will not matter
                // since our prev case will not include it anyways... added it just for clarity
                sum[i] = arr[i] > 0 ? arr[i] : 0;
            }

            sum[i] = sum[i - 1] + arr[i];
        }
        
        return sum;
    }
}
