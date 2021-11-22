package interview.crackingthecodinginterview.Dynamic;

import java.util.*;
class NQueen {
    public static boolean isSafe(boolean arr[][], int r, int c) {
        if(r>arr.length || c> arr.length) {
            return true;
        }
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if ((i - j == r - c || r + c == i + j) && arr[i][j])
                    return false;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i][c] || arr[r][i]) {
                return false;
            }
        }

        return true;
    }

    public static boolean solveNQueen(boolean arr[][], int r) {
        int N = arr.length;
        if (r >= N) {
            return true;
        }

        for (int c = 0; c < arr.length; c++) {
            if (isSafe(arr, r, c)) {
                arr[r][c] = true;
                if (solveNQueen(arr, r + 1)) {
                    return true;
                }

                arr[r][c] = false;
            }
        }

        return false;
    }


    public static void main(String args[]) {
        int n = 4;
        boolean arr[][] = new boolean[n][n];
        solveNQueen(arr, 0);
        System.out.println(Arrays.deepToString(arr));
    }   
}
