package interview.sprint2;

import java.util.LinkedList;

public class Subsets {
    static LinkedList<String> powerSet = new LinkedList<>();
    public static void main(String[] args) {
        powerSet("abc", "", 0, "abc".length());
        for (String s : powerSet) {
            System.out.println(s);
        }
    }
    

    // The relative ordering will not change in this case, this is not generating all the permutations of the
    // given string, only the subsets
    public static void powerSet(String word, String s, int index, int total) {
        if (index >= total) {
            powerSet.add(s);
            return;
        }

        powerSet(word, s+word.charAt(index), index+1, total);
        powerSet(word, s, index+1, total);
    }
}
