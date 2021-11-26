package interview.crackingthecodinginterview.Arrays;

import java.util.*;

class SpiralPrinting {
    public static void main(String args[]) {
        int arr[][] = { 
                { 1, 2, 3, 4, 5 }, 
                { 6, 7, 8, 9, 10 }, 
                { 11, 12, 13, 4, 5 },
                { -1, -7, -8, -9, -10 },
                { 0, 1, 0, 1, 0 },
                
        };


        printSpiral(arr);
    }

    public static void printSpiral(int arr[][]) {
        int leftwall = 0, rightwall = arr[0].length - 1, topwall = 0, bottomwall = arr.length - 1;

        while (leftwall < rightwall && topwall < bottomwall) {
            for (int i = leftwall; i <= rightwall; i++) {
                System.out.print(arr[topwall][i] + ", ");
            }

            topwall++;

            for (int i = topwall; i <= bottomwall; i++) {
                System.out.print(arr[i][rightwall] + ", ");
            }

            rightwall--;

            for (int i = rightwall; i >= leftwall; i--) {
                System.out.print(arr[bottomwall][i] + ", ");
            }
            bottomwall--;

            for (int i = bottomwall; i >= topwall; i--) {
                System.out.print(arr[i][leftwall] + ", ");
            }
            leftwall++;
        }


        if (topwall == bottomwall) {
            for (int i = leftwall; i <= rightwall; i++) {
                System.out.print(arr[topwall][i] +", ");
            }
        }
        
        if (leftwall == rightwall) {
            for (int i = topwall; i <=bottomwall ; i++) {
                System.out.print(arr[topwall][i] +", ");
            }
        }
    }
}
