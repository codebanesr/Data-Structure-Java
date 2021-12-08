package notdone;
public class PalindromePartitioning {
    public void preprocessString(boolean isPalindrome[][], char ch[]) {
        for (int i = 0; i < ch.length; i++) {
            isPalindrome[i][i] = true;
        }

        for (int l = 2; l <= ch.length; l++) {
            for (int start = 0; start < ch.length - l + 1; start++) {
                int end = start + l - 1;

                if (isPalindrome[start + 1][end - 1] && ch[start] == ch[end]) {
                    isPalindrome[start][end] = true;
                }
            }
        }
    }

    public int getTotalCuts(char ch[]) {
        boolean isPalindrome[][] = new boolean[ch.length][ch.length];
        preprocessString(isPalindrome, ch);

        return getTotalCutsUtil(isPalindrome, ch, 0, ch.length - 1);
    }

    public int getTotalCutsUtil(boolean isPalindrome[][], char ch[], int start, int end) {
        if (end - start <= 1) {
            return end - start;
        }

        if (isPalindrome[start][end]) {
            return 0;
        }

        return Math.min(getTotalCutsUtil(isPalindrome, ch, start + 1, end),
                getTotalCutsUtil(isPalindrome, ch, start, end - 1));
    }

    public static void main(String[] args) {

    }
}
