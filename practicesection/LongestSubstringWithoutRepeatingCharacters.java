package practicesection;

import java.util.*;

class ResultPair {
    int start, end;
}

class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String args[]) {
        String s = "ylllllasdfghj33aaasdfasdf";
        char result[] = solve(s.toCharArray());
        System.out.println(Arrays.toString(result));
    }

    public static char[] solve(char charr[]) {
        int length = 0, maxLength = Integer.MIN_VALUE;
        ResultPair rp = new ResultPair();
        HashSet<Character> hset = new HashSet<>();
        int start = 0, end = 0;
        for (int i = 0; i < charr.length; i++) {
            if (!hset.contains(charr[i])) {
                end++;
            } else if (hset.contains(charr[i]) || i == charr.length - 1) {
                hset.clear();
                length = end - start;
                if (length > maxLength) {
                    maxLength = length;
                    rp.start = start;
                    rp.end = end;
                }
                start = i;
                end = i;
            }

            hset.add(charr[i]);
        }

        // if the longest string comes at last, we will not arrive at the else condition
        // because the for loop itself terminates ..., therefore we need this check at the end
        // i have now adjusted this statement in if else clause
        // if (end - start > rp.end - rp.start) {
        //     rp.end = end;
        //     rp.start = start;
        // }

        return Arrays.copyOfRange(charr, rp.start, rp.end + 1);
    }
}
