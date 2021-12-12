import java.util.HashMap;

public class BuyAndSellStocksKT {
    public static void main(String[] args) {
        BuyAndSellStocksKT bkt = new BuyAndSellStocksKT();
        int prices[] = { 12, 14, 17, 10, 14, 13, 12, 15 };
        int result = bkt.calcProfit(prices, 3);
        System.out.println(result);
    }
    


    static HashMap<String, Integer> cache = new HashMap<>();
    int calcProfit(int prices[], int K) {
        return calcProfitUtil(prices, 0, K, true);
    }


    private String getKey(int k, int i) {
        return k + "|" + i;
    }

    private int calcProfitUtil(int prices[], int i, int K, boolean buy) {
        int result = 0;
        // if all k transactions are complete || all days have passed
        // if (cache.containsKey(getKey(K, i))) {
        //     return cache.get(getKey(K, i));
        // }
        if (K==0 || i == prices.length) {
            return 0;
        }

        // do we have to buy or sell... we have to start by buying a stock
        if (buy) {
            // if i dont buy we are still left with K transaction, but we will
            // not do any thing on day i and so i->i+1, and we are still in the buy phase
            // thats why passing true...., if we do buy we pay prices[i] therfore a negative
            // this will be the entire reasoning of the recursion
            result = Math.max(calcProfitUtil(prices, i+1, K, true), -prices[i] + calcProfitUtil(prices, i+1, K, false));
        } else {
            result = Math.max(calcProfitUtil(prices, i + 1, K, false),
            prices[i] + calcProfitUtil(prices, i + 1, K - 1, true));
    
        }

        cache.put(getKey(K, i), result);
        return result;
    }
}
