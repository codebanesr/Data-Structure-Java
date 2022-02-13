# How to reach the solution
1. Write a function that takes a word as argument and returns all words that can be formed after removing one letter from the word
```java
    public void chunker(String str) {
        for(int i=0; i<str.length; i++) {
            String chunk = str.substring(0, i) + str.substring(i+1, str.length);
        }
    }

2. Now use the same function to make smaller chunks from the chunk variable
```java
    public int chunker(String str) {
        int max = 0;
        for(int i=0; i<str.length; i++) {
            String chunk = str.substring(0, i) + str.substring(i+1, str.length);
            int max = Math.max(max, 1 + chunker(chunk));
        }
    }

3. Now add functionality to calculate chain length recursively
```java
    public int chunker(String str) {
        int max = 0;
        for(int i=0; i<str.length; i++) {
            String chunk = str.substring(0, i) + str.substring(i+1, str.length);
            int max = Math.max(max, 1 + chunker(chunk));
        }
        return max;
    }
4. Finally add base case and caching
```java
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
