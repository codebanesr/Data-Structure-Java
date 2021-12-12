import java.util.*;

public class BurstBalloon {
    public static void main(String[] args) throws Exception {
        int[] pricei = { 1, 2 };
        ArrayList<Integer> price = new ArrayList<>();
        for (int i = 0; i < pricei.length; i++) {
            price.add(pricei[i]);
        }

        int result = solveRecursively(price);
        System.out.println(result);
    }


    public static String getKey(ArrayList<Integer> remainingBalloons) {
        return remainingBalloons.toString();
    }


    public static int solveRecursively(ArrayList<Integer> price) throws Exception {
        HashMap<String, Integer> cache = new HashMap<>();
        int result = solveRecursivelyUtil(cache, price);


        return result;
    }
    
    public static int solveRecursivelyUtil(HashMap<String, Integer> cache, ArrayList<Integer> price)
            throws Exception {
        if (price.size() == 0) {
            return 0;
            // throw new Exception("No balloons available to burst");
        }
        if (price.size() == 1) {
            return price.get(0);
        }

        String key = getKey(price);
        if (cache.containsKey(key)) {
            System.out.println("Memo -- "+key);
            return cache.get(key);
        }

        int maxProfit = 0;
        for (int i = 0; i < price.size(); i++) {
            int left = i - 1 >= 0 ? price.get(i - 1) : 1;
            int right = i + 1 < price.size() ? price.get(i + 1) : 1;
            
            int burstprofit = left * price.get(i) * right;
            ArrayList<Integer> remainingPrice = (ArrayList<Integer>) price.clone();

            remainingPrice.remove(i);
            maxProfit = Math.max(maxProfit, burstprofit + solveRecursivelyUtil(cache, remainingPrice));
        }

        cache.put(key, maxProfit);
        return maxProfit;
    }
}