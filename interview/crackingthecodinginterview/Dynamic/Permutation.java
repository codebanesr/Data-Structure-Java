package interview.crackingthecodinginterview.Dynamic;

import java.util.*;

class Permutation {
    static Set<String> result = new HashSet<>();

    public static void main(String args[]) {

        String s = "abc";
        permutation(s, Character.MIN_VALUE, s.length(), "");

        for (String sub : result) {
            System.out.println(sub);
        }
    }





    /**
                        {a,   b,     c }                 
                      a/      |b      \c
                    {b,c}   {a,c}     {a, b}
                  b / \      a/  \    a/ \     [All 6 permutations can be seen here]
                  {c}        {c}      {b}
                 c/          c|       b|
                ""           ""       ""           
        The path taken in the recursion are all possible permutations of the string
     * @param s
     * @param presentChar
     * @param l
     * @param fin
     */
    public static void permutation(String s, char presentChar, int l, String fin) {
        fin += presentChar;
        // empty character that i am sending is being counted as length 1
        if (fin.length() == l+1) {
            result.add(fin);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            // removing character i from the main string and generating all possible values for
            // index l in the permutation...., when i send a character i will still have to exhaust 
            // all other characters .... 
            // hint build a tree structure with string abc
            permutation(s.substring(0, i) + s.substring(i + 1), s.charAt(i), l, fin);
        }
    }
}
