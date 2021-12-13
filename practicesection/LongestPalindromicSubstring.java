
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "palinddnioap";
        // DP solution
        // int answer = solver(s.toCharArray());
        // System.out.println(answer);


        // // recursive sol
        // System.out.println("Now printing recursive solution");
        new LongestPalindromicSubstring().recursiveLPSubstring(s, 0, s.length() - 1);
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
    

    public static String getKey(int start, int end) {
        return start + "|" + end;
    }

    class MaxLen {
        int maxLen;

        MaxLen() {
            maxLen = 0;
        }
    }

    public void recursiveLPSubstring(String s, int start, int end) {
        MaxLen m = new MaxLen();
        recursiveLPSubstringUtil(s, start, end, m);
        System.out.println(m.maxLen);
    }
    

    public int recursiveLPSubstringUtil(String s, int start, int end, MaxLen m) {
        int result = 0;
        if (end < start) {
            return 0;
        }
        if (end == start) {
            m.maxLen = Math.max(m.maxLen, 1);
            return 1;
        } else if(end - start == 1) {
            result = s.charAt(end) == s.charAt(start) ? 2 : 0;
            m.maxLen = Math.max(m.maxLen, result);
            return result;
        }

        if (s.charAt(start) == s.charAt(end) && recursiveLPSubstringUtil(s, start+1, end-1, m) > 0) {
            result = 2 + recursiveLPSubstringUtil(s, start + 1, end - 1, m);
            m.maxLen = Math.max(m.maxLen, result);
        } else {
            int t = Math.max(recursiveLPSubstringUtil(s, start + 1, end, m),
                    recursiveLPSubstringUtil(s, start, end - 1, m));

            m.maxLen = Math.max(t, m.maxLen);
        }
        return result;
    }
}
