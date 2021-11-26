package practicesection;

import java.util.*;

class MergeSort {
    public static void main(String args[]) {
        int arr[] = { 1, 6, 3, 4, 1, 2, 7, 9, 1, 0 };
        mergeSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    public static void merge(int arr[], int start, int mid, int end) {
        // to understand the indexing, consider this simple case 
        // [0, 1] => start = 0, mid = 0, end = 1; If we don't add 1, the program will
        // try to create an array of length 0

        // Refer - https://www.youtube.com/watch?v=mB5HXBb_HY8
        int left[] = new int[mid - start + 1];
        int right[] = new int[end - mid];

        // copy items to both left and right arrays
        for (int i = 0; i < left.length; i++) {
            left[i] = arr[i + start];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = arr[i + mid + 1];
        }

        int l = 0, r = 0, k = start;
        while (l < left.length && r < right.length) {
            if (left[l] <= right[r]) {
                arr[k] = left[l++];
            } else {
                arr[k] = right[r++];
            }

            k++;
        }

        while (l < left.length) {
            arr[k++] = left[l++];
        }

        while (r < right.length) {
            arr[k++] = right[r++];
        }
    }

    public static void mergeSort(int arr[], int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }
}
