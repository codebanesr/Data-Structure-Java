package interview.crackingthecodinginterview.Extras;

import java.util.Arrays;

public class AdjacentSwap {
    public static void main(String[] args) {
        String s[] = "9 8 1 9 0 8 9".split(" ");
        int n[] = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            n[i] = Integer.parseInt(s[i]);
        }

        int r[] = getSmallest(n, 2);
        System.out.println(Arrays.toString(r));
    }

    public static int[] getSmallest(int arr[], int swaps) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            while (j <= swaps) {
                int smallest = arr[i];
                int smallestIndex = -1;
                int k = i;
                for (; k <= i + swaps - j; k++) {
                    if (k > arr.length - 1) {
                        break;
                    }
                    if (arr[k] < smallest) {
                        smallestIndex = k;
                    }
                }

                if (smallestIndex != -1) {
                    shiftRight(arr, i, k - 1);
                    arr[i] = smallest;
                }
                j++;
            }
        }
        return arr;
    }
    
    public static void shiftRight(int arr[], int start, int end) {
        for (int i = end; i > start; i--) {
            arr[i] = arr[i-1];
        }
    }
}

// 9 8 1 9 0 8 9
// 9 1 8 9 0 8 9
// 1 9 8 9 0 8 9

// shift i...k-1
// place element at k to i th index

