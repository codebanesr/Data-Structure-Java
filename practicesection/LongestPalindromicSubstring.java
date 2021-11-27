package practicesection;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "palinddnioap";
        int answer = solver(s.toCharArray());

        System.out.println(answer);

    }



    public static int solver(char s[]) {
        int dp[][] = new int[s.length][s.length];
        int max = 1;
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 1;
        }

        for (int i = 0; i < dp.length - 1; i++) {
            if (s[i] == s[i + 1]) {
                dp[i][i + 1] = 2;
                max = dp[i][i + 1];
            }
        }
        
        for (int l = 3; l <= s.length; l++) {
            for (int i = 0; i < s.length - l + 1; i++) {
                int j = i + l - 1;

                if (s[i] == s[j] && dp[i + 1][j - 1] > 0) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                    }
                }
            }
        }
        
        return max;
    }
}
