/* You are given an array of words where each word consists of lowercase English letters.
wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal to wordB.
 */
import java.util.*;
// https://leetcode.com/problems/longest-string-chain
public class LongestStringChain {
    public static void main(String[] args) {
        LongestStringChain lsc = new LongestStringChain();
        String word[] = { "a", "b", "ba", "bca", "bda", "bdca" };
        int result = lsc.findLongestStringChain(word);


        System.out.println(result);
    }

    public int findLongestStringChain(String word[]) {
        HashSet<String> words = new HashSet<>(Arrays.asList(word));
        HashMap<String, Integer> cache = new HashMap<>();

        int max = 0;
        for (String w : word) {
            int r = dfs(w, cache, words);
            max = Math.max(r, max);
        }

        return max;
    }
    

    public int dfs(String word, HashMap<String, Integer> cache, Set<String> allwords) {
        if (cache.containsKey(word)) {
            return cache.get(word);
        }

        if (word.length() == 1) {
            return 1;
        }
        
        int total = 0;
        for (int i = 0; i < word.length(); i++) {
            String key = word.substring(0, i) + word.substring(i + 1);
            if (allwords.contains(key)) {
                total = Math.max(total, 1 + dfs(key, cache, allwords));
            }
        }

        cache.put(word, total);

        return total;
    }
}
