package practicesection;

import java.util.*;

class Quicksort {
    public static void main(String argos[]) {
        int arr[] = { 4, 5, 3, 6, 1, 8, 8, 3, 4, 1 };
        QS(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public static void QS(int arr[], int start, int end) {
        if (start > end) {
            return;
        }
        int p = partition(arr, start, end);
        QS(arr, start, p - 1);
        QS(arr, p + 1, end);
    }

    public static int partition(int arr[], int start, int end) {
        int pivot = arr[end];
        int j = start - 1;
        for (int i = start; i < end; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, ++j);
            }
        }

        swap(arr, end, ++j);
        return j;
    }

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
