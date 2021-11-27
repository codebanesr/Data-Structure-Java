package practicesection;

import java.util.Arrays;

class Pair {
    int min, max;

    Pair(int min, int max) {
        this.min = min;
        this.max = max;
    }
}
public class Minmax {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6 };
        Pair minmax = findMinMaxPair(arr);
        System.out.println(String.format("min = %d, max=%d", minmax.max, minmax.min));
            //  [minmax.min, minmax.max]));
    }
    
    static Pair findMinMaxPair(int arr[]) {
        // The following lines are a safety net for programming competitions, this ideally
        // should not happen
        // if (arr.length == 0) {
        //     return new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE);
        // }

        if (arr.length == 1) {
            return new Pair(arr[0], arr[0]);
        }


        if (arr.length == 2) {
            int min = Math.min(arr[0], arr[1]);
            int max = Math.max(arr[0], arr[1]);

            return new Pair(min, max);
        }
        
        int mid = arr.length / 2;
        Pair left = findMinMaxPair(Arrays.copyOfRange(arr, 0, mid));
        Pair right = findMinMaxPair(Arrays.copyOfRange(arr, mid, arr.length));


        int max = Math.max(left.max, right.max);
        int min = Math.min(left.min, right.min);

        return new Pair(min, max);
    }
}
