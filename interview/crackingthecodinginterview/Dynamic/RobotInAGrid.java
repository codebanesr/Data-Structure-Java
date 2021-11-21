package interview.crackingthecodinginterview.Dynamic;

import java.util.*;

public class RobotInAGrid {
    public static void main(String args[]) {
        Scanner x = new Scanner(System.in);
        int rows = 3;
        int cols = 3;
        boolean isAllowed[][] = new boolean[rows][cols];
        int dp[][] = new int[rows][cols];


        isAllowed[0][0] = isAllowed[0][1] = isAllowed[0][2] = isAllowed[1][2] =isAllowed[1][1] = true;
        int total = countWays(isAllowed, dp, rows, cols);


        System.out.println("total ways to reach last row and column " + total);

        x.close();
    }

    public static int countWays(boolean isAllowed[][], int dp[][], int rows, int cols) {
        dp[0][0] = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(!isAllowed[i][j]) {
                    dp[i][j] = 0;
                    continue;    
                }


                if (i - 1 >= 0 && j - 1 >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else if (i - 1 >= 0) {
                    dp[i][j] = dp[i - 1][j];
                } else if (j - 1 >= 0) {
                    dp[i][j] = dp[i][j - 1];
                }

            }
        }

        return dp[rows-2][cols - 1] + dp[rows-1][cols-2];
    }

}
