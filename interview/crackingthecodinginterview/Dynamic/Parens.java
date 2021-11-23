package interview.crackingthecodinginterview.Dynamic;

import java.util.*;
class Parens {
    public static void main(String args[]) {
        int n = 100;
        countCombination(0, 0, n, "");
        System.out.println(count);
        System.out.println(Arrays.toString(result.toArray()));
    }

    static int count = 0;
    static LinkedList<String> result = new LinkedList<>();

    public static void countCombination(int oi, int ci, int n, String temp) {
        if (oi == n && ci == n) {
            result.add(temp);
            count++;
        }

        if (oi > n || ci > n || ci > oi) {
            return;
        }

        countCombination(oi + 1, ci, n, temp + "(");

        countCombination(oi, ci + 1, n, temp + ")");
    }
}