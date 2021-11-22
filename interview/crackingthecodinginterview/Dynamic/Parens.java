package interview.crackingthecodinginterview.Dynamic;

import java.util.*;
class Parens {
    public static void main(String args[]) {
        int n = 6;
        countCombination(0, 0, n);
        System.out.println(count);
    }

    static int count = 0;

    public static void countCombination(int oi, int ci, int n) {
        if (oi == n && ci == n) {
            count++;
        }

        if (oi > n || ci > n || ci>oi) {
            return;
        }

        countCombination(oi + 1, ci, n);
        countCombination(oi, ci + 1, n);
    }
}
