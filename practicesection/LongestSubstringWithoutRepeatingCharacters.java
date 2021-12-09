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

    /**  two indices { start, .... end } ; 
    keep incrementing end as long as yout dont see a repeat character, and add new characters to set
    as soon as you see a repeat character, calculate the len and store it in 
    maxlen if maxlen<end-start+1 and store this substring as the maxlensubstring, 
    also clear your set at this point
    or if you see the end of array */
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
        return Arrays.copyOfRange(charr, rp.start, rp.end + 1);
    }
}
