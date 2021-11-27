package practicesection;

import java.util.Arrays;

public class LPSubsequence {
    public static void main(String[] args) {
        int s = LPS("geeksforgeeks".toCharArray());
        System.out.println(s);
    }

    public static int LPS(char s[]) {
        int dp[][] = new int[s.length][s.length];
        for (int i = 0; i < s.length; i++) {
            dp[i][i] = 1;
        }

        for (int i = 0; i < s.length - 1; i++) {
            if (s[i] == s[i + 1]) {
                dp[i][i + 1] = 2;
            }
        }


        // s = "shanur"; len = 6

        for (int l = 3; l <= s.length; l++) {
            for (int start = 0; start < s.length - l + 1; start++) {
                int end = start + l - 1;
                if (s[start] != s[end]) {
                    dp[start][end] = Math.max(dp[start][end - 1], dp[start + 1][end]);
                } else {
                    dp[start][end] = 2 + dp[start + 1][end - 1];
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));
        return dp[0][s.length - 1];
    }
}
