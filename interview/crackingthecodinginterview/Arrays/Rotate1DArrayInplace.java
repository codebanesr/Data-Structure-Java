package interview.crackingthecodinginterview.Arrays;

import java.util.*;

class Rotate1DArrayInplace {
    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int k = 3;
        rotate(arr, k);
    }

    public static void rotate(int arr[], int k) {
        int n = arr.length;
        // Divide the array into two parts, rotate both parts separately and then rotate
        // the entire array
        rotate(arr, 0, n - k - 1);
        System.out.println(Arrays.toString(arr));
        rotate(arr, n - k, n-1);
        System.out.println(Arrays.toString(arr));
        rotate(arr, 0, n-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void rotate(int arr[], int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
