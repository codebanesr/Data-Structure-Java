import java.util.HashMap;

public class BuyAndSellStocksKT {
    public static void main(String[] args) {
        BuyAndSellStocksKT bkt = new BuyAndSellStocksKT();
        int prices[] = { 12, 14, 17, 10, 14, 13, 12, 15 };
        int result = bkt.calcProfit(prices, 3);
        System.out.println(result);
    }
    


    static HashMap<Integer, Integer> cache = new HashMap<>();
    int calcProfit(int prices[], int K) {
        return calcProfitUtil(prices, 0, K, true);
    }


    private int calcProfitUtil(int prices[], int i, int K, boolean buy) {
        // if all k transactions are complete || all days have passed
        if (K==0 || i == prices.length) {
            return 0;
        }

        // do we have to buy or sell... we have to start by buying a stock
        if (buy) {
            return Math.max(calcProfitUtil(prices, i+1, K, true), -prices[i] + calcProfitUtil(prices, i+1, K, false));
        } 
        return Math.max(calcProfitUtil(prices, i+1, K, false), prices[i] + calcProfitUtil(prices, i+1, K-1, true));
    }
}
