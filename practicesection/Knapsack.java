import java.util.HashMap;
import java.util.HashSet;

public class Knapsack {
    public static void main(String[] args) {
        int val[] = { 4, 2, 1, 2, 10 };
        int wt[] = { 12, 2, 1, 1, 4 };

        int W = 15;

        Knapsack k = new Knapsack();
        int result = k.calculateMaxProfit(wt, val, W);

        System.out.println(result);
    }
    

    private int calculateMaxProfit(int weight[], int val[], int capacity) {
        HashMap<String, Integer> cache = new HashMap<>();
        int result = calculateMaxProfitUtil(weight, val, capacity, cache, 0);
        return result;
    }


    public static String getHashKey(int remainingCapacity, int itemIndex) {
        String key = itemIndex + "|" + remainingCapacity;
        return key;
    }

    private int calculateMaxProfitUtil(
        int weight[], int val[], int remainingCapacity, HashMap<String, Integer> cache, int itemIndex
    ) {
        String key = getHashKey(remainingCapacity, itemIndex);

        if (cache.containsKey(key)) {
            System.out.println("Hit" + key);
            return cache.get(key);
        }

        int total = 0;
        // profit is 0 if the bag doesnot have space then profit is = 0
        if (remainingCapacity == 0 || itemIndex >= weight.length) {
            return 0;
        }

        if (remainingCapacity - weight[itemIndex] >= 0) {
            total = Math.max(total, val[itemIndex] + calculateMaxProfitUtil(weight, val, remainingCapacity - weight[itemIndex], cache, itemIndex + 1));
        }
        total = Math.max(
            total,
            calculateMaxProfitUtil(weight, val, remainingCapacity, cache, itemIndex + 1)
        );


        cache.put(key, total);
        return total;
    }
}
