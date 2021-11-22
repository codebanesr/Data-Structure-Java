package interview.crackingthecodinginterview.Dynamic;
import java.util.*;

public class PermutationWithDuplicates {
    static LinkedList<String> result = new LinkedList<>();

    public static void main(String args[]) {
        String s = "aab";
        HashMap<Character, Integer> map = getFrequencyMap(s);

        getPermutation(map, "", s.length());


        for(String st: result) {
            System.out.println(st);
        }
    }


    public static HashMap<Character, Integer> getFrequencyMap(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char carr[] = s.toCharArray();
        for(Character ch: carr) {
            if(map.putIfAbsent(ch, 1) != null) {
                map.put(ch, map.get(ch) + 1);
            }
        }

        return map;
    }

    public static void getPermutation(HashMap<Character, Integer> map, String prefix, int remCount) {
        if (remCount == 0) {
            result.add(prefix);
            return;
        }
        // keySet will only consider distinct branches since, same character wont appear twice
        for (Character c : map.keySet()) {
            int count = map.get(c);
            if (count > 0) {
                map.put(c, count - 1);
                getPermutation(map, prefix + c, remCount - 1);

                // when we have found all branches with this character we need to restore its count
                // for the next branch
                map.put(c, count);
            }
        }
    }

}
