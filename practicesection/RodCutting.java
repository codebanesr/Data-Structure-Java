import java.util.HashMap;

public class RodCutting {
    public static void main(String[] args) {
        int price[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
        // 8
        RodCutting rc = new RodCutting();

        int result = rc.findCost(price);
        System.out.println(result);
    }
    

    public int findCost(int price[]) {
        HashMap<Integer, Integer> set = new HashMap<>();
        int cost = solveUsingDp(price, set, price.length);


        return cost;
    }


    public int solveUsingDp(int price[], HashMap<Integer, Integer> cache, int remainingLen) {
        if (remainingLen == 0) {
            return 0;
        }

        if (cache.containsKey(remainingLen)) {
            return cache.get(remainingLen);
        }

        // the most important part here is the for loop, length always, always starts from 1
        // but for length 1 we have to check array index 0, thats there -> price[i-1]
        int result = 0;
        for (int i = 1; i <= price.length; i++) {
            // <= is very important on the next line
            if (i <= remainingLen) {
                result = Math.max(result, price[i-1] + solveUsingDp(price, cache, remainingLen - i));
            }
        }

        cache.put(remainingLen, result);
        return result;
    }
}
