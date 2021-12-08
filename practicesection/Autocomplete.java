import java.util.*;

public class Autocomplete {
    class Node {
        String prefix;
        HashMap<Character, Node> children;

        boolean isWord;

        Node(String prefix) {
            this.prefix = prefix;
            this.children = new HashMap<>();
        }
    }

    private Node trie;

    public Autocomplete(String dict[]) {
        trie = new Node("");
        for (String s : dict)
            insertWord(s);
    }


    private void insertWord(String s) {
        Node curr = trie;
        for (int i = 0; i < s.length(); i++) {
            if (!curr.children.containsKey(s.charAt(i))) {
                curr.children.put(s.charAt(i), new Node(s.substring(0, i + 1)));
            }

            curr = curr.children.get(s.charAt(i));
            if (i == s.length() - 1) {
                // this current is after adding one character and moving one place forward
                curr.isWord = true;
            }
        }
    }
    

    public List<String> getWordsForPrefix(String prefix) {
        List<String> results = new LinkedList<>();
        Node curr = trie;

        // if the for loop completes it means all
        // characters were matched so we can 
        // fill the results list and return it
        for (char c : prefix.toCharArray()) {
            if (curr.children.containsKey(c)) {
                curr = curr.children.get(c);
            } else {
                return results;
            }
        }

        findAllChildWords(curr, results);

        return results;
    }
    

    private void findAllChildWords(Node n, List<String> results) {
        if (n.isWord) {
            results.add(n.prefix);
        }

        for (Character c : n.children.keySet()) {
            findAllChildWords(n.children.get(c), results);
        }
    }
}
